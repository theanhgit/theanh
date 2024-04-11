/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhieuDoiTraCT;
import model.PhieuGiamGia;
import utility.JDBCHelper;

/**
 *
 * @author User
 */
public class PhieuDoiTraCTRepo {
     public List<PhieuDoiTraCT> getAllPhieuDoiTraCT() {
        List<PhieuDoiTraCT> lst = new ArrayList<>();
        String sql = "Select*from PHIEU_TRA_CHI_TIET";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                String ID = rs.getString(1);
                String ID_PIEU_DOI_TRA = rs.getString(2);
                String ID_SPCT = rs.getString(3);
                String GIASP = rs.getString(4);
                String TRANGTHAI = rs.getString(5);
                String LIDOA = rs.getString(6);
               lst.add(new PhieuDoiTraCT(ID, ID_PIEU_DOI_TRA, ID_SPCT, GIASP, TRANGTHAI, LIDOA));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public Integer addPhieuDoiTraCT(PhieuDoiTraCT pdtct) {
        String sql = "insert into PHIEU_TRA_CHI_TIET values(?,?,?,?,?)";
        Integer row = JDBCHelper.excuteUpdate(sql, pdtct.getID_PIEU_DOI_TRA(),pdtct.getID_SPCT(),pdtct.getGIASP(),pdtct.getTRANGTHAI(),pdtct.getLIDOA());
        return row;
    }

    public Integer updatePhieuDoiTraCT(PhieuDoiTraCT pdtct) {
        String sql = "update PHIEU_TRA_CHI_TIET set ID_PIEU_DOI_TRA = ?,ID_SPCT = ?,GIASP = ?,TRANGTHAI = ?,LIDOA = ? where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql,  pdtct.getID_PIEU_DOI_TRA(), pdtct.getID_SPCT(),pdtct.getGIASP(),pdtct.getTRANGTHAI(),pdtct.getLIDOA(),pdtct.getID());
        return row;
    }

    public Integer deletePhieuDoiTraCT(String PDTCT_ID) {
        String sql = "delete PHIEU_TRA_CHI_TIET where ID = ?";
        Integer row = JDBCHelper.excuteUpdate(sql, PDTCT_ID);
        return row;
    }
}
