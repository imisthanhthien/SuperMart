/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.CTPhieuXuat;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_CTPhieuXuat {
    
    public static ArrayList<CTPhieuXuat> DS_CTPhieuXuat()
    {
       
         ArrayList <CTPhieuXuat> dshh  = new ArrayList<>();
        try {
            String sql = "Select *from CTPhieuXuat";
            SQLProvider data = new SQLProvider();
            data.open();  
            ResultSet rs = data.executeQuery(sql);
            while (rs.next()) {
                CTPhieuXuat hh = new CTPhieuXuat();
                hh.setMaHH(rs.getInt("MaHH"));
                hh.setSoluongXuat(rs.getInt("SLXuat"));
                hh.setGiaxuat(rs.getFloat("GiaXuat"));
                hh.setThanhtien(rs.getFloat("Thanhtien"));
              
                dshh.add(hh);
            }
              data.close();
        } catch (Exception e) {
            
        }
        return dshh;
    }
     //Thêm Chi tiết Phiếu Xuất
      public static boolean InsertCTPhieuXuat(int manhomHH,int soluong,float gianhap,float thanhtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemPhieuXuatCT(?,?,?,?)}");
             
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
   //Sửa Chi tiết Phiếu Xuất
      public static boolean UpdateCTPhieuXuat(int maHH, int soluong, float giaxuat, float thanhtien)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call SuaPhieuXuatCT(?,?,?,?)}");
             
            cs.setInt(1, maHH);
            cs.setInt(2, soluong);
            cs.setFloat(3, giaxuat);
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
        //Xóa Chi tiết Phiếu Xuất
      public static boolean DeleteCTPhieuXuat(int maHH)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaPhieuXuatCT(?)}");
             
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
