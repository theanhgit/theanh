/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KichCoModel;
import repository.KichCoRepository;
import service.KichCoService;
import viewmodel.KichCoViewModel;

/**
 *
 * @author pc
 */
public class KichCoServiceImpl implements KichCoService {

    KichCoRepository kcRepo = new KichCoRepository();

    @Override
    public List<KichCoViewModel> getAll() {
        List<KichCoModel> listAll = kcRepo.getAll();
        List<KichCoViewModel> listTable = new ArrayList<>();
        for (KichCoModel kc : listAll) {
            listTable.add(new KichCoViewModel(kc.getId(), kc.getMa(), kc.getLoaiSanPham(), kc.getKichCo(), kc.getRongVai(), kc.getEo(), kc.getDai(), kc.getCanNang(),kc.getChieuCao()));
        }
        return listTable;
    }

    @Override
    public String getAdd(KichCoViewModel kc) {
        KichCoModel kcmd = new KichCoModel(kc.getId(), kc.getMa(), kc.getLoaiSanPham(), kc.getKichCo(), kc.getRongVai(), kc.getEo(), kc.getDai(), kc.getCanNang(),kc.getChieuCao());
        boolean them = kcRepo.getAdd(kcmd);
        if (them) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String getUpdate(KichCoViewModel kc, int id) {
        KichCoModel kcmd = new KichCoModel(kc.getId(), kc.getMa(), kc.getLoaiSanPham(), kc.getKichCo(), kc.getRongVai(), kc.getEo(), kc.getDai(), kc.getCanNang(),kc.getChieuCao());
        boolean sua = kcRepo.getUpdate(kcmd, id);
        if (sua) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean xoa = kcRepo.getDelete( id);
        if (xoa) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

}
