/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import GUI.frmMain;
import POJO.NhaCungCap;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DAO_NhaCungCap {
    
     public static Vector<NhaCungCap> DS_NhaCungCap()
    {
         Vector <NhaCungCap> dsncc  = new Vector<>();
        try {
            
            SQLProvider data = new SQLProvider();
            data.open();  
            CallableStatement cs = (data.getConnection()).prepareCall("{call DS_NCC()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setEmail(rs.getString(4));
                ncc.setSdt(rs.getString(5));
                dsncc.add(ncc);
            }
              data.close();
        } catch (Exception e) {
            
        }
        return dsncc;
    }
      //Thêm nhà cung cấp
    public static boolean InsertNhaCungCap(String tenNCC, String diachi,String email,String sdt)
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
            CallableStatement cs = (data.getConnection()).prepareCall("{call ThemNCC(?,?,?,?)}");
             cs.setString(1, tenNCC);
            cs.setString(2, diachi);
            cs.setString(3, email);
            cs.setString(4, sdt);
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           
        }
        return kq;
    }
    //Sửa nhà cung cấp
     public static boolean UpdateNhaCungCap(int maNCC,String tenNCC, String diachi,String sdt,String email) throws IOException
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
           CallableStatement cs = (data.getConnection()).prepareCall("{call UpdateNCC(?,?,?,?,?)}");
             
            cs.setInt(1, maNCC);
            cs.setString(2, tenNCC);
            cs.setString(3, diachi);
            cs.setString(4, sdt);
            cs.setString(5, email);
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
           frmMain main = new frmMain();
             JOptionPane.showMessageDialog(main, "Không thể sửa nhà cung cấp này vui lòng kiểm tra email, sđt!!!");
        }
        return kq;
    }
     
     //Xóa nhân viên
     public static boolean DeleteNhaCungCap(int maNCC) throws IOException
    {
        boolean kq = false;
        try {
            
            SQLProvider data = new SQLProvider();
             data.open(); 
           CallableStatement cs = (data.getConnection()).prepareCall("{call XoaNCC(?)}");
             
             cs.setInt(1, maNCC);
            
            int x = cs.executeUpdate();     
            
            if (x == 1) {
                
                kq = true;
            }
              data.close();
        } catch (Exception e) {
              frmMain main = new frmMain();
             JOptionPane.showMessageDialog(main, "Không thể xóa nhà cung cấp này vui lòng xem lại!!!");
        }
        return kq;
    }
}
