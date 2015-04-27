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

/**
 *
 * @author win7
 */

@Entity
@Table(name = "tbl_params")
public class Params implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @Column(name="h1", length=50)
    private String h1;
    
    @Column(name="h2", length=50)
    private String h2;
    
    @Column(name="h3", length=50)
    private String h3;
    
    @Column(name="h4", length=50)
    private String h4;

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    public String getH4() {
        return h4;
    }

    public void setH4(String h4) {
        this.h4 = h4;
    }
    
    
    
    @Column(name="modal_awal")
    private Double modalAwal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getModalAwal() {
        return modalAwal;
    }

    public void setModalAwal(Double modalAwal) {
        this.modalAwal = modalAwal;
    }
    
    
    
}
