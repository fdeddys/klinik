/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao;

import com.ddabadi.keuangan.model.JenisTransaksi;
import java.util.List;

/**
 *
 * @author win7
 */
public interface JenisTransaksiDao {
    
    public List<JenisTransaksi> getAll();
    public JenisTransaksi save(JenisTransaksi jenisTransaksi);
    public JenisTransaksi edit(JenisTransaksi jenisTransaksi);
    public void delete(Long idJenisTransaksi);
    public JenisTransaksi findById(Long id);
}
