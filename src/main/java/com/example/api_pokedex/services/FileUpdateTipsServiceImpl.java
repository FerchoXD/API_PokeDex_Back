package com.example.api_pokedex.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.api_pokedex.entities.Tips;
import com.example.api_pokedex.services.interfaces.IFileUpdateTipsService;
import com.example.api_pokedex.services.interfaces.ITipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
@Service
public class FileUpdateTipsServiceImpl implements IFileUpdateTipsService {
    @Autowired
    private ITipsService TipsService;

    private AmazonS3 s3client;

    private String ENDPOINT_URL = "s3.us-east-2.amazonaws.com";

    private String BUCKET_NAME = "bucket-pokedex";

    private String ACCESS_KEY = "AKIA2KYSLO7KIXRKU37Q";

    private String SECRET_KEY = "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";


    public String upload(MultipartFile multipartFile, Long idTips) {
        String fileUrl = "";

        try {
            File file = convertMultiPartToFile(multipartFile);

            String fileName = generateFileName(multipartFile);

            fileUrl = "https://" + BUCKET_NAME + "." + ENDPOINT_URL +"/" +fileName;

            uploadFileToS3Bucket(fileName, file);

            file.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }

        updateTrainerImage(fileUrl,idTips);

        return fileUrl;
    }

    private void updateTrainerImage(String ImageUrl,Long idTips){
        Tips tips = TipsService.FindOneAndEnsurePicture(idTips);
        tips.setImage(ImageUrl);
        TipsService.save(tips);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileToS3Bucket(String fileName, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead);
        s3client.putObject(putObjectRequest);
    }

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();
    }
}
