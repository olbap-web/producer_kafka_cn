package com.example.producerkafka.model;

public class SenalVital {
    private String nombre;
    private String valor;


    // Constructor
    public SenalVital(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
