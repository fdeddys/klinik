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
@Table(name = "tbl_history_transaksi")
public class History implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="tgl")
    private Date tanggal;
    
    @Column(name="NoTransaksi", length = 50)
    private String noTransaksi;
    
    @Column(name="keterangan", length=100)
    private String keterangan;
    
    @Column(name="debet")
    private Double debet;
    
    @Column(name="kredit")
    private Double kredit;
    
    @Column(name="saldo")
    private Double saldo;
    
    @Column(name="tipe_transaksi")
    private TipeTransaksi tipeTransaksi;

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public TipeTransaksi getTipeTransaksi() {
        return tipeTransaksi;
    }

    public void setTipeTransaksi(TipeTransaksi tipeTransaksi) {
        this.tipeTransaksi = tipeTransaksi;
    }
        
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
        

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Double getDebet() {
        return debet;
    }

    public void setDebet(Double debet) {
        this.debet = debet;
    }

    public Double getKredit() {
        return kredit;
    }

    public void setKredit(Double kredit) {
        this.kredit = kredit;
    }
    
          
    
}
