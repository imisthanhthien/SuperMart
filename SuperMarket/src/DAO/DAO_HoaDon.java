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
public class DAO_HoaDon {
     //Thanh toán CT Hóa Đơn
    
    
      public static boolean ThanhToanCTHoaDon(int manv,int manhomKH,float tongtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
            data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemHoaDon(?,?,?)}");
             
            cs.setInt(1, manv);
            cs.setInt(2, manhomKH);
            cs.setFloat(3, tongtien);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
            
        }
        return kq;
        
        
    }
       //Remove CT hóa đơn đã Thanh Toán
      public static boolean RemoveCTHoaDonhadPay()
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaHoaDonThanhToan()}");
             
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
