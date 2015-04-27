/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao.impl;

import com.ddabadi.keuangan.dao.ParamsDao;
import com.ddabadi.keuangan.model.Params;
import com.ddabadi.keuangan.repository.ParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author win7
 */
@Service
public class ParamsDaoImpl implements ParamsDao {

    @Autowired
    private ParamsRepository paramsRepository;
    
    
    @Override
    public Params save(Params params) {
        return paramsRepository.save(params);
    }

    @Override
    public Params getParams() {
        return paramsRepository.findAll().iterator().next();
    }
    
}
