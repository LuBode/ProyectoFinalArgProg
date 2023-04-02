/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.lab.Interface;

import com.proyectofinal.lab.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista personas
    public List<Persona> getPersona();
    
    //Guardar personas
    public void savePersona(Persona persona);
    
    //Eliminar una persona por id
    public void deletePersona(Long id);
    
    //Buscar persona por id
    public Persona findPersona(Long id);
    
}

