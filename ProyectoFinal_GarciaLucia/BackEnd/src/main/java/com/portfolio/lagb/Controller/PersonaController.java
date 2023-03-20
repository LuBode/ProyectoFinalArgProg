package com.portfolio.lagb.Controller;

import com.portfolio.lagb.Entity.Persona;
import com.portfolio.lagb.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    
    @GetMapping("persona/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "El usuario fue creado correctamente";
    }
    
    @DeleteMapping("/persona/borrar/(id)")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "El usuario se elimino con exito";
    }
    
    @PutMapping("/persona/editar/(id)")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("imagen") String nuevoImagen){    
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImagen);
        
        ipersonaService.savePersona(persona);
        return persona;  
    }
    
    @GetMapping("/persona/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}   
