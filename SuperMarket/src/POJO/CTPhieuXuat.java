/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class CTPhieuXuat {
    int soPX, maHH;
    int soluongXuat;
    float giaxuat;
    float thanhtien;
    public CTPhieuXuat() {
    }

    public CTPhieuXuat(int soPX, int maHH, int soluongXuat, float giaxuat, float thanhtien) {
        this.soPX = soPX;
        this.maHH = maHH;
        this.soluongXuat = soluongXuat;
        this.giaxuat = giaxuat;
        this.thanhtien = thanhtien;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

   

    public int getSoPX() {
        return soPX;
    }

    public int getMaHH() {
        return maHH;
    }

    public int getSoluongXuat() {
        return soluongXuat;
    }

    public float getGiaxuat() {
        return giaxuat;
    }

    public void setSoPX(int soPX) {
        this.soPX = soPX;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public void setSoluongXuat(int soluongXuat) {
        this.soluongXuat = soluongXuat;
    }

    public void setGiaxuat(float giaxuat) {
        this.giaxuat = giaxuat;
    }
    
    
    
}
