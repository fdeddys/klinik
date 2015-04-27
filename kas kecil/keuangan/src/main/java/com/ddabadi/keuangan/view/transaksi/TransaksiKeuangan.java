/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.view.transaksi;

import static com.ddabadi.keuangan.App.context;
import com.ddabadi.keuangan.controller.ReportController;
import com.ddabadi.keuangan.dao.JenisTransaksiDao;
import com.ddabadi.keuangan.dao.ParamsDao;
import com.ddabadi.keuangan.dao.TransaksiHdDao;
import com.ddabadi.keuangan.dto.SlipDto;
import com.ddabadi.keuangan.enumerate.TipeTransaksi;
import com.ddabadi.keuangan.model.JenisTransaksi;
import com.ddabadi.keuangan.model.Params;
import com.ddabadi.keuangan.model.TransaksiHd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author win7
 */
public class TransaksiKeuangan extends javax.swing.JFrame {

    /**
     * Creates new form TransaksiKeuangan
     * @param pesan
     */
    
    private final TransaksiHdDao transaksiHdDao;   
    private final ParamsDao paramsDao;
    private final JenisTransaksiDao jenisTransaksiDao;
        
    private Boolean transaksiPenerimaan;
    
     
    private void isiComboJenisTransaksi(){
        cmbJenisTransaksi.removeAllItems();
        Iterator<JenisTransaksi> jenisTransaksis= jenisTransaksiDao.getAll().iterator();
        while (jenisTransaksis.hasNext()){
           JenisTransaksi jenisTransaksi = jenisTransaksis.next();
           if(transaksiPenerimaan){
               if(jenisTransaksi.getDebet()==1){
                   cmbJenisTransaksi.addItem( new ComboItem(jenisTransaksi.getNamaJenisTransaksi(), jenisTransaksi.getId()) );
               }                
           }else{
               if(jenisTransaksi.getDebet()!=1){
                   cmbJenisTransaksi.addItem( new ComboItem(jenisTransaksi.getNamaJenisTransaksi(), jenisTransaksi.getId()) );
               }
           }
        }
        
        
    }
    
    public TransaksiKeuangan(String pesan) {
        initComponents();
        transaksiHdDao=(TransaksiHdDao) context.getBean("transaksiHdDao");
        paramsDao=(ParamsDao) context.getBean("paramsDao");
        jenisTransaksiDao=(JenisTransaksiDao) context.getBean("jenisTransaksiDao");
        
        if(pesan.equals("0")){
            lblJudul.setText("Transaksi Penerimaan ");
            transaksiPenerimaan=true;
        } else {
            if(pesan.equals("1")){
                transaksiPenerimaan=false;
                lblJudul.setText("Transaksi Pengeluaran");
            }else{
                lblJudul.setText("Transaksi ");
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        txtTgl.setText(sdf.format(new Date()));   
        isiComboJenisTransaksi();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblJudul = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTgl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnPreview = new javax.swing.JButton();
        txtNoTransaksi = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        cmbJenisTransaksi = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        lblJudul.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblJudul.setForeground(new java.awt.Color(255, 255, 255));
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJudul.setText("Transaksi");
        lblJudul.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJudul)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel2.setText("ID");

        txtId.setEditable(false);

        jLabel3.setText("Tanggal");

        txtTgl.setEditable(false);

        jLabel4.setText("Jenis");

        txtKeterangan.setColumns(20);
        txtKeterangan.setRows(5);
        jScrollPane1.setViewportView(txtKeterangan);

        jLabel5.setText("Jumlah");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnPreview.setText("preview");
        btnPreview.setEnabled(false);
        btnPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviewActionPerformed(evt);
            }
        });

        cmbJenisTransaksi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("keterangan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbJenisTransaksi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(127, 127, 127)
                                        .addComponent(txtNoTransaksi))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(29, 29, 29))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbJenisTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnPreview))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(txtKeterangan.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Keterangan belum ada!!", "Error saving!",JOptionPane.WARNING_MESSAGE);
        }else{
            Double jumlah;
        
            try{
                Object item = cmbJenisTransaksi.getSelectedItem();
                Long value = ((ComboItem)item).getValue();
                JenisTransaksi jenisTransaksi = jenisTransaksiDao.findById(value);
                
                jumlah = Double.parseDouble(txtJumlah.getText());
                TransaksiHd transaksiHd = new TransaksiHd();
                transaksiHd.setIsApprove(1);
                transaksiHd.setIsCancel(0);
                transaksiHd.setTanggal(new Date());
                transaksiHd.setKeterangan(txtKeterangan.getText().trim());
                if(transaksiPenerimaan.equals(Boolean.TRUE)){
                    transaksiHd.setTipeTransaksi(TipeTransaksi.penerimaan);
                }else{
                    transaksiHd.setTipeTransaksi(TipeTransaksi.pengeluaran);
                }
                transaksiHd.setTotal(jumlah);
                transaksiHd.setJenisTransaksi(jenisTransaksi);
                transaksiHdDao.save(transaksiHd);
                txtId.setText(transaksiHd.getId().toString());
                txtNoTransaksi.setText(transaksiHd.getNoTransaksi());
                btnPreview.setEnabled(true);
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,e.getMessage(), "Error saving!",JOptionPane.WARNING_MESSAGE);
            }
        }
             
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviewActionPerformed
        // TODO add your handling code here:
        try{
            Params params = paramsDao.getParams();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                                    
            TransaksiHd transaksiHd = transaksiHdDao.getById(Long.parseLong(txtId.getText()));            
            SlipDto slipDto = new SlipDto();
            slipDto.setId(transaksiHd.getId());
            slipDto.setJenisTransaksi(transaksiHd.getJenisTransaksi().getNamaJenisTransaksi());
            slipDto.setNoTransaksi(transaksiHd.getNoTransaksi());
            slipDto.setTipeTransaksi(transaksiHd.getTipeTransaksi().toString());
            slipDto.setTerbilang("serebu");
            slipDto.setTotal(transaksiHd.getTotal());
            slipDto.setTanggal(sdf.format(transaksiHd.getTanggal() ));
            slipDto.setKeterangan(transaksiHd.getKeterangan());
            
            List<SlipDto> lists = new ArrayList<>();
            lists.add(slipDto);
            
            Map parameter = new HashMap();
            parameter.put("h1", params.getH1().trim());
            parameter.put("h2", params.getH2().trim());
            parameter.put("h3", params.getH3().trim());
            parameter.put("h4", params.getH4().trim());
        
            ReportController.previewReport("laporan/buktiSlip.jasper", parameter,lists, "Slip");                        
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnPreviewActionPerformed

    class ComboItem
    {
        private String key;
        private Long value;

        public ComboItem(String key, Long value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString()
        {
            return key;
        }

        public String getKey()
        {
            return key;
        }

        public Long getValue()
        {
            return value;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransaksiKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiKeuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TransaksiKeuangan("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPreview;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbJenisTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextField txtNoTransaksi;
    private javax.swing.JTextField txtTgl;
    // End of variables declaration//GEN-END:variables
}
