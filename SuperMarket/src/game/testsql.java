/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class testsql {
    public static void main(String[] args) throws SQLException {
        
       ConnectDataBaseTLMN_NetBeans kn=new ConnectDataBaseTLMN_NetBeans();
        Connection cn=kn.getConnectdatabase();
         Statement stm=cn.createStatement(); 
       ResultSet rs=stm.executeQuery("select count(*) as total  from tablelichsudau");
       int x=0;
       while(rs.next())
       {
           x=rs.getInt(1);
       }
        System.out.println(""+x);
/*String qrString="insert into tablelichsudau values("+575+",'"+"AA"+"',"+666+",'A'"+",'"+555+"')";
        System.out.println(qrString);
        stm.executeUpdate(qrString);*/
        
 Date date = new Date();  
    SimpleDateFormat  formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
    String strDate  = formatter.format(date);  
    System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);  
    }
}
