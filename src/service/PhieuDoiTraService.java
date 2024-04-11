/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhieuDoiTra;
import repository.PhieuDoiTraRepo;
import utility.JDBCHelper;

/**
 *
 * @author User
 */
public class PhieuDoiTraService {
    private final PhieuDoiTraRepo phieuDoiTraRepo;

    public PhieuDoiTraService() {
        this.phieuDoiTraRepo = new PhieuDoiTraRepo();
    }
    
    
      public List<PhieuDoiTra> getAllPGG() {
       return phieuDoiTraRepo.getAllPGG();
    }

    public Integer addPDT(PhieuDoiTra pdt) {
      return phieuDoiTraRepo.addPDT(pdt);
    }

    public Integer updatePDT(PhieuDoiTra pdt) {
       return phieuDoiTraRepo.updatePDT(pdt);
    }

    public Integer deletePDT(String PhieuDoiTraID) {
        return phieuDoiTraRepo.deletePDT(PhieuDoiTraID);
    }
}
