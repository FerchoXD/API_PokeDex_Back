package com.example.api_pokedex.entities;

import com.example.api_pokedex.entities.pivots.TrainersLeague;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "leagues")
@Getter @Setter
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;

    private String region;

    @OneToMany(mappedBy = "league")
    private List<TrainersLeague> trainersLeagues;
}

