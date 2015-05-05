/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao.impl;

import com.ddabadi.keuangan.dao.TempTransaksiDao;
import com.ddabadi.keuangan.model.TempTransaksi;
import com.ddabadi.keuangan.repository.TempTransaksiRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author win7
 */
@Service
public class TempTransaksiDaoImpl implements TempTransaksiDao {

    @Autowired
    private TempTransaksiRepository repository;       

    @Override
    public void updateProses(Long id) {
        TempTransaksi tempProses = repository.findOne(id);
        tempProses.setIsProses(1);
        repository.save(tempProses);
    }

    @Override
    public void batalProses(Long id) {
        TempTransaksi tempProses = repository.findOne(id);
        tempProses.setIsProses(0);
        repository.save(tempProses);
    }

    @Override
    public List<TempTransaksi > getAllTransaksi(Date tgl, int isProses) {
        return repository.findAll(isProses,tgl );        
    }

    @Override
    public TempTransaksi getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public TempTransaksi getByNoBukti(String noBukti) {
        return repository.findByNoBukti(noBukti).iterator().next();
    }
        
}
