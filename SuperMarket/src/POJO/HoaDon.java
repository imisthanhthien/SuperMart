/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author thien
 */
public class HoaDon {
    int mahd, manv, makh;
    String ngaylap;
    float tongtien;

    public HoaDon() {
    }

    public HoaDon(int mahd, int manv, int makh, String ngaylap, float tongtien) {
        this.mahd = mahd;
        this.manv = manv;
        this.makh = makh;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
    }

    public int getMahd() {
        return mahd;
    }

    public int getManv() {
        return manv;
    }

    public int getMakh() {
        return makh;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
    
    
}
