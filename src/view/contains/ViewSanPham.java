/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.contains;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.ChatLieuService;
import service.KichCoService;
import service.LoaiTheThaoService;
import service.MauSacService;
import service.SanPhamChiTietService;
import service.SanPhamService;
import service.ThuongHieuService;
import service.impl.ChatLieuServiceImpl;
import service.impl.KichCoServiceImpl;
import service.impl.LoaiTheThaoServiceImpl;
import service.impl.MauSacSercviceImpl;
import service.impl.SanPhamChiTietServiceImpl;
import service.impl.SanPhamServiceImpl;
import service.impl.ThuongHieuServiceImpl;
import view.contains.thuoctinhsanpham.ViewCL;
import view.contains.thuoctinhsanpham.ViewKC;
import view.contains.thuoctinhsanpham.ViewLTT;
import view.contains.thuoctinhsanpham.ViewMS;
import view.contains.thuoctinhsanpham.ViewSP;
import view.contains.thuoctinhsanpham.ViewTH;
import viewmodel.ChatLieuViewModel;
import viewmodel.DanhSachSP;
import viewmodel.KichCoViewModel;
import viewmodel.LoaiTheThaoViewModel;
import viewmodel.MauSacViewModel;
import viewmodel.SPCTViewModel;
import viewmodel.SanPhamChiTietViewModel;
import viewmodel.SanPhamViewModel;
import viewmodel.ThuongHieuViewModel;

/**
 *
 * @author pc
 */
public class ViewSanPham extends javax.swing.JPanel {

    private List<SanPhamChiTietViewModel> listSPCT = new ArrayList<>();
    private SanPhamChiTietService service = new SanPhamChiTietServiceImpl();

    private List<ChatLieuViewModel> listCL = new ArrayList<>();
    private ChatLieuService serviceCL = new ChatLieuServiceImpl();
    private List<String> listCboCl = new ArrayList<>();
    private DefaultComboBoxModel dcbCL = new DefaultComboBoxModel();

    private List<KichCoViewModel> listKC = new ArrayList<>();
    private KichCoService serviceKC = new KichCoServiceImpl();
    private List<String> listCboKC = new ArrayList<>();
    private DefaultComboBoxModel dcbKC = new DefaultComboBoxModel();

    private List<SanPhamViewModel> listSP = new ArrayList<>();
    private SanPhamService serviceSp = new SanPhamServiceImpl();
    private List<String> listCboSP = new ArrayList<>();
    private DefaultComboBoxModel dcbSP = new DefaultComboBoxModel();

    private List<LoaiTheThaoViewModel> listLTT = new ArrayList<>();
    private LoaiTheThaoService serviceLTT = new LoaiTheThaoServiceImpl();
    private List<String> listCboLTT = new ArrayList<>();
    private DefaultComboBoxModel dcbLTT = new DefaultComboBoxModel();

    private List<MauSacViewModel> listMS = new ArrayList<>();
    private MauSacService serviceMS = new MauSacSercviceImpl();
    private List<String> listCboMS = new ArrayList<>();
    private DefaultComboBoxModel dcbMS = new DefaultComboBoxModel();

    private List<ThuongHieuViewModel> listTH = new ArrayList<>();
    private ThuongHieuService serviceTH = new ThuongHieuServiceImpl();
    private List<String> listCboTH = new ArrayList<>();
    private DefaultComboBoxModel dcbTH = new DefaultComboBoxModel();

    private DefaultComboBoxModel dcbLocLSP = new DefaultComboBoxModel();

    private List<String> listLocKC = new ArrayList<>();
    private DefaultComboBoxModel dcbLocKichCo = new DefaultComboBoxModel();

    private DefaultComboBoxModel dcbLocLoaiTT = new DefaultComboBoxModel();

    private List<SPCTViewModel> listSPCTtable = new ArrayList<>();

    private DefaultTableModel dtm = new DefaultTableModel();
    
