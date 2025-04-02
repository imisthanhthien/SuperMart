/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;


/**
 *
 * @author NGUYEN THANH THIEN
 */
public class HangHoa {
    

    int maHH;
    String tenHH;
    int maLoai;
    String tenLoai;
    String moTa;
    int Soluong;
    float giaBan;
    
    
    public HangHoa() {
    }

    public HangHoa(int maHH, String tenHH, int maLoai, String moTa, int Soluong, float giaBan) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.maLoai = maLoai;
        this.moTa = moTa;
        this.Soluong = Soluong;
        this.giaBan = giaBan;
    }

    public HangHoa(int maHH, String tenLoai, String moTa, int Soluong, float giaBan) {
        this.maHH = maHH;
        this.tenLoai = tenLoai;
        this.moTa = moTa;
        this.Soluong = Soluong;
        this.giaBan = giaBan;
    }

  

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }
    

    

    public int getMaHH() {
        return maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setMaHH(int maHH) {
        this.maHH = maHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    
    
}
