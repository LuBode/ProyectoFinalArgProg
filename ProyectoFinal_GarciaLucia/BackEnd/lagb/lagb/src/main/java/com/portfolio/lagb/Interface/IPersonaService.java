package com.portfolio.lagb.Interface;

import com.portfolio.lagb.Entity.Persona;
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
