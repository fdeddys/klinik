/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.repository;

import com.ddabadi.keuangan.model.TransaksiHd;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author win7
 */
public interface TransaksiHdRepository extends JpaRepository<TransaksiHd, Long> {
   
    @Query(value = "select t from TransaksiHd t where t.tanggal = :tgl")
    public List<TransaksiHd> findByTgl(@Param("tgl")Date tgl);
    
}
