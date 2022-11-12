package com.example.api_pokedex.entities;


import com.example.api_pokedex.entities.pivots.TrainersForum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forums")
@Getter
@Setter
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    @JsonFormat(pattern="yyyy-MM-dd")
    private String date;

    @JsonFormat(pattern="HH:mm:ss")
    private String hour;

    @OneToMany(mappedBy = "forum")
    private List<TrainersForum> trainersForum;
}
