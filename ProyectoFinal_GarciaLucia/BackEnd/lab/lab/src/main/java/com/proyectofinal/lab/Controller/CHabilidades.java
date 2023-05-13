/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectofinal.lab.Controller;

import com.proyectofinal.lab.DTO.dtoHabilidades;
import com.proyectofinal.lab.Entity.Habilidades;
import com.proyectofinal.lab.Security.Controller.Mensaje;
import com.proyectofinal.lab.Service.SHabilidades;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/habilidades")

public class CHabilidades {
    @Autowired
    SHabilidades sHabilidades;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = sHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtoskills) {
        if (StringUtils.isBlank(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sHabilidades.existsByNombre(dtoskills.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidades educacion = new Habilidades(dtoskills.getNombre(), dtoskills.getPorcentaje());
        sHabilidades.save(educacion);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidades dtoskills){
        //validacion de id
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        if(sHabilidades.existsByNombre(dtoskills.getNombre()) && sHabilidades.getByNombre(dtoskills.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Habilidad existente"), HttpStatus.BAD_REQUEST);
    
        if(StringUtils.isBlank(dtoskills.getNombre()))
            return new ResponseEntity(new Mensaje("No puede estar vacio"), HttpStatus.BAD_REQUEST);
        
        Habilidades habilidades = sHabilidades.getOne(id).get();
        habilidades.setNombre(dtoskills.getNombre());
        habilidades.setPorcentaje(dtoskills.getPorcentaje());
        
        sHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        
        sHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/details/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!sHabilidades.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        Habilidades habilidades = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
}
