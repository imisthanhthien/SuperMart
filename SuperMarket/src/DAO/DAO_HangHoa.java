/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import GUI.frmMain;
import POJO.HangHoa;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_HangHoa {
    public static Vector<HangHoa> DS_HangHoa()
    {
       
         Vector <HangHoa> dshh  = new Vector<>();
        try {
            
            SQLProvider data = new SQLProvider();
            data.open();  
            CallableStatement cs = (data.getConnection()).prepareCall("{call DS_HangHoa()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                HangHoa hh = new HangHoa();
                hh.setMaHH(rs.getInt("MaHH"));
                hh.setTenHH(rs.getString("TenHH"));
                hh.setTenLoai(rs.getString("Tenloai"));
                hh.setMoTa(rs.getString("Mota"));
                hh.setSoluong(rs.getInt("Soluong"));
                hh.setGiaBan( rs.getFloat("Giaban"));
                dshh.add(hh);
            }
              data.close();
        } catch (Exception e) {
            
        }
        return dshh;
    }
     public static ArrayList<HangHoa> DS_HangHoax()
    {
       
         ArrayList <HangHoa> dshh  = new ArrayList<>();
        try {
            
            SQLProvider data = new SQLProvider();
            data.open();  
            CallableStatement cs = (data.getConnection()).prepareCall("{call DS_HangHoa()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                HangHoa hh = new HangHoa();
                hh.setMaHH(rs.getInt("MaHH"));
                hh.setTenHH(rs.getString("TenHH"));
                hh.setTenLoai(rs.getString("Tenloai"));
                hh.setMoTa(rs.getString("Mota"));
                hh.setSoluong(rs.getInt("Soluong"));
                hh.setGiaBan( rs.getFloat("Giaban"));
                dshh.add(hh);
            }
              data.close();
        } catch (Exception e) {
            
        }
        return dshh;
    }
    
     //Thêm hàng hóa
      public static boolean InsertHangHoa(String TenHH,int manhomHH,String Mota,int soluong,float giaban)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemHH(?,?,?,?,?)}");
             
            cs.setString(1, TenHH);
            cs.setInt(2, manhomHH);
            cs.setString(3, Mota);
            cs.setInt(4, soluong);
            cs.setFloat(5, giaban);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
   //Sửa hàng hóa
      public static boolean UpdateHangHoa(int maHH,String TenHH,int manhomHH,String Mota,int soluong,float giaban)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call SuaHH(?,?,?,?,?,?)}");
             
             cs.setInt(1, maHH);
            cs.setString(2, TenHH);
            cs.setInt(3, manhomHH);
            cs.setString(4, Mota);
            cs.setInt(5, soluong);
            cs.setFloat(6, giaban);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
            
        }
        return kq;
    }
        //Xóa hàng hóa
      public static boolean DeleteHangHoa(int maHH) throws IOException
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call XoaHH(?)}");
             
            cs.setInt(1, maHH);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
              frmMain main = new frmMain();
             JOptionPane.showMessageDialog(main, "Không thể xóa hàng hóa này vui lòng xem lại!!!");
        }
        return kq;
    }
    
    
}
