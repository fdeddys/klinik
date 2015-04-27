/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Index;

/**
 *
 * @author win7
 */

@Entity
@Table(name="tbl_jenis_transaksi")
public class JenisTransaksi implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_Jenis_Transaksi")
    private Long id;
    
    @Column(name="nama_jenis_transaksi", length = 50)
    @Index(name = "ix_jenis")
    private String namaJenisTransaksi;
    
    @Column(name="isDebet")
    private int debet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaJenisTransaksi() {
        return namaJenisTransaksi;
    }

    public void setNamaJenisTransaksi(String namaJenisTransaksi) {
        this.namaJenisTransaksi = namaJenisTransaksi;
    }

    public int getDebet() {
        return debet;
    }

    public void setDebet(int debet) {
        this.debet = debet;
    }  
    
}
