/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USER
 */
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi extends javax.swing.JFrame {

 public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.KoneksiDatabase.BukaKoneksi();
    
    public Transaksi() {
        initComponents();
        TampilData();
    }
    private void Bersih(){
        tfidtran.setText("");
        tfidpel.setText("");
        tfidpen.setText("");        
        tftgl.setText("");
        tfharga.setText("");
        tfnpel.setText("");
        tfnpen.setText("");
        
        btsimpan.setText("Simpan");
        tfidtran.setEditable(true);}
    
    private void CariData(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM transaksi WHERE " 
                                    + cmbcari.getSelectedItem().toString() +
                                    " LIKE '%" +tfcari.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("ID Transaksi");
            model.addColumn("ID Pelanggan");
            model.addColumn("ID Penerbangan");
            model.addColumn("Tgl Transaksi");            
            model.addColumn("Total Harga");
            
            int no = 1;
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()){
                Object[] data = {
                    no ++,
                    rs.getString("id_transaksi"),
                    rs.getString("id_pelanggan"),
                    rs.getString("id_penerbangan"),
                    rs.getString("tanggal_transaksi"),                    
                    rs.getString("total_harga"),
                };
                model.addRow(data);
                jTable2.setModel(model);                               
            }        
            
        }catch (Exception e){            
        }
    }
    
     private void TampilData(){
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM transaksi");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("ID Transaksi");
            model.addColumn("ID Pelanggan");
            model.addColumn("ID Penerbangan");
            model.addColumn("Tgl Transaksi");            
            model.addColumn("Total Harga");
            
            int no = 1;
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()){
                Object[] data = {
                    no ++,
                    rs.getString("id_transaksi"),
                    rs.getString("id_pelanggan"),
                    rs.getString("id_penerbangan"),
                    rs.getString("tanggal_transaksi"),                    
                    rs.getString("total_harga"),
                };
                model.addRow(data);
                jTable2.setModel(model);                               
            }        
            
        }catch (Exception e){            
        }
    }
     
     
     
     
     
     private void getDataPelanggan(String idPelanggan) {
    try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM pelanggan WHERE id_pelanggan = '" + idPelanggan + "'");
        if (rs.next()) {
            tfnpel.setText(rs.getString("nama"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e);
    }
}

private void getDataPenerbangan(String idPenerbangan) {
    try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM penerbangan WHERE id_penerbangan = '" + idPenerbangan + "'");
        if (rs.next()) {
            tfnpen.setText(rs.getString("nama_penerbangan"));
            tfharga.setText(rs.getString("harga")); 
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane, e);
    }
}

private void tfidpelActionPerformed(java.awt.event.ActionEvent evt) {                                       
    getDataPelanggan(tfidpel.getText());
}

private void tfidpenActionPerformed(java.awt.event.ActionEvent evt) {                                       
    getDataPenerbangan(tfidpen.getText());
}
     
     
     
     
     
     
     
     
     
