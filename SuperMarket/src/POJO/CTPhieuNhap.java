/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class CTPhieuNhap {
    int SoPN,maHH;
    int soluongNhap;
    float giaNhap;

    float thanhtien;
    public CTPhieuNhap() {
    }

    public CTPhieuNhap(int SoPN, int maHH, int soluongNhap, float giaNhap, float thanhtien) {
        this.SoPN = SoPN;
        this.maHH = maHH;
        this.soluongNhap = soluongNhap;
        this.giaNhap = giaNhap;
        this.thanhtien = thanhtien;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

   

    public int getSoPN() {
        return SoPN;
    }

    public int getMaHH() {
        return maHH;
    }

    public int getSoluongNhap() {
        return soluongNhap;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setSoPN(int SoPN) {
        this.SoPN = SoPN;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public void setSoluongNhap(int soluongNhap) {
        this.soluongNhap = soluongNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }
    
    
    
}
