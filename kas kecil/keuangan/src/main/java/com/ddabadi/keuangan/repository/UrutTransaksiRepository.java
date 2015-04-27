/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.repository;

import com.ddabadi.keuangan.enumerate.TipeTransaksi;
import com.ddabadi.keuangan.model.UrutNoTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author win7
 */
public interface UrutTransaksiRepository extends JpaRepository<UrutNoTransaksi,Integer> {
    
    @Query(value = "Select u from UrutNoTransaksi u where u.tipeTransaksi = :tipeTransaksi and u.tahun = :tahun ")
    UrutNoTransaksi findByTipeTahun(@Param("tipeTransaksi")TipeTransaksi tipeTransaksi, 
                                    @Param("tahun")String tahun);
}
