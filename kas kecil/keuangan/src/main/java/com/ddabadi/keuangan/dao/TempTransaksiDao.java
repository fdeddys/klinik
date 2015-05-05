/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao;

import com.ddabadi.keuangan.model.TempTransaksi;
import java.util.Date;
import java.util.List;

/**
 *
 * @author win7
 */
public interface TempTransaksiDao {
    
    public List<TempTransaksi > getAllTransaksi(Date tgl, int isProses);
    public void updateProses(Long id);
    public void batalProses(Long id);
    public TempTransaksi getById(Long id);
    public TempTransaksi getByNoBukti(String noBukti);
    
}
