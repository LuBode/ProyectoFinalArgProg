package com.portfolio.lagb.Interface;

import com.portfolio.lagb.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //Trae una lista de personas
    public List<Persona> getPersona();

    //Guardar personas
    public void savePersona(Persona persona);

    //Eliminar persona por ID
    public void deletePersona(Long id);

    //Buscar por ID
    public Persona findPersona(Long id);

}