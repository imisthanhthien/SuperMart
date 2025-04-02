/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class SQLProvider {
   
    public static Connection conn;
    
     public Connection connection;
     
     private CallableStatement callableStatement;
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public CallableStatement getCallableStatement() {
        return callableStatement;
    }

    public void setCallableStatement(CallableStatement callableStatement) {
        this.callableStatement = callableStatement;
    }
    

      public void open() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QL_BanHang;user=sa;password=123";
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
           
        }
    }
      public void openpublicn() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QL_BanHang;user=sa;password=123";
            conn = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (Exception e) {
           
        }
    }
    
    
    //Truy vấn dữ liệu
     public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (Exception e) {
            
        }
        return rs;
    }
     
     
     //update dữ liệu
    public int executeUpdate(String sql) {
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (Exception e) {
            
        }
        return n;
    }
      
}
