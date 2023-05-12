/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.lab.DTO;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String dscripcionE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String dscripcionE) {
        this.nombreE = nombreE;
        this.dscripcionE = dscripcionE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDscripcionE() {
        return dscripcionE;
    }

    public void setDscripcionE(String dscripcionE) {
        this.dscripcionE = dscripcionE;
    }
    
}
