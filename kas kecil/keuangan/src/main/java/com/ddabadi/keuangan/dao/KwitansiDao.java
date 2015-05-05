/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao;

import com.ddabadi.keuangan.model.Kwitansi;
import java.util.Date;

/**
 *
 * @author win7
 */
public interface KwitansiDao {
    
    public String generateNoKwitansi(Date tgl);
    public void save(Kwitansi kwitansi);
    public Kwitansi getById(Long id);
    
}
