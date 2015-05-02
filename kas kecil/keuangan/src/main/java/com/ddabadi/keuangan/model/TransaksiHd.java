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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Index;

/**
 *
 * @author win7
 */

@Entity
@Table(name = "tbl_transaksi_hd")
public class TransaksiHd implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_transaksi_hd")
    private Long id;    
    
    @Column(name="tanggal")
    @Temporal(TemporalType.DATE)
    @Index(name="ix_tgl")
    private Date tanggal;
    
    @Column(name="is_approve")
    private int isApprove;
    
    @Column(name="is_cancel")
    private int isCancel;
    
    @Column(name="total")
    private Double total;
    
    @Column(name="tipe_transaksi")
    private TipeTransaksi tipeTransaksi;
    
    @Column(name="keterangan", length =100)
    private String keterangan;
    
    @Column(name="no_Transaksi", length = 50)
    private String noTransaksi;
        
    @OneToOne
    @JoinColumn(name="jenis_transaksi")
    private JenisTransaksi jenisTransaksi;
    
    @ManyToOne
    @JoinColumn(name="kwitansi")
    private Kwitansi kwitansi;

    public Kwitansi getKwitansi() {
        return kwitansi;
    }

    public void setKwitansi(Kwitansi kwitansi) {
        this.kwitansi = kwitansi;
    }
        
    public JenisTransaksi getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(JenisTransaksi jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
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

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(int isApprove) {
        this.isApprove = isApprove;
    }

    public int getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(int isCancel) {
        this.isCancel = isCancel;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public TipeTransaksi getTipeTransaksi() {
        return tipeTransaksi;
    }

    public void setTipeTransaksi(TipeTransaksi tipeTransaksi) {
        this.tipeTransaksi = tipeTransaksi;
    }
    
    
}
