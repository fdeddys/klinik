/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao.impl;

import com.ddabadi.keuangan.dao.UrutNoTransaksiDao;
import com.ddabadi.keuangan.enumerate.TipeTransaksi;
import com.ddabadi.keuangan.model.UrutNoTransaksi;
import com.ddabadi.keuangan.repository.UrutTransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author win7
 */

@Service
@Transactional
public class UrutNoTransaksiDaoImpl implements UrutNoTransaksiDao {
    
    @Autowired
    private UrutTransaksiRepository urutTransaksiRepository;

    @Override
    public UrutNoTransaksi save(UrutNoTransaksi urutNoTransaksi) {
        return urutTransaksiRepository.save(urutNoTransaksi);
    }

    @Override
    @Transactional(readOnly = true)
    public UrutNoTransaksi findByTipeTransaksiTahun(TipeTransaksi tipeTransaksi, String tahun) {
        return urutTransaksiRepository.findByTipeTahun(tipeTransaksi, tahun);
    }

    @Override
    public String generateNoTransaksi(TipeTransaksi tipeTransaksi, String tahun) {
        String noBaru;
        UrutNoTransaksi urutNoTransaksi = this.findByTipeTransaksiTahun(tipeTransaksi, tahun);
        if(urutNoTransaksi==null){
            urutNoTransaksi = new UrutNoTransaksi();
            urutNoTransaksi.setTahun(tahun);
            urutNoTransaksi.setTipeTransaksi(tipeTransaksi);
            urutNoTransaksi.setUrut(1);
            this.save(urutNoTransaksi);
            noBaru ="TR" + tahun.trim() + "00001";
        }else{
            Integer noLama= urutNoTransaksi.getUrut();

            urutNoTransaksi.setUrut(noLama + 1);
            urutTransaksiRepository.save(urutNoTransaksi);
            
            noLama = noLama +1;
            noBaru = (noLama).toString().trim();
            noBaru = "0000" + noBaru;
            noBaru = noBaru.substring(noBaru.length()-4, noBaru.length());
            noBaru = "TR" + tahun.trim()  + noBaru;
        }
                
        return noBaru;
    }

    @Override
    public String generateNoKwitansi(String tahun) {
        String noBaru;
        UrutNoTransaksi urutNoTransaksi = this.findByTipeTransaksiTahun(TipeTransaksi.kwitansi, tahun);
        if(urutNoTransaksi==null){
            urutNoTransaksi = new UrutNoTransaksi();
            urutNoTransaksi.setTahun(tahun);
            urutNoTransaksi.setTipeTransaksi(TipeTransaksi.kwitansi);
            urutNoTransaksi.setUrut(1);
            this.save(urutNoTransaksi);
            noBaru ="KW" + tahun.trim() + "00001";
        }else{
            Integer noLama= urutNoTransaksi.getUrut();

            urutNoTransaksi.setUrut(noLama + 1);
            urutTransaksiRepository.save(urutNoTransaksi);
            
            noLama = noLama +1;
            noBaru = (noLama).toString().trim();
            noBaru = "0000" + noBaru;
            noBaru = noBaru.substring(noBaru.length()-4, noBaru.length());
            noBaru = "KW" + tahun.trim()  + noBaru;
        }
                
        return noBaru;
    }
        
}

