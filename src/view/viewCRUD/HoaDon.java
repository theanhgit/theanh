package view.viewCRUD;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import service.impl.HoaDonService;
import viewmodel.HoaDonView;

public class HoaDon extends javax.swing.JFrame {

    HoaDonView donView = new HoaDonView();
    private HoaDonService service = new HoaDonService();

    public HoaDon() {
        initComponents();
        setLocationRelativeTo(null);
        this.taiDuLieu();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LBID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LBIDNV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LBIDKH = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaPGG = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtNgayThanhToan = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rdoTM = new javax.swing.JRadioButton();
        rdoCK = new javax.swing.JRadioButton();
        txtTienGiam = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        txtTienTraTruoc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaCK = new javax.swing.JTextField();
        txtTienCK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("HÓA ĐƠN");

        jLabel2.setText("ID: ");

        LBID.setText("-");

        jLabel3.setText("ID_NV:");

        LBIDNV.setText("-");

        jLabel4.setText("ID_KH:");

        LBIDKH.setText("-");

        jLabel5.setText("Mã PGG:");

        jLabel6.setText("Ngày Tạo:");

        jLabel7.setText("Ngày Thanh Toán:");

        jLabel8.setText("Tiền Giảm: ");

        jLabel9.setText("Tổng Tiền:");

        jLabel10.setText("Tiền Khách Đưa:");

        jLabel11.setText("Tiền Thừa:");

        jLabel12.setText("Tiền Trả Trước:");

        jLabel13.setText("Hình Thức Thanh Toán");

        buttonGroup1.add(rdoTM);
        rdoTM.setText("Tiền mặt");

        buttonGroup1.add(rdoCK);
        rdoCK.setText("Chuyển khoản");

        jLabel14.setText("Mã Chuyển Khoản:");

        jLabel15.setText("Tiền Chuyển Khoản:");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "ID_NV", "ID_KH", "Mã PGG", "Ngày Tạo", "Ngày Thanh Toán", "Tiền Giảm", "Tổng Tiền", "Tiền Khách Đưa", "Tiền Thừa", "Tiền Trả Trước", "Hình Thức Thanh Toán", "Mã Chuyển Khoản", "Tiền Chuyển Khoản"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel16.setText("Mã:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(26, 26, 26)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel16))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LBID)
                                        .addComponent(txtMaPGG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LBIDNV)
                                        .addComponent(LBIDKH)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(113, 113, 113)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(rdoTM)
                        .addGap(18, 18, 18)
                        .addComponent(rdoCK))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienGiam)
                            .addComponent(txtTongTien)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtTienThua)
                            .addComponent(txtTienTraTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTienCK))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(txtMaCK, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(LBID)
                            .addComponent(jLabel8)
                            .addComponent(btnThem)))
                    .addComponent(txtTienGiam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(13, 13, 13))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(5, 5, 5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBIDNV, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(LBIDKH))))
                    .addComponent(btnSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaPGG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTienTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(rdoTM)
                                        .addComponent(rdoCK))
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(txtMaCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTienCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) this.tblHoaDon.getModel();
            int row = tblHoaDon.getSelectedRow();
            int id = (int) model.getValueAt(row, 0);
            String ma = (String) model.getValueAt(row, 1);
            int idnv = (int) model.getValueAt(row, 2);
            int idkh = (int) model.getValueAt(row, 3);
            String mapgg = (String) model.getValueAt(row, 4);
            Date ngaytao = (Date) model.getValueAt(row, 5);
            Date ngaythanhtoan = (Date) model.getValueAt(row, 6);
            int tiengiam = (int) model.getValueAt(row, 7);
            int tongtien = (int) model.getValueAt(row, 8);
            int tienkhachdua = (int) model.getValueAt(row, 9);
            int tienthua = (int) model.getValueAt(row, 10);
            int tientratruoc = (int) model.getValueAt(row, 11);
            int hinhthucthanhtoan = (int) model.getValueAt(row, 12);
            String machuyenkhoan = (String) model.getValueAt(row, 13);
            int tienchuyenkhoan = (int) model.getValueAt(row, 14);

            LBID.setText(id + "");
            txtMa.setText(ma + "");
            LBIDNV.setText(idnv + "");
            LBIDKH.setText(idkh + "");
            txtMaPGG.setText(mapgg);
            java.util.Date utiDate = new java.util.Date(ngaytao.getTime());
            txtNgayTao.setDate(utiDate);
            java.util.Date utiDate2 = new java.util.Date(ngaythanhtoan.getTime());
            txtNgayThanhToan.setDate(utiDate2);
            txtTienGiam.setText(mapgg);
            txtTongTien.setText(tongtien + "");
            txtTienKhachDua.setText(tienkhachdua + "");
            txtTienThua.setText(tienkhachdua + "");
            txtTienThua.setText(tienkhachdua + "");
            txtTienTraTruoc.setText(tientratruoc + "");
            if (hinhthucthanhtoan > 0) {
                rdoCK.setSelected(true);
            } else {
                rdoTM.setSelected(true);
            }
            txtMaCK.setText(machuyenkhoan +"");
            txtTienCK.setText(tienchuyenkhoan +"");
        } catch (Exception e) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private static Date converterDateSql(java.util.Date date) {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getDefault().getTimeZone("America/Los_Angeles"));
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
        TimeZone.setDefault(TimeZone.getTimeZone("Rome"));
        sqlDate = new java.sql.Date(date.getTime());
