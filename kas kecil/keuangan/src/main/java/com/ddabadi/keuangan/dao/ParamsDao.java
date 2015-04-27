/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao;

import com.ddabadi.keuangan.model.Params;

/**
 *
 * @author win7
 */
public interface ParamsDao {
    
    public Params save(Params params);
    public Params getParams();
}
