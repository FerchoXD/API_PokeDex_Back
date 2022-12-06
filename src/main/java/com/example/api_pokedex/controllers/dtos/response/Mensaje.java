package com.example.api_pokedex.controllers.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensaje {
    private String Mensaje;

    public Mensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
