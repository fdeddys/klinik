/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.model;

import com.ddabadi.keuangan.enumerate.TipeTransaksi;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author win7
 */

@Entity
@Table(name="Tbl_urut_transaksi")
public class UrutNoTransaksi implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @Column(name="tipe_transaksi")
    private TipeTransaksi tipeTransaksi;
    
    @Column(name="tahun", length = 4)
    private String tahun;
    
    @Column(name="urut")
    private Integer urut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipeTransaksi getTipeTransaksi() {
        return tipeTransaksi;
    }

    public void setTipeTransaksi(TipeTransaksi tipeTransaksi) {
        this.tipeTransaksi = tipeTransaksi;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public Integer getUrut() {
        return urut;
    }

    public void setUrut(Integer urut) {
        this.urut = urut;
    }
    
    
    
}
