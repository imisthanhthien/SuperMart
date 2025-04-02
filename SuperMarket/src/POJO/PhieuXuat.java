/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class PhieuXuat {
    int maPX;
    String ngayBan, lyDoXuat;
    int maNV, maKH;
    float thanhtien;

    public PhieuXuat() {
    }

    public PhieuXuat(int maPX, String ngayBan, String lyDoXuat, int maNV, int maKH, float thanhtien) {
        this.maPX = maPX;
        this.ngayBan = ngayBan;
        this.lyDoXuat = lyDoXuat;
        this.maNV = maNV;
        this.maKH = maKH;
        this.thanhtien = thanhtien;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }



    public int getMaPX() {
        return maPX;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public String getLyDoXuat() {
        return lyDoXuat;
    }

    public int getMaNV() {
        return maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaPX(int maPX) {
        this.maPX = maPX;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public void setLyDoXuat(String lyDoXuat) {
        this.lyDoXuat = lyDoXuat;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setMaKH(int maNCC) {
        this.maKH = maNCC;
    }
   
    
}
