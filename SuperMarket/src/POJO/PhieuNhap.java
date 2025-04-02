/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class PhieuNhap {
    int maPN;
    String ngayNhap, lydoNhap;
    int maNV,MaNCC;

    float thanhtien;
    public PhieuNhap() {
    }

    public PhieuNhap(int maPN, String ngayNhap, String lydoNhap, int maNV, int MaNCC, float thanhtien) {
        this.maPN = maPN;
        this.ngayNhap = ngayNhap;
        this.lydoNhap = lydoNhap;
        this.maNV = maNV;
        this.MaNCC = MaNCC;
        this.thanhtien = thanhtien;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    

    public int getMaPN() {
        return maPN;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public String getLydoNhap() {
        return lydoNhap;
    }

    public int getMaNV() {
        return maNV;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaPN(int maPN) {
        this.maPN = maPN;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setLydoNhap(String lydoNhap) {
        this.lydoNhap = lydoNhap;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }
    
    
}
