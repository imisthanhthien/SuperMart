/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class ConnectDataBaseTLMN_NetBeans {
   Connection cnn=null;
  
   public Connection getConnectdatabase()
   {
   try
   {
  
  String uRL = "jdbc:derby:CSDL_TLMN\\DB";String user = "ttaht"; String pass = "qaz@123";
//  String uRL="jdbc:sqlserver://localhost;databasename=dataTLMN"; String user="sa";String pass="ssl";
            
       Class.forName("org.apache.derby.jdbc.ClientDriver");
            cnn = (Connection) DriverManager.getConnection(uRL,user,pass);
   
    cnn=DriverManager.getConnection(uRL, user,pass);
    // System.out.println("Thanh cong");
    return cnn;
   }
   catch(Exception e)
   {
       System.out.println("That bai");
   }
       return null;
   }
    public static void main(String[] args) {
        ConnectDataBaseTLMN_NetBeans cn=new ConnectDataBaseTLMN_NetBeans();
        cn.getConnectdatabase();
    }
}