//        System.out.println(sqlDate);
        return sqlDate;
    }

    private HoaDonView getHoaDonForm() {
        String ma = txtMa.getText();
        String mapgg = txtMaPGG.getText();
        Date ngaytao = converterDateSql(txtNgayTao.getDate());
        Date ngaythanhtoan = converterDateSql(txtNgayThanhToan.getDate());
        int tiengiam = Integer.parseInt(txtTienGiam.getText());
        int tongtien = Integer.parseInt(txtTongTien.getText());
        int tienkhachdua = Integer.parseInt(txtTienKhachDua.getText());
        int tienthua = Integer.parseInt(txtTienThua.getText());
        int tientratruoc = Integer.parseInt(txtTienTraTruoc.getText());
        int hinhThucThanhToan = rdoCK.isSelected() ? 1 : 0;
        String machuyenkhoan = txtMaCK.getText();
        int tienCK = Integer.parseInt(txtTienCK.getText());

        HoaDonView hoaDonView = new HoaDonView(ma,1, 1, mapgg, ngaytao, ngaythanhtoan, tiengiam, tongtien, tienkhachdua, tienthua, tientratruoc,
                hinhThucThanhToan, machuyenkhoan, tienCK
        );
        return hoaDonView;
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        try {
            if (!valication()) {
                return;
            }
            int row = tblHoaDon.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xóa");
                return;
            }
            Object obj = tblHoaDon.getValueAt(row, 0);
            int id_hd = Integer.parseInt(obj.toString());
            HoaDonView hoaDonView = getHoaDonForm();
            service.update(id_hd, hoaDonView);
            taiDuLieu();
            JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sửa hóa đơn thất bại");
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        try {
            if (!valication()) {
                return;
            }
            if (service.add(getHoaDonForm())) {
                taiDuLieu();
                xoaRong();
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Hóa đơn thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm Hóa đơn thất bại");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            int row = tblHoaDon.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xóa");
                return;
            }
            Object obj = tblHoaDon.getValueAt(row, 0);
            int id_hd = Integer.parseInt(obj.toString());
            service.delete(id_hd);
            taiDuLieu();
            xoaRong();
            JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Xóa hóa đơn thất bại");
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private boolean valication() {
        String s = txtMaPGG.getText().trim();
        if (s.equals("")) {
            return errorTextField(txtMaPGG, "Vui lòng nhập MãPGG");
        }
        if (!rdoCK.isSelected() && !rdoTM.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hình thức thanh toán");
            return false;
        }
        if (txtNgayTao.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày tạo hóa đơn");
            return false;
        }
        if (txtNgayThanhToan.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày thanh toán hóa đơn");
            return false;
        }
        try {
            s = txtTienGiam.getText().trim();
            Integer.parseInt(s);
            //
            s = txtTienKhachDua.getText().trim();
            Integer.parseInt(s);
            if (s.equals("")) {
                return errorTextField(txtTienKhachDua, "Vui lòng nhập tiền khách đưa");
            }
            s = txtMa.getText().trim();
            Integer.parseInt(s);
            if (s.equals("")) {
                return errorTextField(txtMa, "Vui lòng nhập mã");
            }
            //
            s = txtTienTraTruoc.getText().trim();
            Integer.parseInt(s);
            if (s.equals("")) {
                return errorTextField(txtTienTraTruoc, "Vui lòng nhập tiền trả trước");
            }
            //
            s = txtTienKhachDua.getText().trim();
            Integer.parseInt(s);
            if (s.equals("")) {
                return errorTextField(txtTienKhachDua, "Vui lòng nhập ký tự số");
            }
            //
            s = txtTienTraTruoc.getText().trim();
            Integer.parseInt(s);
            if (s.equals("")) {
                return errorTextField(txtTienTraTruoc, "Vui lòng nhập ký tự số");
            }

        } catch (NumberFormatException e) {
            errorTextField(txtTienGiam, "Tiền là định dạng số");
        }
        s = txtMaCK.getText().trim();
        if (s.equals("")) {
            return errorTextField(txtMaCK, "Vui lòng nhập mã chuyển khoản");
        }
        return true;
    }

    private boolean errorTextField(JTextField jTextField, String mess) {
        JOptionPane.showMessageDialog(this, mess);
        jTextField.selectAll();
        jTextField.requestFocus();
        return false;
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
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBID;
    private javax.swing.JLabel LBIDKH;
    private javax.swing.JLabel LBIDNV;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoCK;
    private javax.swing.JRadioButton rdoTM;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaCK;
    private javax.swing.JTextField txtMaPGG;
    private com.toedter.calendar.JDateChooser txtNgayTao;
    private com.toedter.calendar.JDateChooser txtNgayThanhToan;
    private javax.swing.JTextField txtTienCK;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTienTraTruoc;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void xoaRongTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblHoaDon.getModel();
        while (tblHoaDon.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    private void taiDuLieu() {
        LBID.setText("-");
        LBIDNV.setText("");
        LBIDKH.setText("");
        buttonGroup1.clearSelection();
        DefaultTableModel model = (DefaultTableModel) this.tblHoaDon.getModel();
        xoaRongTable();
        ArrayList<HoaDonView> list = (ArrayList<HoaDonView>) this.service.getall();
        for (HoaDonView x : list) {
            Object[] rowData = {
                x.getId(),x.getMa(),x.getIdNV(),x.getIdKH(),x.getMaPGG(),x.getNgayTao(),x.getNgayThanhToan(),x.getTienGiam(),x.getTongTien(),x.getTienKhachDua(),x.getTienThua(),x.getTienTraTruoc(),x.getHinhThucThanhToan(),x.getMaChuyenKhoan(),x.getTienChuyenKhoan()

            };
            model.addRow(rowData);
        }
    }

    private void xoaRong() {
        LBID.setText("--");
        txtMa.setText("");
        LBIDNV.setText("--");
        LBIDKH.setText("--");
        txtMaPGG.setText("");
        txtTienGiam.setText("");
        txtTongTien.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        txtTienTraTruoc.setText("");
        buttonGroup1.clearSelection();
        txtMaCK.setText("");
        txtTienCK.setText("");
    }
}
