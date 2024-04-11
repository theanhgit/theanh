/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author pc
 */
public class KichCoModel {
    private int id;
    private String ma;
    private String loaiSanPham;
    private String kichCo;
    private String rongVai;
    private String eo;
    private String dai;
    private String canNang;
    private String chieuCao;

    public KichCoModel() {
    }

    public KichCoModel(int id, String ma, String loaiSanPham, String kichCo, String rongVai, String eo, String dai, String canNang, String chieuCao) {
        this.id = id;
        this.ma = ma;
        this.loaiSanPham = loaiSanPham;
        this.kichCo = kichCo;
        this.rongVai = rongVai;
        this.eo = eo;
        this.dai = dai;
        this.canNang = canNang;
        this.chieuCao = chieuCao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getRongVai() {
        return rongVai;
    }

    public void setRongVai(String rongVai) {
        this.rongVai = rongVai;
    }

    public String getEo() {
        return eo;
    }

    public void setEo(String eo) {
        this.eo = eo;
    }

    public String getDai() {
        return dai;
    }

    public void setDai(String dai) {
        this.dai = dai;
    }

    public String getCanNang() {
        return canNang;
    }

    public void setCanNang(String canNang) {
        this.canNang = canNang;
    }

    public String getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(String chieuCao) {
        this.chieuCao = chieuCao;
    }

    
    
    public Object[] toRowData(){
        return new Object[]{id,ma,loaiSanPham,kichCo,rongVai,eo,dai,canNang,chieuCao};
    }
}
