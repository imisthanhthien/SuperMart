/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class NhanVien {
   
    int maNV;
    String tenNV,diaChi,gioiTinh, email;
    int vaiTro, tinhTrang;
    String matkhau;
    
    public NhanVien() {
    }

    public NhanVien(int maNV, String tenNV, String gioiTinh, String email, int vaiTro, int tinhTrang) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.vaiTro = vaiTro;
        this.tinhTrang = tinhTrang;
    }

    public NhanVien(int maNV, String tenNV, String diaChi, String gioiTinh, String email, int vaiTro, int tinhTrang) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.vaiTro = vaiTro;
        this.tinhTrang = tinhTrang;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

  
    

    public int getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
     

    
}
