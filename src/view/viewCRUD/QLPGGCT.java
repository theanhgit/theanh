/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.viewCRUD;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PhieuGiamGia;
import model.PhieuGiamGiaCT;
import service.PhieuGiamGiaCTService;
import utility.Uhelper;

/**
 *
 * @author User
 */
public class QLPGGCT extends javax.swing.JFrame {

    private final PhieuGiamGiaCTService phieuGiamGiaCTService;

    public QLPGGCT() {
        initComponents();
        setLocationRelativeTo(null);
        phieuGiamGiaCTService = new PhieuGiamGiaCTService();
        loadDataToTable();
        jDateNgayBatDau.setDateFormatString("yyyy-MM-dd");
        jDateNgayKetThuc.setDateFormatString("yyyy-MM-dd");
        txtID.setEditable(false); // Không cho phép chỉnh sửa trường input
        if (tblQLPGGCT.getRowCount() > 0) {
            tblQLPGGCT.setRowSelectionInterval(0, 0);
            showDetail();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDPGG = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        txtLuotSuDung = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLPGGCT = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDieuKhoan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        jDateNgayBatDau = new com.toedter.calendar.JDateChooser();
        jDateNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cbbTimKiem = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Quản lí phiếu giảm giá CT");

        jLabel2.setText("ID:");

        jLabel3.setText("ID phiếu giảm giá:");

        jLabel4.setText("Mã:");

        jLabel5.setText("Ngày Bắt đầu:");

        jLabel6.setText("Ngày kết thúc:");

        jLabel7.setText("Lượt sử dụng:");

        tblQLPGGCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_PGG", "Ma", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Lượt Sử Dụng", "Điều Khoản", "Giá Trị", "Trạng Thái"
            }
        ));
        tblQLPGGCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLPGGCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLPGGCT);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel8.setText("Điều khoản:");

        jLabel9.setText("Giá trị:");

        jLabel10.setText("Trạng thái:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        cbbTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Giá trị" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtTimKiem)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMa)
                                    .addComponent(txtTrangThai)
                                    .addComponent(txtGiaTri)
                                    .addComponent(txtDieuKhoan)
                                    .addComponent(txtLuotSuDung)
                                    .addComponent(jDateNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID)
                                    .addComponent(txtIDPGG)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua)
                            .addComponent(btnThem)
                            .addComponent(btnClear)
                            .addComponent(btnXoa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jLabel1)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDPGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(btnClear))
                    .addComponent(jDateNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtLuotSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDieuKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
//        if(Uhelper.checkRong(txtMa, "Không để trống mã giảm giá")) return;
//        if(Uhelper.checkRong(txtNgayBatDau, "Không để trống tên giảm giá")) return;

        PhieuGiamGiaCT pggct = getPhieuGiamGiaCTFormInput();
        if (phieuGiamGiaCTService.addPGGCT(pggct) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        Integer row = tblQLPGGCT.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table");
            return;
        }
        PhieuGiamGiaCT pggct = getPhieuGiamGiaCTFormInput();
        String phieuGiamGiaCT_ID = getPhieuGiamGiaCTFormSelectedRow();
        pggct.setID(phieuGiamGiaCT_ID);
        if (phieuGiamGiaCTService.updatePGGCT(pggct) != null) {
            JOptionPane.showMessageDialog(this, "sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "sửa thất bại");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String phieuGiamGiaCT_ID = getPhieuGiamGiaCTFormSelectedRow();
        if (phieuGiamGiaCTService.deletePGGCT(phieuGiamGiaCT_ID) != null) {
            JOptionPane.showMessageDialog(this, "xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "xóa thất bại");
        }
        loadDataToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblQLPGGCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLPGGCTMouseClicked
        // TODO add your handling code here:
        showDetail();
    }//GEN-LAST:event_tblQLPGGCTMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
//         String tim = txtTimKiem.getText();
//        if (cbbTimKiem.getSelectedIndex() == 0) {
//            loadTimKiemToTable(phieuGiamGiaCTService.getByMa(tim));
//        } else if (cbbTimKiem.getSelectedIndex() == 1) {
//            loadTimKiemToTable(phieuGiamGiaCTService.getByTen(tim));
//        }
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        if (txtTimKiem.getText().trim().isEmpty()) {
            loadDataToTable();
        } else {
            String tim = txtTimKiem.getText();
            if (cbbTimKiem.getSelectedIndex() == 0) {
                loadTimKiemToTable(phieuGiamGiaCTService.getByMa(tim));
            } else if (cbbTimKiem.getSelectedIndex() == 1) {
                loadTimKiemToTable(phieuGiamGiaCTService.getByGiaTri(tim));
            }
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

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
            java.util.logging.Logger.getLogger(QLPGGCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLPGGCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLPGGCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLPGGCT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLPGGCT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbTimKiem;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateNgayBatDau;
    private com.toedter.calendar.JDateChooser jDateNgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblQLPGGCT;
    private javax.swing.JTextField txtDieuKhoan;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDPGG;
    private javax.swing.JTextField txtLuotSuDung;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tblQLPGGCT.getModel();
        dtm.setRowCount(0);
        List<PhieuGiamGiaCT> lst = phieuGiamGiaCTService.getAllPGGCT();
        for (PhieuGiamGiaCT pggct : lst) {
            dtm.addRow(new Object[]{
                pggct.getID(),
                pggct.getID_PGG(),
                pggct.getMA(),
                pggct.getNGAYBATDAU(),
                pggct.getNGAYKETTHUC(),
                pggct.getLUOTSUDUNG(),
                pggct.getDIEUKHOAN(),
                pggct.getGIATRI(),
                pggct.getTRANGTHAI()
            });
        }
    }

    public void loadTimKiemToTable(List<PhieuGiamGiaCT> list) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tblQLPGGCT.getModel();
        dtm.setRowCount(0);
        List<PhieuGiamGiaCT> lst = list;
        for (PhieuGiamGiaCT pggct : lst) {
            dtm.addRow(new Object[]{
                pggct.getID(),
                pggct.getID_PGG(),
                pggct.getMA(),
                pggct.getNGAYBATDAU(),
                pggct.getNGAYKETTHUC(),
                pggct.getLUOTSUDUNG(),
                pggct.getDIEUKHOAN(),
                pggct.getGIATRI(),
                pggct.getTRANGTHAI()
            });
        }
    }

    private void showDetail() {
        Integer selectedRow = tblQLPGGCT.getSelectedRow();
        txtID.setText(tblQLPGGCT.getValueAt(selectedRow, 0).toString());
        txtIDPGG.setText(tblQLPGGCT.getValueAt(selectedRow, 1).toString());
        txtMa.setText(tblQLPGGCT.getValueAt(selectedRow, 2).toString());
        String ngayBatDauValue = tblQLPGGCT.getValueAt(selectedRow, 3).toString();
        String ngayKetThucValue = tblQLPGGCT.getValueAt(selectedRow, 4).toString();

        // Định dạng ngày tháng
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Chuyển đổi chuỗi thành đối tượng Date
            Date ngayBatDau = dateFormat.parse(ngayBatDauValue);
            Date ngayKetThuc = dateFormat.parse(ngayKetThucValue);

            // Đặt giá trị cho JDateChooser
            jDateNgayBatDau.setDate(ngayBatDau);
            jDateNgayKetThuc.setDate(ngayKetThuc);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtLuotSuDung.setText(tblQLPGGCT.getValueAt(selectedRow, 5).toString());
        txtDieuKhoan.setText(tblQLPGGCT.getValueAt(selectedRow, 6).toString());
        txtGiaTri.setText(tblQLPGGCT.getValueAt(selectedRow, 7).toString());
        txtTrangThai.setText(tblQLPGGCT.getValueAt(selectedRow, 8).toString());
    }

    public PhieuGiamGiaCT getPhieuGiamGiaCTFormInput() {
        PhieuGiamGiaCT pggct = new PhieuGiamGiaCT();
        pggct.setID(txtID.getText());
        pggct.setID_PGG(txtIDPGG.getText());
        pggct.setMA(txtMa.getText());
        pggct.setNGAYBATDAU(jDateNgayBatDau.getDate());
        pggct.setNGAYKETTHUC(jDateNgayKetThuc.getDate());
        pggct.setLUOTSUDUNG(txtLuotSuDung.getText());
        pggct.setDIEUKHOAN(txtDieuKhoan.getText());
        pggct.setGIATRI(txtGiaTri.getText());
        pggct.setTRANGTHAI(txtTrangThai.getText());
        return pggct;
    }

    public String getPhieuGiamGiaCTFormSelectedRow() {
        Integer row = tblQLPGGCT.getSelectedRow();
        String PhieuGiamGiaID = (String) tblQLPGGCT.getValueAt(row, 0);
        return PhieuGiamGiaID;

    }

    private void clearForm() {
        txtID.setText("");
        txtIDPGG.setText("");
        txtMa.setText("");
        jDateNgayBatDau.setDate(null);
        jDateNgayKetThuc.setDate(null);
        txtLuotSuDung.setText("");
        txtDieuKhoan.setText("");
        txtGiaTri.setText("");
        txtTrangThai.setText("");
        tblQLPGGCT.clearSelection();
    }
}
