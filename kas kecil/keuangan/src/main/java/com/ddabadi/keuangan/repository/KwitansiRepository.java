/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.repository;

import com.ddabadi.keuangan.model.Kwitansi;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author win7
 */
public interface KwitansiRepository extends JpaRepository<Kwitansi, Long> {
    
}
