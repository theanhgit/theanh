/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.PhieuDoiTra;
import model.PhieuGiamGia;
import utility.JDBCHelper;

/**
 *
 * @author User
 */
public class PhieuDoiTraRepo {
     public List<PhieuDoiTra> getAllPGG() {
        List<PhieuDoiTra> lst = new ArrayList<>();
        String sql = "Select*from PHIEUDOITRA";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String ID = rs.getString(1);
                String ID_HD = rs.getString(2);
                Date NGAYDT = rs.getTimestamp(3);
                String TRONGTIEN = rs.getString(4);
                lst.add(new PhieuDoiTra(ID, ID_HD, NGAYDT, TRONGTIEN));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public Integer addPDT(PhieuDoiTra pdt) {
        String sql = "insert into PHIEUDOITRA values(?,?,?)";
        Integer row = JDBCHelper.excuteUpdate(sql, pdt.getID_HD(), pdt.getNGAYDT(), pdt.getTRONGTIEN());
        return row;
    }

    public Integer updatePDT(PhieuDoiTra pdt) {
        String sql = "update PHIEUDOITRA set  ID_HD = ? , NGAYDT = ?, TRONGTIEN = ? where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql,  pdt.getID_HD(), pdt.getNGAYDT(),pdt.getTRONGTIEN(),pdt.getID());
        return row;
    }

    public Integer deletePDT(String PhieuDoiTraID) {
        String sql = "delete PHIEUDOITRA where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, PhieuDoiTraID);
        return row;
    }
}