    private List<DanhSachSP> listDSSP=new ArrayList<>();
    private DefaultTableModel dtmBangDanhSach=new DefaultTableModel();
    /**
     * Creates new form ViewSanPham
     */
    private JPanel panel;

    public ViewSanPham() {
        initComponents();
        listSPCTtable = service.getAllTable();
        listSP = serviceSp.getAll();
        listTH = serviceTH.getAll();
        listLTT = serviceLTT.getAll();
        listKC = serviceKC.getAll();
        listMS = serviceMS.getAll();
        listCL = serviceCL.getAll();
        dtm = (DefaultTableModel) this.tblSPCT.getModel();
        showDataTable(listSPCTtable);

        dcbSP = (DefaultComboBoxModel) this.cboLoaiSanPham.getModel();
        listCboSP.add("");
        for (SanPhamViewModel sp : listSP) {
            listCboSP.add(sp.getTen());
        }
        showDataCBO(listCboSP, dcbSP);

        dcbLocLSP = (DefaultComboBoxModel) this.cboLocSanPham.getModel();
        showDataCBO(listCboSP, dcbLocLSP);

        dcbKC = (DefaultComboBoxModel) this.cboKichCo.getModel();
        for (KichCoViewModel kc : listKC) {
            if (cboLoaiSanPham.getSelectedItem().equals(kc.getLoaiSanPham())) {
                listCboKC.add(kc.getKichCo());
            }
        }
        showDataCBO(listCboKC, dcbKC);

        dcbLocKichCo = (DefaultComboBoxModel) this.cboLocKichCo.getModel();
        listLocKC.add("");
        listLocKC.add("S");
        listLocKC.add("M");
        listLocKC.add("L");
        listLocKC.add("XL");
        showDataCBO(listLocKC, dcbLocKichCo);

        dcbTH = (DefaultComboBoxModel) this.cboThuongHIeu.getModel();
        for (ThuongHieuViewModel sp : listTH) {
            listCboTH.add(sp.getTen());
        }
        showDataCBO(listCboTH, dcbTH);

        dcbLTT = (DefaultComboBoxModel) this.cboLTT.getModel();
        listCboLTT.add("");
        for (LoaiTheThaoViewModel sp : listLTT) {
            listCboLTT.add(sp.getTen());
        }
        showDataCBO(listCboLTT, dcbLTT);

        dcbLocLoaiTT = (DefaultComboBoxModel) this.cboLocLTT.getModel();
        showDataCBO(listCboLTT, dcbLocLoaiTT);
        
        dcbMS = (DefaultComboBoxModel) this.cboMauSac.getModel();
        for (MauSacViewModel sp : listMS) {
            listCboMS.add(sp.getTen());
        }
        showDataCBO(listCboMS, dcbMS);

        dcbCL = (DefaultComboBoxModel) this.cboChatLieu.getModel();
        for (ChatLieuViewModel sp : listCL) {
            listCboCl.add(sp.getTen());
        }
        showDataCBO(listCboCl, dcbCL);
        
        dtmBangDanhSach=(DefaultTableModel) this.tblDanhSach.getModel();

    }

    private void showDataTable(List<SPCTViewModel> listTable) {
        dtm.setRowCount(0);
        for (SPCTViewModel spct : listTable) {
            dtm.addRow(spct.toRowData());
        }
    }

     private void showDataTableDSNhapMoi(List<DanhSachSP> listTable){
        dtmBangDanhSach.setRowCount(0);
        for (DanhSachSP danhSachSP : listTable) {
            dtmBangDanhSach.addRow(danhSachSP.toRowData());
        }
    }
    
    private void showDataCBO(List<String> lisString, DefaultComboBoxModel cbo) {
        for (String string : lisString) {
            cbo.addElement(string);
        }
    }

