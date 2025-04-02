/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.LoaiHangHoa;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_LoaiHangHoa {
    
     
     public static Vector<LoaiHangHoa> DS_LoaiHangHoa()
    {
         Vector <LoaiHangHoa> dslhh  = new Vector<>();
        try {
            
            SQLProvider data = new SQLProvider();
            data.open();  
            CallableStatement cs = (data.getConnection()).prepareCall("{call DS_LoaiSP()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                LoaiHangHoa lhh = new LoaiHangHoa();
                lhh.setMaLoai(rs.getInt("Maloai"));
                lhh.setTenLoai(rs.getString("Tenloai"));
                dslhh.add(lhh);
            }
              data.close();
        } catch (Exception e) {
           
        }
        return dslhh;
    }
     
     //Thêm loại hàng hóa
      public static boolean InsertLoaiHangHoa(String tenloai)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemLoaiHH(?)}");
             
            cs.setString(1, tenloai);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
        //Sửa loại hàng hóa
      public static boolean UpdateLoaiHangHoa(int maLoaiHH,String TenLoai)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call SuaLoaiHH(?,?)}");
             
            cs.setInt(1, maLoaiHH);
            cs.setString(2, TenLoai);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (SQLException e) {
            
        }
        return kq;
    }
        //Xóa loại hàng hóa
      public static boolean DeleteLoaiHangHoa(int maLoaiHH)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaLoaiHH(?)}");
             
            cs.setInt(1, maLoaiHH);
            
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
