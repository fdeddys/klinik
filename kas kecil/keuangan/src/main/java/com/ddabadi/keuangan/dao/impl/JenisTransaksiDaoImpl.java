/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao.impl;

import com.ddabadi.keuangan.dao.JenisTransaksiDao;
import com.ddabadi.keuangan.model.JenisTransaksi;
import com.ddabadi.keuangan.repository.JenisTransaksiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author win7
 */
@Service
@Transactional(readOnly = true)
public class JenisTransaksiDaoImpl implements JenisTransaksiDao {

    @Autowired
    private JenisTransaksiRepository repository;
    
    @Override    
    public List<JenisTransaksi> getAll() {
        
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public JenisTransaksi save(JenisTransaksi jenisTransaksi) {
        return repository.save(jenisTransaksi);
    }

    @Override
    @Transactional(readOnly = false)
    public JenisTransaksi edit(JenisTransaksi jenisTransaksi) {
        return repository.saveAndFlush(jenisTransaksi);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long idJenisTransaksi) {
        repository.delete(idJenisTransaksi);
    }

    @Override
    public JenisTransaksi findById(Long id) {
        return repository.findOne(id);
    }
    
}
