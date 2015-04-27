/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao.impl;

import com.ddabadi.keuangan.dao.HistoryDao;
import com.ddabadi.keuangan.model.History;
import com.ddabadi.keuangan.repository.HistoryRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author win7
 */
@Service
public class HistoryDaoImpl implements HistoryDao {

    @Autowired
    private HistoryRepository historyRepository;
    
    @Override
    public void save(History history) {
        historyRepository.save(history);
    }

    @Override
    public List<History> getByDate(Date tgl) {
        return historyRepository.findByTgl(tgl);
    }
    
}
