/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.lagb.Security.Service;

import com.portfolio.lagb.Security.Entity.Roll;
import com.portfolio.lagb.Security.Enums.RollNombre;
import com.portfolio.lagb.Security.Repository.IRollRepostory;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RollService {
    @Autowired
    IRollRepostory iRollRepository;
    
    public Optional<Roll> getByRollNombre(RollNombre rollNombre){
        return iRollRepository.findByRollNombre(rollNombre);
    }
    
    public void save(Roll roll){
        iRollRepository.save(roll);
    }
}
