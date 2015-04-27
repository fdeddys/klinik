/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao;

import com.ddabadi.keuangan.model.History;
import java.util.Date;
import java.util.List;

/**
 *
 * @author win7
 */
public interface HistoryDao {

    public void save(History history);
    public List<History> getByDate(Date tgl);
}
