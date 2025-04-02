/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_PhieuXuat {
     //Thanh toán CT Phiếu Xuất
      public static boolean ThanhToanCTPhieuXuat(String lydo, int manhanvien,int manhomKH,float tongtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call Addphieuxuat(?,?,?,?)}");
             
             cs.setString(1,  lydo);
            cs.setInt(2, manhanvien);
            cs.setFloat(3,manhomKH);
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
       //Remove CT phiếu xuất đã Thanh Toán
      public static boolean RemoveCTPhieuXuathadPay()
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaPhieuXuatTT()}");
             
          
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
      public static boolean UpdateTrangThai(int maPX,int trangthai)
      {
           boolean kq = false;
          try {
              String sql = "Update PhieuXuat set TrangThai = "+trangthai+"\n"
                      + " where MaPX = " + maPX;
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
