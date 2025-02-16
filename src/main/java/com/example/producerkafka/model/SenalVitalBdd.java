 
package com.example.producerkafka.model;

import jakarta.persistence.Table;

@Table(name = "SENAL_VITAL") 
public class SenalVitalBdd {
    private Long idSenalVital;    
    private String descripcion;   
    private String unidad;        
    private Long idPaciente;      

    // Constructor
    public SenalVitalBdd(Long idSenalVital, String descripcion, String unidad, Long idPaciente) {
        this.idSenalVital = idSenalVital;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.idPaciente = idPaciente;
    }

    // Getters y Setters
    public Long getIdSenalVital() {
        return idSenalVital;
    }

    public void setIdSenalVital(Long idSenalVital) {
        this.idSenalVital = idSenalVital;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
