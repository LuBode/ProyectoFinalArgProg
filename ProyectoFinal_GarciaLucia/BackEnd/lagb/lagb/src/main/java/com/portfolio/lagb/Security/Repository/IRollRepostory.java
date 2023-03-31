/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.lagb.Security.Repository;

import com.portfolio.lagb.Security.Entity.Roll;
import com.portfolio.lagb.Security.Enums.RollNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRollRepostory extends JpaRepository<Roll, Integer>{
    Optional<Roll> findByRollNombre(RollNombre rollNombre);
}
