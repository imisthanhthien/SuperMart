/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class CTHoaDon {
    int maHH,maHD;
    int soluong;
    float giaBan;
    float thanhtien;
    public CTHoaDon() {
    }

    public CTHoaDon(int maHH, int maHD, int soluong, float giaBan, float thanhtien) {
        this.maHH = maHH;
        this.maHD = maHD;
        this.soluong = soluong;
        this.giaBan = giaBan;
        this.thanhtien = thanhtien;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }


    public int getMaHH() {
        return maHH;
    }

    public int getMaHD() {
        return maHD;
    }

    public int getSoluong() {
        return soluong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    public double ThanhTien(int soluong , float giaban)
    {
        return soluong * giaBan;
    }
    
}
