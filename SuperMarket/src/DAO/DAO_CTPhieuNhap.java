/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.CTPhieuNhap;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_CTPhieuNhap {
     public static ArrayList<CTPhieuNhap> DS_CTPhieuNHap()
    {
       
         ArrayList <CTPhieuNhap> dshh  = new ArrayList<>();
        try {
            String sql = "Select *from CTPhieuNhap";
            SQLProvider data = new SQLProvider();
            data.open();  
            ResultSet rs = data.executeQuery(sql);
            while (rs.next()) {
                CTPhieuNhap hh = new CTPhieuNhap();
                hh.setMaHH(rs.getInt("MaHH"));
                hh.setSoluongNhap(rs.getInt("SLNhap"));
                hh.setGiaNhap(rs.getFloat("GiaNhap"));
                hh.setThanhtien(rs.getFloat("Thanhtien"));
              
                dshh.add(hh);
            }
              data.close();
        } catch (Exception e) {
            
        }
        return dshh;
    }
      //Thêm Chi tiết Phiếu Nhập
      public static boolean InsertCTPhieuNhap(int manhomHH,int soluong,float gianhap,float thanhtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemPhieuNhap(?,?,?,?)}");
             
           cs.setInt(1, manhomHH);
            cs.setInt(2, soluong);
            cs.setFloat(3, gianhap);
            cs.setFloat(4, thanhtien);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
   //Sửa Chi tiết Phiếu Nhập
      public static boolean UpdateCTPhieuNhap(int maHH, int soluong, float gianhap, float thanhtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call SuaPhieuNhap(?,?,?,?)}");
             
            cs.setInt(1, maHH);
            cs.setInt(2, soluong);
            cs.setFloat(3, gianhap);
            cs.setFloat(4, thanhtien);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
        //Xóa Chi tiết Phiếu Nhập
      public static boolean DeleteCTPhieuNhap(int maHH)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaPhieuNhap(?)}");
             
           cs.setInt(1, maHH);
            
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
