package com.example.producerkafka.model;

import java.util.List;

public class ApiRequest {
    private String id;
    private String nombre;
    private List<SenalVital> senales;


    // Constructor
    public ApiRequest(String id, String nombre, List<SenalVital> senales) {
        this.id = id;
        this.nombre = nombre;
        this.senales = senales;

    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<SenalVital> getSenalesVitales(){
        return senales;
    }

    public void setSenales(List<SenalVital> senales){
        this.senales = senales;
    }
    
    

  
}

