/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.model;

import com.ddabadi.keuangan.enumerate.TipeTransaksi;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author win7
 */

@Entity
@Table(name="tbl_temp_transaksi")
public class TempTransaksi implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    
    @Column(name="tipe_transaksi")
    private TipeTransaksi tipeTransaksi;
    
    @Column(name="no_bukti")
    private String noBukti;
    
    @Column(name="no_Rm")
    private String noRM;
    
    @Column(name="nama")
    private String nama;
    
    @Column(name="total")
    private Double total;
    
    @Column(name="is_proses", columnDefinition = "integer default 0")    
    private int isProses;
    
    @Temporal(TemporalType.DATE)
    @Column(name="tgl")
    private Date tglTransaksi;

    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }        

    public int getIsProses() {
        return isProses;
    }

    public void setIsProses(int isProses) {
        this.isProses = isProses;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipeTransaksi getTipeTransaksi() {
        return tipeTransaksi;
    }

    public void setTipeTransaksi(TipeTransaksi tipeTransaksi) {
        this.tipeTransaksi = tipeTransaksi;
    }

    public String getNoBukti() {
        return noBukti;
    }

    public void setNoBukti(String noBukti) {
        this.noBukti = noBukti;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNoRM() {
        return noRM;
    }

    public void setNoRM(String noRM) {
        this.noRM = noRM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
}
