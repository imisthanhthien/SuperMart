/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_PhieuNhap {
    
     //Thanh toán CT Phiếu Nhập
      public static boolean ThanhToanCTPhieuNhap(String lydo, int manhanvien,int manhomNCC,float tongtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call Addphieunhap(?,?,?,?)}");
             
            cs.setString(1, lydo);
            cs.setInt(2, manhanvien);
            cs.setFloat(3,manhomNCC);
            cs.setFloat(4, tongtien);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
             
        }
        return kq;
        
        
    }
       //Remove CT phiếu nhập đã Thanh Toán
      public static boolean RemoveCTPhieuNhaphadPay()
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaPhieuNhapTT()}");
             
           
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
            
        }
        return kq;
    }
      public static boolean UpdateTrangThai(int maPN,int trangthai)
      {
           boolean kq = false;
          try {
              String sql = "Update PhieuNhap set TrangThai = "+trangthai+"\n"
                      + " where MaPN = " + maPN;
              SQLProvider adutrangthai = new SQLProvider();
              adutrangthai.open();
                      
              int x = adutrangthai.executeUpdate(sql);
               if (x == 1) {
                
                kq = true;
            }
              
          } catch (Exception e) {
          }
           return kq;
      }
}
