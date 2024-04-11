/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhieuDoiTraCT;
import repository.PhieuDoiTraCTRepo;
import utility.JDBCHelper;

/**
 *
 * @author User
 */
public class PhieuDoiTraCTService {
    private final PhieuDoiTraCTRepo phieuDoiTraCTRepo;

    public PhieuDoiTraCTService() {
        this.phieuDoiTraCTRepo = new PhieuDoiTraCTRepo();
    }
     public List<PhieuDoiTraCT> getAllPhieuDoiTraCT() {
        return phieuDoiTraCTRepo.getAllPhieuDoiTraCT();
    }

    public Integer addPhieuDoiTraCT(PhieuDoiTraCT pdtct) {
        return phieuDoiTraCTRepo.addPhieuDoiTraCT(pdtct);
    }

    public Integer updatePhieuDoiTraCT(PhieuDoiTraCT pdtct) {
      return phieuDoiTraCTRepo.updatePhieuDoiTraCT(pdtct);
    }

    public Integer deletePhieuDoiTraCT(String PDTCT_ID) {
      return phieuDoiTraCTRepo.deletePhieuDoiTraCT(PDTCT_ID);
    }
    
}
