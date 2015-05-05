/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao.impl;

import com.ddabadi.keuangan.dao.KwitansiDao;
import com.ddabadi.keuangan.dao.UrutNoTransaksiDao;
import com.ddabadi.keuangan.model.Kwitansi;
import com.ddabadi.keuangan.repository.KwitansiRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author win7
 */

@Service
public class KwitansiDaoImpl implements KwitansiDao {
    
    @Autowired
    private KwitansiRepository kwitansiRepository;
    @Autowired
    private UrutNoTransaksiDao urutNoTransaksiDao;

    @Override
    public String generateNoKwitansi(Date tgl) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        String tahun = sdf.format(tgl);
        return urutNoTransaksiDao.generateNoKwitansi(tahun);
    }

    @Override
    public void save(Kwitansi kwitansi) {
        kwitansiRepository.save(kwitansi);
    }

    @Override
    public Kwitansi getById(Long id) {
        return kwitansiRepository.findOne(id);
    }
    
}
