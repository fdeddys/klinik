/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao;

import com.ddabadi.keuangan.model.TransaksiHd;
import java.util.Date;
import java.util.List;

/**
 *
 * @author win7
 */
public interface TransaksiHdDao {

    public List<TransaksiHd> getTransaksiByDate(Date tgl);
    public TransaksiHd getById(Long id);
    public TransaksiHd save(TransaksiHd transaksiHd);
    public TransaksiHd edit(TransaksiHd transaksiHd);
}
