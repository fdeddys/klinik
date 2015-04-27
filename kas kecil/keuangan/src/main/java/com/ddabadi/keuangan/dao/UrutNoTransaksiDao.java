/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao;

import com.ddabadi.keuangan.enumerate.TipeTransaksi;
import com.ddabadi.keuangan.model.UrutNoTransaksi;

/**
 *
 * @author win7
 */
public interface UrutNoTransaksiDao {

    public UrutNoTransaksi save(UrutNoTransaksi urutNoTransaksi);
    public UrutNoTransaksi findByTipeTransaksiTahun(TipeTransaksi tipeTransaksi, String tahun);
    public String generateNoTransaksi(TipeTransaksi tipeTransaksi, String tahun);
}
