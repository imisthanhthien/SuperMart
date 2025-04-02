/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this ele[2]late file, choose Tools | Templates
 * and open the ele[2]late in the editor.
 */

package game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class JAVA_TLMN_CSDL_Naivebayes {
     String[] ele=new String[30];
     ArrayList KQ=new ArrayList();
       double S;
       int indexActor;
       String TENBANG="tableTLMNold";
      double[] T=new double[30];
     ArrayList danhsachxacxuat=new ArrayList();
        ConnectDataBaseTLMN_NetBeans kn=new ConnectDataBaseTLMN_NetBeans();
        Connection cn=kn.getConnectdatabase();
     private int SOCOT_or_SOHANG;
    String[] COT=new String[15];
     int COUNT;
    
    public JAVA_TLMN_CSDL_Naivebayes(String[] COT,String TENBANG,String[] eleCot,int SOCOT_or_SOHANG) {
        this.SOCOT_or_SOHANG=SOCOT_or_SOHANG;
            for(int i=1;i<=SOCOT_or_SOHANG;i++)
            {
                this.ele[i]=eleCot[i];
            //    ////System.out.println("-"+ele[i]);
            }
            this.COT=COT;
            this.TENBANG=TENBANG;
      KQ.add("0");
    
      
    }
      public int count2DieuKien(String tencot,String dieukien1,String dieukien2) throws FileNotFoundException, IOException
    {
        
     try
    {
        Statement stm=cn.createStatement();
        String k="SELECT COUNT("+
                tencot+")  FROM "+TENBANG+" Where "+tencot+"='"+dieukien1
                +"'and "+COT[SOCOT_or_SOHANG]+"='"+dieukien2+"'";
        //System.out.println("hi"+k);
        ResultSet rs=
      stm.executeQuery(k);
        while(rs.next())
        {
            //System.out.println("2ĐK: "+rs.getInt(1));
            return rs.getInt(1);
        }
    }
    catch(Exception e)
    {
        //////System.out.println(e);
    }
    
        
      return 0;
    }
      public int count1DieuKien(String tencot,String dieukien1) throws FileNotFoundException, IOException
    {
       try
    {
        Statement stm=cn.createStatement();
        String k="SELECT COUNT("+
                tencot+")  FROM "+TENBANG+" Where "+tencot+"='"+dieukien1+"'";
       // //System.out.println(k);
        ResultSet rs=
      stm.executeQuery(k);
        while(rs.next())
        {
         //System.out.println("1ĐK: "+rs.getInt(1));
            return rs.getInt(1);
        }
    }
    catch(Exception e)
    {
        //////System.out.println(e);
    }
         return 0;
    }
       public int count0DieuKien(String tencot) throws FileNotFoundException, IOException
    {
         try
    {
        Statement stm=cn.createStatement();
        String k="SELECT COUNT("+
                tencot+")  FROM "+TENBANG;
        ResultSet rs=
      stm.executeQuery(k);
        while(rs.next())
        {
          //System.out.println("count: "+rs.getInt(1));
            return rs.getInt(1);
        }
    }
    catch(Exception e)
    {
        //////System.out.println(e);
    }
         return 0;
    }
   public double tinhXSthanhphan(int i) throws IOException
   {
       double S=1.0;
       for(int j=1;j<SOCOT_or_SOHANG;j++)
       {
           S*=count2DieuKien(COT[j],ele[j],KQ.get(i).toString());
      //System.out.println("S: "+S);
       }
   ////////System.out.println("V: "+Math.pow(count1DieuKien(COT[SOCOT_or_SOHANG], KQ.get(i).toString()), 4));
       return S/(Math.pow(count1DieuKien(COT[SOCOT_or_SOHANG], KQ.get(i).toString()), SOCOT_or_SOHANG-1))
           *count1DieuKien(COT[SOCOT_or_SOHANG], KQ.get(i).toString())/COUNT;
   }
   public void  loccacloaiKQ()

   {
        try
    {
        Statement stm=cn.createStatement();
        String k="SELECT DISTINCT "+COT[SOCOT_or_SOHANG]+" FROM "+TENBANG;
        ResultSet rs=
      stm.executeQuery(k);
        while(rs.next())
        {
           // //////System.out.println("count: "+rs.getString(1));
            KQ.add(rs.getString(1));
        }
    }
    catch(Exception e)
    {
        //////System.out.println(e);
    }
   }
    public void tinhXSKetQua() throws IOException
    {
        loccacloaiKQ();
       COUNT=count0DieuKien(COT[SOCOT_or_SOHANG]);
        //////System.out.println("SỐ BỘ DATA ĐÃ LƯU: "+COUNT);
      
       
        //Kiểm thử
           // //////System.out.println("test: "+count2DieuKien(COT[3],"2","doi"));
  for(int i=1;i<=KQ.size()-1;i++)
  {
      S+=tinhXSthanhphan(i);
  }
   //System.out.println("S="+S);
  for(int i=1;i<=KQ.size()-1;i++)
  {
  T[i]=tinhXSthanhphan(i)/S;
//System.out.println("XS với KQ "+KQ.get(i).toString()+" là: "+T[i]);
  danhsachxacxuat.add(T);
  }
        //////System.out.println("Sau sắp xếp");
   double tg1;
   String tg2;
    for(int i = 1; i < KQ.size()-1 ; i++){
        for(int j = i + 1; j < KQ.size()-1; j++){
            if(T[i] < T[j]){
                // Hoan vi 2 so a[i] va a[j]
                tg1 = T[i];tg2=KQ.get(i).toString();
                T[i] = T[j];KQ.set(i, KQ.get(j).toString());
                T[j] = tg1; KQ.set(j, tg2);
            }
        }
    }
        System.out.println("\n\n========Machine Learning NaiveBayes. Máy "+indexActor+" đi trước==============");
    for(int i=1;i<=KQ.size()-1;i++)
  {
 System.out.println("Xác suất với lựa chọn "+KQ.get(i).toString()+" là: "+T[i]);
  }
    }
    public void luuBoDaTaTranning(String actor)
    {
        String kqhl=null;
        Scanner sc=new Scanner(System.in);
        if(actor.equals("bot"))
        {
            
            kqhl=sc.nextLine();
            ele[13]=kqhl;
        }
          try
    {
        Statement stm=cn.createStatement();
        String kqtruyvan="select * from "+TENBANG+" where "+COT[1]+"='"+ele[1]+"'\n" +
"and "+COT[2]+"='"+ele[2]+"' and "+COT[3]+"='"+ele[3]
  +"' and "+COT[4]+"='"+ele[4]+"' and "+COT[5]+"='"+ele[5]+"'\n" +
"and "+COT[6]+"='"+ele[6]+"' and "+COT[7]+"='"+ele[7]
  +"' and "+COT[8]+"='"+ele[8]+"' and "+COT[9]+"='"+ele[9]+"' \n" +
"and "+COT[10]+"='"+ele[10]+"' and "+COT[11]+"='"+ele[11]+
  "' and "+COT[12]+"='"+ele[12]+"' and "+COT[13]+"='"+ele[13]+
 "';";
        ////System.out.println("Xem truy van: "+kqtruyvan);
       String k="INSERT INTO "+TENBANG+"("+COT[1]+","+COT[2]+","+COT[3]+","+COT[4]+","+COT[5]+","+COT[6]+","+COT[7]+""
         + ","+COT[8]+","+COT[9]+","+COT[10]+","+COT[11]+","+COT[12]+","+COT[13]+")" 
       + "VALUES ('"+ele[1]+"','"+ele[2]+"','"+ele[3]+"'"
         + ",'"+ele[4]+"','"+ele[5]+"','"+ele[6]
        +"','"+ele[7] +"','"+ele[8]+"'"+ ",'"
        +ele[9]+"','"+ele[10]+"','"
        +ele[11]+"','"+ele[12]+"','"
      +ele[13]+"')";  
           System.out.println(k);
  if(actor.equals("player"))  {System.out.println("update");  stm.executeUpdate(k);}
         cn.close();
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    
    }
    public void luuBoDataSoLuongLaConLaiCuaNguoiChoiThua() throws SQLException
    {
        Statement stm=cn.createStatement();
        String[] k=new String[4];
        for(int i=1;i<=SOCOT_or_SOHANG;i++)
        {
           
        k[i]="INSERT "+TENBANG+"("+COT[1]+") " 
         + "VALUES ('"+ele[i]+"');"; 
       
        stm.executeUpdate(k[i]);
        }
         cn.close();
    }
    public static void main(String[] args) throws SQLException, IOException {

    }
   
    
}
