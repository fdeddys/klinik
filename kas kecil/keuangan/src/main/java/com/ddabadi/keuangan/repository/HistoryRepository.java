/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.repository;

import com.ddabadi.keuangan.model.History;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author win7
 */
public interface HistoryRepository extends JpaRepository<History,Long> {
    
    /**
     * call history by date
     * @param tgl     
     * @return list
     */
    @Query(value = "select h from History h where h.tanggal = :tgl order by h.id asc")
    public List<History> findByTgl(@Param("tgl")Date tgl);
}