    private void showDataFrom(int index) {
        SPCTViewModel spct = listSPCTtable.get(index);
        txtMa.setText(spct.getMa());
        txtMaVach.setText(spct.getMaVach());
        txtMoTa.setText(spct.getMoTa());
        txtSoLuong.setText(String.valueOf(spct.getSoLuong()));
        cboLoaiSanPham.setSelectedItem(spct.getLoaiSanPham());
        cboThuongHIeu.setSelectedItem(spct.getThuongHieu());
        cboLTT.setSelectedItem(spct.getLoaiTheThao());
        cboKichCo.setSelectedItem(spct.getKichCo());
        cboMauSac.setSelectedItem(spct.getMauSac());
        cboChatLieu.setSelectedItem(spct.getChatLieu());
        txtGiaNhap.setText(String.valueOf(spct.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(spct.getGiaBan()));
        ckbTrangThai.setSelected(spct.isTrangThai());
    }

    private SanPhamChiTietViewModel nhapDuLieu() {
        SanPhamChiTietViewModel spct = new SanPhamChiTietViewModel();
        int i=listSPCTtable.size()-1;
        spct.setMa("SPCT"+listSPCTtable.get(i).getId());
        spct.setMaVach(txtMaVach.getText());
        spct.setMoTa(txtMoTa.getText());
        spct.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

        for (SanPhamViewModel sp : listSP) {
            if (cboLoaiSanPham.getSelectedItem().equals(sp.getTen())) {
                spct.setIdSP(sp.getId());
            }
        }

        for (ThuongHieuViewModel sp : listTH) {
            if (cboThuongHIeu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdTH(sp.getId());
            }
        }
        for (LoaiTheThaoViewModel sp : listLTT) {
            if (cboLTT.getSelectedItem().equals(sp.getTen())) {
                spct.setIdLTT(sp.getId());
            }
        }
        for (KichCoViewModel sp : listKC) {
            if (cboKichCo.getSelectedItem().equals(sp.getKichCo())) {
                spct.setIdKC(sp.getId());
            }
        }
        for (MauSacViewModel sp : listMS) {
            if (cboMauSac.getSelectedItem().equals(sp.getTen())) {
                spct.setIdMS(sp.getId());
            }
        }
        for (ChatLieuViewModel sp : listCL) {
            if (cboChatLieu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdCL(sp.getId());
            }
        }
        spct.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
        spct.setGiaBan(Float.parseFloat(txtGiaNhap.getText()));
        spct.setTrangThai(ckbTrangThai.isSelected());

        return spct;
    }

    private SanPhamChiTietViewModel updateData() {
        SanPhamChiTietViewModel spct = new SanPhamChiTietViewModel();
        spct.setMa(txtMa.getText());
        spct.setMaVach(txtMaVach.getText());
        spct.setMoTa(txtMoTa.getText());
        spct.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

        for (SanPhamViewModel sp : listSP) {
            if (cboLoaiSanPham.getSelectedItem().equals(sp.getTen())) {
                spct.setIdSP(sp.getId());
            }
        }

        for (ThuongHieuViewModel sp : listTH) {
            if (cboThuongHIeu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdTH(sp.getId());
            }
        }
        for (LoaiTheThaoViewModel sp : listLTT) {
            if (cboLTT.getSelectedItem().equals(sp.getTen())) {
                spct.setIdLTT(sp.getId());
            }
        }
        for (KichCoViewModel sp : listKC) {
            if (cboKichCo.getSelectedItem().equals(sp.getKichCo())) {
                spct.setIdKC(sp.getId());
            }
        }
        for (MauSacViewModel sp : listMS) {
            if (cboMauSac.getSelectedItem().equals(sp.getTen())) {
                spct.setIdMS(sp.getId());
            }
        }
        for (ChatLieuViewModel sp : listCL) {
            if (cboChatLieu.getSelectedItem().equals(sp.getTen())) {
                spct.setIdCL(sp.getId());
            }
        }
        spct.setGiaNhap(Float.parseFloat(txtGiaNhap.getText()));
        spct.setGiaBan(Float.parseFloat(txtGiaBan.getText()));
        spct.setTrangThai(ckbTrangThai.isSelected());

        return spct;
    }
    
    private boolean validateThem(){
        if(txtMaVach.getText().trim().isEmpty()||txtSoLuong.getText().trim().isEmpty()||txtGiaNhap.getText().trim().isEmpty()
                ||cboLoaiSanPham.getSelectedItem().equals("")||cboLTT.getSelectedItem().equals("")||cboKichCo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(this,"Thông tin sản phẩm bị trống");
            return false;
        }
        try {
            int soLuong=Integer.parseInt(txtSoLuong.getText());
            float giaNhap=Float.parseFloat(txtGiaNhap.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Thông tin sai định dạng");
            return false;
        }
        listSPCTtable=service.getAllTable();
        for (SPCTViewModel spct : listSPCTtable) {
            if(cboLoaiSanPham.getSelectedItem().equals(spct.getLoaiSanPham())&&cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())
                    &&cboKichCo.getSelectedItem().equals(spct.getKichCo())&&cboThuongHIeu.getSelectedItem().equals(spct.getThuongHieu())
                    &&cboMauSac.getSelectedItem().equals(spct.getMauSac())&&cboChatLieu.getSelectedItem().equals(spct.getChatLieu())){
                JOptionPane.showMessageDialog(this,"Sản phẩm đã tồn tại");
                return false;
            }
        }
        listSPCT=service.getAll();
        for (SanPhamChiTietViewModel sanPhamChiTietViewModel : listSPCT) {
            if(txtMaVach.getText().trim().equals(sanPhamChiTietViewModel.getMaVach())){
                JOptionPane.showMessageDialog(this,"Mã vạch đã tồn tại");
                return false;
            }
        }
        
        
        
        return true;
    }
    
    private boolean validateTable() {
        if(txtMaVach.getText().trim().isEmpty()||txtSoLuong.getText().trim().isEmpty()||txtGiaNhap.getText().trim().isEmpty()
                ||cboLoaiSanPham.getSelectedItem().equals("")||cboLTT.getSelectedItem().equals("")||cboKichCo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(this,"Thông tin sản phẩm bị trống");
            return false;
        }
        try {
            int soLuong=Integer.parseInt(txtSoLuong.getText());
            float giaNhap=Float.parseFloat(txtGiaNhap.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Thông tin sai định dạng");
            return false;
        }
        return true;
    }

    private void clearFrom(){
        txtMa.setText("");
        txtMaVach.setText("");
        txtMoTa.setText("");
        txtSoLuong.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtDuongDan = new javax.swing.JTextField();
        jdlDanhSachLoaiSP = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cboLocSanPham = new javax.swing.JComboBox<>();
        cboLocKichCo = new javax.swing.JComboBox<>();
        cboLocLTT = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtSearchMa = new javax.swing.JTextField();
        btlHienThi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboLoaiSanPham = new javax.swing.JComboBox<>();
        cboLTT = new javax.swing.JComboBox<>();
        cboKichCo = new javax.swing.JComboBox<>();
        cboThuongHIeu = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        btnSanPham = new javax.swing.JButton();
        btnChatLieu = new javax.swing.JButton();
        btnKichCo = new javax.swing.JButton();
        btnMauSac = new javax.swing.JButton();
        btnLoaiTheThao = new javax.swing.JButton();
        btnThuongHieu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtMaVach = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        ckbTrangThai = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThemSanPham = new javax.swing.JButton();
        btnSuaThongTinSp = new javax.swing.JButton();
        btnDanhSachSanPham = new javax.swing.JButton();
        btnLuuDanhSach = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("Danh Sách Nhập Sản Phẩm");

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên SPCT", "Màu Sắc", "Kích Cỡ", "Số Lượng", "Giá Nhập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        jButton1.setText("Chọn Danh Sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jButton2.setText("Thêm Sản Phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDuongDan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDuongDan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDuongDan))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jdlDanhSachLoaiSPLayout = new javax.swing.GroupLayout(jdlDanhSachLoaiSP.getContentPane());
        jdlDanhSachLoaiSP.getContentPane().setLayout(jdlDanhSachLoaiSPLayout);
        jdlDanhSachLoaiSPLayout.setHorizontalGroup(
            jdlDanhSachLoaiSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
        jdlDanhSachLoaiSPLayout.setVerticalGroup(
            jdlDanhSachLoaiSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdlDanhSachLoaiSPLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Danh sách sản phẩm chi tiết");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });

        tblSPCT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Mã Vạch", "Mô tả", "Số lượng", "Tên SP", "Thương hiệu", "Loại TT", "Kích cỡ", "Màu sắc", "Chất liệu", "Gía nhập ", "Gía bán", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSPCT);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText(" Lọc và tìm kiếm sản phẩm");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Loại sản phẩm");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Kích cỡ");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Loại thể thao ");

        cboLocSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocSanPhamActionPerformed(evt);
            }
        });

        btnLoc.setBackground(new java.awt.Color(0, 0, 0));
        btnLoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(255, 255, 255));
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Mã :");

        txtSearchMa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSearchMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSearchMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchMaActionPerformed(evt);
            }
        });
        txtSearchMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchMaKeyReleased(evt);
            }
        });

        btlHienThi.setBackground(new java.awt.Color(255, 255, 204));
        btlHienThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/table (1).png"))); // NOI18N
        btlHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel27))
                            .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(cboLocKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboLocLTT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnLoc)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(btlHienThi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jLabel28)
                        .addComponent(jLabel41)
                        .addComponent(btnLoc)
                        .addComponent(jLabel20)
                        .addComponent(txtSearchMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btlHienThi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLocSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLocLTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Thuộc tính sản phẩm");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Sản Phẩm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Thương hiệu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Loại thể thao");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Chất liệu");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Màu sắc");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Kích cỡ");

        cboLoaiSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboLoaiSanPham.setForeground(new java.awt.Color(51, 51, 51));
        cboLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLoaiSanPhamMouseClicked(evt);
            }
        });
        cboLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSanPhamActionPerformed(evt);
            }
        });

        cboLTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboLTT.setForeground(new java.awt.Color(51, 51, 51));
        cboLTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboLTTMouseClicked(evt);
            }
        });
        cboLTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLTTActionPerformed(evt);
            }
        });

        cboKichCo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboKichCo.setForeground(new java.awt.Color(51, 51, 51));

        cboThuongHIeu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboThuongHIeu.setForeground(new java.awt.Color(51, 51, 51));
        cboThuongHIeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHIeuActionPerformed(evt);
            }
        });

        cboMauSac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboMauSac.setForeground(new java.awt.Color(51, 51, 51));

        cboChatLieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboChatLieu.setForeground(new java.awt.Color(51, 51, 51));

        btnSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        btnChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatLieuActionPerformed(evt);
            }
        });

        btnKichCo.setForeground(new java.awt.Color(204, 255, 255));
        btnKichCo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        btnKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichCoActionPerformed(evt);
            }
        });

        btnMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        btnMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMauSacActionPerformed(evt);
            }
        });

        btnLoaiTheThao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        btnLoaiTheThao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiTheThaoActionPerformed(evt);
            }
        });

        btnThuongHieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus (1).png"))); // NOI18N
        btnThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuongHieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboLoaiSanPham, 0, 180, Short.MAX_VALUE)
                            .addComponent(cboThuongHIeu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(232, 232, 232)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboLTT, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoaiTheThao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cboChatLieu, 0, 157, Short.MAX_VALUE)
                    .addComponent(cboKichCo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboLoaiSanPham)
                    .addComponent(cboLTT)
                    .addComponent(cboKichCo)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnLoaiTheThao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKichCo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThuongHIeu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChatLieu)
                    .addComponent(btnChatLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Chức năng");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Mã :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Mã vạch :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Mô tả :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Số lượng :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Giá nhập :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Giá bán :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Trạng thái :");

        txtMa.setEditable(false);
        txtMa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtMaVach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMaVach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMaVach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaVachActionPerformed(evt);
            }
        });

        txtMoTa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMoTa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSoLuong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtGiaNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGiaNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        txtGiaBan.setEditable(false);
        txtGiaBan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGiaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        ckbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ckbTrangThai.setSelected(true);
        ckbTrangThai.setText("Còn hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ckbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaVach, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa))
                        .addGap(28, 28, 28))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaVach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ckbTrangThai))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Thông tin sản phẩm");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        btnThemSanPham.setBackground(new java.awt.Color(0, 0, 0));
        btnThemSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnThemSanPham.setText("Thêm sản phẩm ");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnSuaThongTinSp.setBackground(new java.awt.Color(0, 0, 0));
        btnSuaThongTinSp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaThongTinSp.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTinSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/updated.png"))); // NOI18N
        btnSuaThongTinSp.setText("Sửa thông tin SP");
        btnSuaThongTinSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinSpActionPerformed(evt);
            }
        });

        btnDanhSachSanPham.setBackground(new java.awt.Color(0, 0, 0));
        btnDanhSachSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDanhSachSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnDanhSachSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnDanhSachSanPham.setText(" Ds nhập SP");
        btnDanhSachSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachSanPhamActionPerformed(evt);
            }
        });

        btnLuuDanhSach.setBackground(new java.awt.Color(0, 0, 0));
        btnLuuDanhSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuuDanhSach.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/xls.png"))); // NOI18N
        btnLuuDanhSach.setText("Lưa danh sách");
        btnLuuDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuDanhSachActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow.png"))); // NOI18N
        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnSuaThongTinSp)
                        .addGap(10, 10, 10)
                        .addComponent(btnLuuDanhSach))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnThemSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDanhSachSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaThongTinSp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(709, 709, 709)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        int index = tblSPCT.getSelectedRow();
        if (index >= 0 && index <= listSPCTtable.size()) {
            showDataFrom(index);
        }
    }//GEN-LAST:event_tblSPCTMouseClicked

    private void btnSuaThongTinSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinSpActionPerformed
        if (validateTable()) {
            int index = tblSPCT.getSelectedRow();
            SanPhamChiTietViewModel spct = updateData();
            SPCTViewModel spct1 = listSPCTtable.get(index);
            JOptionPane.showMessageDialog(this, service.getUpdate(spct, spct1.getId()));
            listSPCTtable = service.getAllTable();
            showDataTable(listSPCTtable);
        }
    }//GEN-LAST:event_btnSuaThongTinSpActionPerformed

    private void txtMaVachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaVachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaVachActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        if (validateThem()) {
            SanPhamChiTietViewModel spct = nhapDuLieu();
            JOptionPane.showMessageDialog(this, service.getAdd(spct));
            listSPCTtable = service.getAllTable();
            showDataTable(listSPCTtable);
        }
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFrom();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatLieuActionPerformed
        new ViewCL().setVisible(true);
    }//GEN-LAST:event_btnChatLieuActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        new ViewSP().setVisible(true);


    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void cboLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSanPhamActionPerformed
        listCboKC.removeAll(listCboKC);
        cboKichCo.removeAllItems();
        for (KichCoViewModel kc : listKC) {
            if (cboLoaiSanPham.getSelectedItem().equals(kc.getLoaiSanPham())) {
                listCboKC.add(kc.getKichCo());
            }
        }
        showDataCBO(listCboKC, dcbKC);
    }//GEN-LAST:event_cboLoaiSanPhamActionPerformed

    private void cboLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLoaiSanPhamMouseClicked

    }//GEN-LAST:event_cboLoaiSanPhamMouseClicked

    private void txtSearchMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMaActionPerformed

    private void txtSearchMaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchMaKeyReleased
        listSPCTtable=service.getSearch(txtSearchMa.getText());
        showDataTable(listSPCTtable);
    }//GEN-LAST:event_txtSearchMaKeyReleased

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyReleased

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        List<SPCTViewModel> listLoc=new ArrayList<>();
        for (SPCTViewModel spct : listSPCTtable) {
            if(cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham())&&cboLocKichCo.getSelectedItem().equals(spct.getKichCo())&&cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())){
                listLoc.add(spct);
            }else if(cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham())&&cboLocKichCo.getSelectedItem().equals("")&&cboLocLTT.getSelectedItem().equals("")){
                listLoc.add(spct);
            }else if(cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham())&&cboLocKichCo.getSelectedItem().equals(spct.getKichCo())&&cboLocLTT.getSelectedItem().equals("")){
                listLoc.add(spct);
            }else if(cboLocSanPham.getSelectedItem().equals(spct.getLoaiSanPham())&&cboLocKichCo.getSelectedItem().equals("")&&cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())){
                listLoc.add(spct);
            }else if(cboLocSanPham.getSelectedItem().equals("")&&cboLocKichCo.getSelectedItem().equals(spct.getKichCo())&&cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())){
                listLoc.add(spct);
            }else if(cboLocSanPham.getSelectedItem().equals("")&&cboLocKichCo.getSelectedItem().equals(spct.getKichCo())&&cboLocLTT.getSelectedItem().equals("")){
                listLoc.add(spct);
            }else if(cboLocSanPham.getSelectedItem().equals("")&&cboLocKichCo.getSelectedItem().equals("")&&cboLocLTT.getSelectedItem().equals(spct.getLoaiTheThao())){
                listLoc.add(spct);
            }
        }
        listSPCTtable=listLoc;
        showDataTable(listSPCTtable);
        listSPCTtable=service.getAllTable();
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuongHieuActionPerformed
        new ViewTH().setVisible(true);
        
    }//GEN-LAST:event_btnThuongHieuActionPerformed

    private void btnLoaiTheThaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiTheThaoActionPerformed
        new ViewLTT().setVisible(true);
    }//GEN-LAST:event_btnLoaiTheThaoActionPerformed

    private void btnMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMauSacActionPerformed
        new ViewMS().setVisible(true);
    }//GEN-LAST:event_btnMauSacActionPerformed

    private void btnKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichCoActionPerformed
        new ViewKC().setVisible(true);
    }//GEN-LAST:event_btnKichCoActionPerformed

    private void btlHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlHienThiActionPerformed
        listSPCTtable=service.getAllTable();
        showDataTable(listSPCTtable);
    }//GEN-LAST:event_btlHienThiActionPerformed

    private void btnLuuDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuDanhSachActionPerformed
        System.out.println("Create file excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Customer_Info");
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Danh Sách Sản Phẩm");
        listSPCTtable=service.getAllTable();
        for (SPCTViewModel spct : listSPCTtable) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(spct.getId());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(spct.getMa());
            Cell cell3 = row.createCell(2);
            cell3.setCellValue(spct.getMaVach());
            Cell cell4 = row.createCell(3);
            cell4.setCellValue(spct.getMoTa());
            Cell cell5 = row.createCell(4);
            cell5.setCellValue(spct.getSoLuong());
            Cell cell6 = row.createCell(5);
            cell6.setCellValue(spct.getLoaiSanPham());
            Cell cell7 = row.createCell(6);
            cell7.setCellValue(spct.getThuongHieu());
            Cell cell8 = row.createCell(7);
            cell8.setCellValue(spct.getLoaiTheThao());
            Cell cell9 = row.createCell(8);
            cell9.setCellValue(spct.getKichCo());
            Cell cell10 = row.createCell(9);
            cell10.setCellValue(spct.getMauSac());
            Cell cell11 = row.createCell(10);
            cell11.setCellValue(spct.getChatLieu());
            Cell cell12 = row.createCell(11);
            cell12.setCellValue(spct.getGiaNhap());
            Cell cell13 = row.createCell(12);
            cell13.setCellValue(spct.getGiaBan());
            Cell cell14 = row.createCell(13);
            cell14.setCellValue(spct.isTrangThai());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream("DanhSach.xlsx");
            workbook.write(outputStream);
            workbook.close();
            JOptionPane.showMessageDialog(this,"Lưu Thành Công");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lưu Thất Bại");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lưu Thất Bại");
        }
        System.out.println("Done");
    }//GEN-LAST:event_btnLuuDanhSachActionPerformed

    private void btnDanhSachSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachSanPhamActionPerformed
        jDialog1.setSize(670,310);
        jDialog1.setResizable(false);
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_btnDanhSachSanPhamActionPerformed

    private void cboThuongHIeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuongHIeuActionPerformed
        
    }//GEN-LAST:event_cboThuongHIeuActionPerformed

    private void cboLTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLTTActionPerformed

    }//GEN-LAST:event_cboLTTActionPerformed

    private void cboLTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboLTTMouseClicked
