
package com.portfolio.lagb.Security.Entity;

import com.portfolio.lagb.Security.Enums.RollNombre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Roll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RollNombre rollNombre;
    
    //Constructor

    public Roll() {
    }

    public Roll(RollNombre rollNombre) {
        this.rollNombre = rollNombre;
    }
    
    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RollNombre getRollNombre() {
        return rollNombre;
    }

    public void setRollNombre(RollNombre rollNombre) {
        this.rollNombre = rollNombre;
    }
    
}
