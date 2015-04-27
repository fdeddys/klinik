/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.dao.impl;

import com.ddabadi.keuangan.dao.HistoryDao;
import com.ddabadi.keuangan.dao.JenisTransaksiDao;
import com.ddabadi.keuangan.dao.ParamsDao;
import com.ddabadi.keuangan.dao.TransaksiHdDao;
import com.ddabadi.keuangan.dao.UrutNoTransaksiDao;
import com.ddabadi.keuangan.enumerate.TipeTransaksi;
import com.ddabadi.keuangan.model.History;
import com.ddabadi.keuangan.model.JenisTransaksi;
import com.ddabadi.keuangan.model.TransaksiHd;
import com.ddabadi.keuangan.repository.HistoryRepository;
import com.ddabadi.keuangan.repository.TransaksiHdRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author win7
 */
@Service
@Transactional
public class TransaksiHdDaoImpl implements TransaksiHdDao {

    @Autowired
    private TransaksiHdRepository transaksiHdRepository;
    @Autowired
    private ParamsDao paramsDao;
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private UrutNoTransaksiDao urutNoTransaksiDao;
    @Autowired
    private JenisTransaksiDao jenisTransaksiDao;
        
    @Override
    @Transactional(readOnly = true)
    public List<TransaksiHd> getTransaksiByDate(Date tgl) {
        return transaksiHdRepository.findByTgl(tgl);
    }

    
    @Override
    @Transactional(readOnly = true)
    public TransaksiHd getById(Long id) {
        return transaksiHdRepository.findOne(id);
    }

    @Override
    public TransaksiHd save(TransaksiHd transaksiHd) {
        
        Double saldoTerakhir;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        String tahun= sdf.format(transaksiHd.getTanggal()) ;
        String noTransaksi = urutNoTransaksiDao.generateNoTransaksi(transaksiHd.getTipeTransaksi(),  tahun);
        transaksiHd.setNoTransaksi(noTransaksi);
        // Cek HISTORY ada transaksi ga tanggal tsb
        List<History> lists = historyDao.getByDate(transaksiHd.getTanggal());
        if(lists.size()>0){
            // history SUDAH ADA transaksi pada tgl ini
            History lastHistory = lists.get(lists.size()-1);
            saldoTerakhir= lastHistory.getSaldo();
        }else{
            // history BELUM ADA transaksi pada tanggal ini.
            // ambil MODAL AWAL
            saldoTerakhir = paramsDao.getParams().getModalAwal();
            
            // Buat setoran awal
            History historyNew=new History();
            historyNew.setKeterangan("Modal awal");
            historyNew.setNoTransaksi("MODAL");
            historyNew.setTanggal(new Date());                    
            historyNew.setDebet(saldoTerakhir);
            historyNew.setKredit(0D);
            historyNew.setSaldo(saldoTerakhir);       
            historyNew.setTipeTransaksi(TipeTransaksi.penerimaan);
            historyDao.save(historyNew);            
            // End setoran awal            
        }
        JenisTransaksi jenisTransaksi = jenisTransaksiDao.findById(transaksiHd.getJenisTransaksi().getId());
        History history=new History();
        history.setKeterangan(jenisTransaksi.getNamaJenisTransaksi().trim() + " " + transaksiHd.getKeterangan());
        history.setNoTransaksi(transaksiHd.getNoTransaksi());
        history.setTanggal(transaksiHd.getTanggal());        
        if(transaksiHd.getTipeTransaksi().equals(TipeTransaksi.penerimaan)){
            history.setDebet(transaksiHd.getTotal());
            history.setKredit(0D);
            history.setSaldo(saldoTerakhir+transaksiHd.getTotal());
        }else{
            history.setDebet(0D);
            history.setKredit(transaksiHd.getTotal());
            history.setSaldo(saldoTerakhir-transaksiHd.getTotal());
        }
        history.setTipeTransaksi(transaksiHd.getTipeTransaksi());
        historyDao.save(history);
        return transaksiHdRepository.save(transaksiHd);
        
    }

    @Override
    public TransaksiHd edit(TransaksiHd transaksiHd) {
        return transaksiHdRepository.saveAndFlush(transaksiHd);
    }
    
}