//        cboLTT.removeAllItems();
//        listCboLTT.removeAll(listCboLTT);
//        for (LoaiTheThaoViewModel ltt : listLTT) {
//            listCboLTT.add(ltt.getTen());
//        }
//        showDataCBO(listCboLTT, dcbLTT);
    }//GEN-LAST:event_cboLTTMouseClicked

    private void cboLocSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLocSanPhamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser jfc=new JFileChooser("T:\\JAVA\\DuAn1");
            jfc.showOpenDialog(null);
            File file=jfc.getSelectedFile();
            txtDuongDan.setText(String.valueOf(file));
            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            Iterator<Row> iterator = datatypeSheet.iterator();
            Row firstRow = iterator.next();
            Cell firstCell = firstRow.getCell(0);
            System.out.println(firstCell.getStringCellValue());
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                DanhSachSP dsSP = new DanhSachSP();
                //    dsSP.setMa(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(0))));
                dsSP.setMa(currentRow.getCell(0).getStringCellValue());
                dsSP.setLoaiSP(currentRow.getCell(1).getStringCellValue());
                dsSP.setMauSac(currentRow.getCell(2).getStringCellValue());
                dsSP.setKichCo(currentRow.getCell(3).getStringCellValue());
                dsSP.setSoLuong(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(4))));
                dsSP.setGiaNhap(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(5))));


                listDSSP.add(dsSP);
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showDataTableDSNhapMoi(listDSSP);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (SPCTViewModel spct : listSPCTtable) {
            for (DanhSachSP danhSachSP : listDSSP) {
                if(spct.getMa().equals(danhSachSP.getMa())){
                    int soLuongMoi=spct.getSoLuong()+danhSachSP.getSoLuong();
                    service.getUpdateSoLuong(soLuongMoi, spct.getId(),danhSachSP.getGiaNhap());
                }
            }
        }
        listSPCTtable=service.getAllTable();
        showDataTable(listSPCTtable);
        JOptionPane.showMessageDialog(this,"Cập Nhập Số Lượng Sản Phẩm Thành Công!");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlHienThi;
    private javax.swing.JButton btnChatLieu;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDanhSachSanPham;
    private javax.swing.JButton btnKichCo;
    private javax.swing.JButton btnLoaiTheThao;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnLuuDanhSach;
    private javax.swing.JButton btnMauSac;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnSuaThongTinSp;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnThuongHieu;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboLTT;
    private javax.swing.JComboBox<String> cboLoaiSanPham;
    private javax.swing.JComboBox<String> cboLocKichCo;
    private javax.swing.JComboBox<String> cboLocLTT;
    private javax.swing.JComboBox<String> cboLocSanPham;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboThuongHIeu;
    private javax.swing.JCheckBox ckbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JDialog jdlDanhSachLoaiSP;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTextField txtDuongDan;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaVach;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSearchMa;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
