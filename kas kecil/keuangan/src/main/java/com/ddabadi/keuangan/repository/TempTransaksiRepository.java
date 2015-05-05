/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.repository;

import com.ddabadi.keuangan.model.TempTransaksi;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author win7
 */
public interface TempTransaksiRepository extends JpaRepository<TempTransaksi, Long> {
    
    @Query(value = "select t from TempTransaksi t where t.isProses = :isProses and t.tglTransaksi = :tglTransaksi ")
    public List<TempTransaksi> findAll(@Param("isProses")int isProses, @Param("tglTransaksi")Date tglTransaksi);
   
    @Query(value = "select t from TempTransaksi t where t.noBukti = :noBukti ")
    public List<TempTransaksi> findByNoBukti(@Param("noBukti")String noBukti);
}