private void generateReport() {
    try {
        String reportPath = "src/rtransaksi.jasper"; 
        
        HashMap<String, Object> parameters = new HashMap<>();        
        JasperPrint jp = JasperFillManager.fillReport(reportPath, parameters, cn);        
        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane,e);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tfcari = new javax.swing.JTextField();
        cmbcari = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfidtran = new javax.swing.JTextField();
        tfidpel = new javax.swing.JTextField();
        tftgl = new javax.swing.JTextField();
        tfidpen = new javax.swing.JTextField();
        tfharga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfnpel = new javax.swing.JTextField();
        tfnpen = new javax.swing.JTextField();
        btsimpan = new javax.swing.JButton();
        btbatal = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btreport = new javax.swing.JButton();
        ppel = new javax.swing.JButton();
        ppen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        tfcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfcariKeyPressed(evt);
            }
        });

        cmbcari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_transaksi", "id_pelanggan", "id_penerbangan", " " }));
        cmbcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcariActionPerformed(evt);
            }
        });

        jLabel6.setText("cari");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbcari, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setForeground(new java.awt.Color(153, 255, 204));

        jLabel1.setText("ID Transaksi");

        jLabel2.setText("ID Pelanggan");

        jLabel3.setText("Tanggal Transaksi");

        jLabel4.setText("ID Penerbangan");

        tfidtran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidtranActionPerformed(evt);
            }
        });

        tfidpel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfidpelKeyReleased(evt);
            }
        });

        tfidpen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfidpenKeyReleased(evt);
            }
        });

        jLabel9.setText("Total harga");

        tfnpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnpelActionPerformed(evt);
            }
        });
        tfnpel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfnpelKeyReleased(evt);
            }
        });

        tfnpen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfnpenKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(tfidpen, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tfnpen, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfidpel, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(tfidtran))
                                .addGap(18, 18, 18)
                                .addComponent(tfnpel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tftgl)
                            .addComponent(tfharga))))
                .addGap(0, 350, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfidtran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfidpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfnpel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfidpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfnpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tftgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btsimpan.setText("Simpan");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });

        btbatal.setText("Batal");
        btbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbatalActionPerformed(evt);
            }
        });

        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setText("Tabel Transaksi");

        btreport.setText("Report");
        btreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btreportActionPerformed(evt);
            }
        });

        ppel.setText("Data Pelanggan");
        ppel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppelActionPerformed(evt);
            }
        });

        ppen.setText("Data Penerbangan");
        ppen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(btsimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(bthapus)
                                        .addGap(18, 18, 18)
                                        .addComponent(btbatal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btreport)))
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ppel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ppen)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ppel)
                            .addComponent(ppen))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsimpan)
                    .addComponent(btbatal)
                    .addComponent(bthapus)
                    .addComponent(btreport, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfidtranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidtranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidtranActionPerformed

    private void btbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbatalActionPerformed
        Bersih();        // TODO add your handling code here:
    }//GEN-LAST:event_btbatalActionPerformed

    private void tfnpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnpelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnpelActionPerformed

    private void tfcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcariKeyPressed
        CariData();        // TODO add your handling code here:
    }//GEN-LAST:event_tfcariKeyPressed

    private void cmbcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcariActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        tfidtran.setText(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString());
        tfidpel.setText(jTable2.getValueAt(jTable2.getSelectedRow(),2).toString());
        tfidpen.setText(jTable2.getValueAt(jTable2.getSelectedRow(),3).toString());
        tftgl.setText(jTable2.getValueAt(jTable2.getSelectedRow(),4).toString());
        tfharga.setText(jTable2.getValueAt(jTable2.getSelectedRow(),5).toString());
        
        tfidtran.setEditable(false);
        btsimpan.setText("Ubah");

    getDataPelanggan(tfidpel.getText());
    getDataPenerbangan(tfidpen.getText());        
    }//GEN-LAST:event_jTable2MouseClicked

    private void btreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btreportActionPerformed
        generateReport();
    }//GEN-LAST:event_btreportActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        if (tfidtran.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan pilih data dahulu");
        }else{
            int jawab = JOptionPane.showConfirmDialog(null,"Data ini akan dihapus, anda yakin untuk melanjutkan ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
                try {
                    st = cn.createStatement();
                    String sql = "DELETE FROM transaksi WHERE id_transaksi = '" + tfidtran.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                    TampilData();
                    Bersih();
                    
                }catch (Exception e){
                  JOptionPane.showMessageDialog(null,e); 
                }
            }
        }           // TODO add your handling code here:
    }//GEN-LAST:event_bthapusActionPerformed

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
         try {
            st = cn.createStatement();
            if (tfidtran.getText().equals("") ||
                tfidpel.getText().equals("") || 
                tfidpen.getText().equals("") ||                               
                tftgl.getText().equals("") ||
                tfharga.getText().equals("")){  
                JOptionPane.showMessageDialog(null,"data tidak boleh kosong","validasi Data",JOptionPane.INFORMATION_MESSAGE);
                return;              
                
               
            }
            //fungsi simpan
            if (btsimpan.getText()== "Simpan") { 
                String cek = "SELECT * FROM transaksi WHERE id_transaksi  = '" + tfidtran.getText() + "'";
                rs = st.executeQuery(cek);
                if (rs.next()){
                    JOptionPane.showMessageDialog(null, "ID Sudah Ada");
                }else{
                    String sql = "INSERT INTO transaksi VALUES ('" + tfidtran.getText()+
                            "','" + tfidpel.getText() +
                            "','" + tfidpen.getText() +
                            "','" + tftgl.getText() +
                            "','" + tfharga.getText() + "')";
                    
                    
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil Disimpan");
                    TampilData();
                    Bersih();
                    
                }
                
            }else{
             //ubah / edit data  
             String update = "UPDATE transaksi SET id_pelanggan  = '" + tfidpel.getText()+
                                                          "',id_penerbangan  = '" + tfidpen.getText()+
                                                          "',tanggal_transaksi = '" + tftgl.getText()+                                                           
                                                          "',total_harga = '" + tfharga.getText()+                     
                                                          "' WHERE id_transaksi  = '" + tfidtran.getText()+"'";
             st.executeUpdate(update);
             JOptionPane.showMessageDialog(null,"Data Berhasil di ubah");
             TampilData();
             Bersih();
            }
          }catch(Exception e){
              JOptionPane.showMessageDialog(null,e);
              
          }
    }//GEN-LAST:event_btsimpanActionPerformed

    private void tfnpelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnpelKeyReleased
       getDataPelanggan(tfidpel.getText()); // TODO add your handling code here:
    }//GEN-LAST:event_tfnpelKeyReleased

    private void tfnpenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnpenKeyReleased
       getDataPenerbangan(tfidpen.getText()); // TODO add your handling code here:
    }//GEN-LAST:event_tfnpenKeyReleased

    private void tfidpenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfidpenKeyReleased
      getDataPenerbangan(tfidpen.getText());  // TODO add your handling code here:
    }//GEN-LAST:event_tfidpenKeyReleased

    private void tfidpelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfidpelKeyReleased
       getDataPelanggan(tfidpel.getText());
    }//GEN-LAST:event_tfidpelKeyReleased

    private void ppelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppelActionPerformed
    Pelanggan pelangganForm = new Pelanggan();
    pelangganForm.setVisible(true);
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_ppelActionPerformed

    private void ppenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppenActionPerformed
    Penerbangan penerbanganForm = new Penerbangan();
    penerbanganForm.setVisible(true);
    this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_ppenActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbatal;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btreport;
    private javax.swing.JButton btsimpan;
    private javax.swing.JComboBox<String> cmbcari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton ppel;
    private javax.swing.JButton ppen;
    private javax.swing.JTextField tfcari;
    private javax.swing.JTextField tfharga;
    private javax.swing.JTextField tfidpel;
    private javax.swing.JTextField tfidpen;
    private javax.swing.JTextField tfidtran;
    private javax.swing.JTextField tfnpel;
    private javax.swing.JTextField tfnpen;
    private javax.swing.JTextField tftgl;
    // End of variables declaration//GEN-END:variables
}
