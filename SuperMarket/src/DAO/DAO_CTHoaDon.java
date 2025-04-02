/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.CTHoaDon;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_CTHoaDon {
    
    public static ArrayList<CTHoaDon> DS_CTHoaDon()
    {
       
         ArrayList <CTHoaDon> dshd  = new ArrayList<>();
        try {
            String sql = "Select *from CTHoaDon";
            SQLProvider data = new SQLProvider();
            data.open();  
            ResultSet rs = data.executeQuery(sql);
            while (rs.next()) {
                CTHoaDon hh = new CTHoaDon();
                hh.setMaHH(rs.getInt("MaHH"));
                hh.setSoluong(rs.getInt("SoLuong"));
                hh.setGiaBan(rs.getFloat("GiaBan"));
                hh.setThanhtien(rs.getFloat("Thanhtien"));
              
                dshd.add(hh);
            }
              data.close();
        } catch (Exception e) {
            
        }
        return dshd;
    }
     //Thêm Chi tiết Hóa Đơn
      public static boolean InsertCTHoaDon(int manhomHH,int soluong,double giaban,double Thanhtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
            data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemCTHoaDon(?,?,?,?)}");
           
           
            cs.setInt(1, manhomHH);
            cs.setInt(2, soluong);
            cs.setDouble(3, giaban);
            cs.setDouble(4, Thanhtien);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
            data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
       //Xóa CT hóa đơn
      public static boolean DeleteChiTietHoaDon(int ma){
          boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
            data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaCTHD(?)}");
             
            cs.setInt(1, ma);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
             
        }
        return kq;
      }
      
      //Cập nhập CT hóa đơn
      public static boolean UpdateChiTietHoaDon(int ma, int soluong, float giaban){
          boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call CapNhapCTHD(?,?,?)}");
             
            cs.setInt(1, ma);
            cs.setInt(2, soluong);
            cs.setFloat(3, giaban);
            
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
