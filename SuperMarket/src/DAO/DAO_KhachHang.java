/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.KhachHang;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_KhachHang {
    
     public static Vector<KhachHang> DS_KhachHang()
    {
         Vector <KhachHang> dskh  = new Vector<>();
        try {
            
            SQLProvider data = new SQLProvider();
            data.open();  
            CallableStatement cs = (data.getConnection()).prepareCall("{call loadTableKH()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setTenKH(rs.getString(2));
                kh.setDiaChi(rs.getString(3));
                kh.setSdt(rs.getString(4));
                dskh.add(kh);
            }
              data.close();
        } catch (Exception e) {
           
        }
        return dskh;
    }
      //Thêm khách hàng
    public static boolean InsertKhachHang(String TenKH,String DiaChi,String SDT)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemKH(?,?,?)}");
             
             
            cs.setString(1, TenKH);
            cs.setString(2, DiaChi);
            cs.setString(3, SDT);
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
    //Sửa khách hàng
     public static boolean UpdateKhachHang(int maKH,String TenKH,String DiaChi,String SDT)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
           CallableStatement cs = (data.getConnection()).prepareCall("{call SuaKH(?,?,?,?)}");
           
            cs.setInt(1, maKH);
            cs.setString(2, TenKH);
            cs.setString(3, DiaChi);
            cs.setString(4, SDT);
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
     
     //Xóa khách hàng
     public static boolean DeleteKhachHang(int maKH)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
           CallableStatement cs = (data.getConnection()).prepareCall("{call XoaKH(?)}");
             
            cs.setInt(1, maKH);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
}
