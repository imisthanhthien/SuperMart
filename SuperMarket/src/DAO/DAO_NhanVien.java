/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import GUI.frmMain;
import POJO.NhanVien;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_NhanVien {
   
    public static Vector<NhanVien> DS_NhanVien()
    {
         Vector <NhanVien> dsnv  = new Vector<>();
        try {
            
            SQLProvider data = new SQLProvider();
            data.open();  
            CallableStatement cs = (data.getConnection()).prepareCall("{call DS_NhanVien()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("Gioitinh"));
                nv.setEmail(rs.getString("Email"));
                nv.setVaiTro(rs.getInt("Vaitro"));
                nv.setTinhTrang(rs.getInt("Tinhtrang"));
                dsnv.add(nv);
            }
              data.close();
        } catch (Exception e) {
           
        }
        return dsnv;
    }
    //Thêm nhân viên
    public static boolean InsertNhanVien(String tennv, String gioitinh,String email,int vaitro,String pass)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("insert into NhanVien(TenNV,Gioitinh,Email,Vaitro,Matkhau) values (?,?,?,?,?)");
             
            cs.setString(1, tennv);
            cs.setString(2, gioitinh);
            cs.setString(3, email);
            cs.setInt(4,vaitro);
            cs.setString(5, pass);
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
            
        }
        return kq;
    }
    //Sửa nhân viên
     public static boolean UpdateNhanVien(int maNV,String TenNV,String Gender,String Email,int vaitro)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
           CallableStatement cs = (data.getConnection()).prepareCall("{call SuaNV(?,?,?,?,?)}");
             
            cs.setInt(1,  maNV);
            cs.setString(2, TenNV);
            cs.setString(3, Gender);
            cs.setString(4, Email);
            cs.setInt(5,  vaitro);
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
     
     //Xóa nhân viên
     public static boolean DeleteNhanVien(int maNV) throws IOException
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
           CallableStatement cs = (data.getConnection()).prepareCall("{call XoaNV(?)}");
             
            cs.setInt(1,  maNV);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
             frmMain main = new frmMain();
             JOptionPane.showMessageDialog(main, "Không thể xóa nhân viên này vui lòng xem lại!!!");
        }
        return kq;
    }
}
