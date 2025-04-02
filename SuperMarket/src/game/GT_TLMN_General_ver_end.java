

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import game.CardBot_ver_end;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GT_TLMN_General_ver_end {
    int countcard;
   int[] card=new int[14];
     boolean co2Co;
   String[] elethey=new String[100];
   int countdapanlienquan;
   int countdapanlienquansum;
   int[] dapanlienquansum=new int[100];
    String[] dapanlienquan=new String[100];
    boolean baitopdoduoc;
int solabaitoira;
   String strbaiplayerchon,chieucualuot;
   int[] sumSoHieu=new int[30];
   int[] sohieu_baidoithura=new int[30];
    int index_actor;
    int bainhonhat;
    int countbaimanh,tongsohieubaimanh;
    int indexuutien;
    int tongsohieulabaidothura;
    int soLuongActor;
    int[] SoLaConLaiCuaActor=new int[30];
    int index_actor_truoc,index_actor_sau,minactor,maxactor,tongSoLaDoiThu;
    GT_TLMN_PhanNhomBai_ver_end gttlmnpnb;
    NaiveBayes_Bot_LearnData_ver_end ml_naivebays_bot;
ArrayList<CardBot_ver_end> cardbot =new ArrayList<CardBot_ver_end>();
public GT_TLMN_General_ver_end() {
      
      
    }
    
    public boolean LaCoc()
    {
        if(countcard==1) return true;
        else return false;
    }
     public boolean LaSanh()
    {
        if(countcard<3) return false;
        for(int i=countcard;i>=2;i--)
        {
            if(card[i]>=49) return false;
            if((lamTronLen((float)card[i]/4)-
                    lamTronLen((float)card[i-1]/4)!=1)) 
                return false;
        }
        return true;
    }
      public boolean LaBaCon()
    {
        if((lamTronLen((float)card[3]/4)-lamTronLen((float)card[1]/4)==0)
                &&countcard==3)
            return true;
        return false;
    }
    public boolean LaDoi()
    {
     if((lamTronLen((float)card[2]/4)-lamTronLen((float)card[1]/4))==0
                 &&countcard==2)
             return true;
            return false;
         
    }
   
    public boolean LaTuQuy()
    {
         if((lamTronLen((float)card[4]/4)==
                 lamTronLen((float)card[1]/4))
                 &&countcard==4)
            return true;
        return false;
    }
    public boolean LaBaDoiThong()
    {
      
        if((lamTronLen((float)card[2]/4)-lamTronLen((float)card[1]/4))==0
        &&(lamTronLen((float)card[4]/4)-lamTronLen((float)card[3]/4))==0
          &&((lamTronLen((float)card[6]/4)-lamTronLen((float)card[5]/4))==0)
           &&((lamTronLen((float)card[8]/4)-lamTronLen((float)card[7]/4))==0)
           &&((lamTronLen((float)card[3]/4)-lamTronLen((float)card[1]/4)==1))
         &&(card[5]<49&&countcard==6) )
         return true;
        return false;
    }
    public boolean LaBonDoiThong()
    {
       
        if((lamTronLen((float)card[2]/4)-lamTronLen((float)card[1]/4))==0
        &&(lamTronLen((float)card[4]/4)-lamTronLen((float)card[3]/4))==0
          &&((lamTronLen((float)card[6]/4)-lamTronLen((float)card[5]/4))==0)
           &&((lamTronLen((float)card[8]/4)-lamTronLen((float)card[7]/4))==0)
           &&((lamTronLen((float)card[3]/4)-lamTronLen((float)card[1]/4)==1))
           &&((lamTronLen((float)card[5]/4)-lamTronLen((float)card[1]/4)==2))
          &&((lamTronLen((float)card[7]/4)-lamTronLen((float)card[1]/4)==3)
         &&(card[7]<49&&countcard==8) ))
         return true;
        return false;
    } 
  
    
    public String timKieuBai(int countcard,int[] card)
    {
  this.card=card;
  this.countcard=countcard;
   if(LaCoc()==true)
  {
    return "coc";
  }
 
  else if(LaDoi()==true) 
  { 
 return "doi";
  }
  
  else if(LaBaCon()==true)
  {
  return "bacon";
  }
  else if(LaTuQuy()==true) 
  {
     
  return "tuquy";
  }
  else if(LaBaDoiThong()==true) 
  {
   return "badoithong";
  }
  else if(LaBonDoiThong()==true) 
 {
  return "bondoithong";
  }
          
  else if(LaSanh()==true) 
  {
  return "sanh";
  }
        return "khonghople";
    }
    public int lamTronLen(float kqchia)
    {
        if(kqchia-(int)kqchia<0.01) return (int)kqchia;    
      
        return (int)kqchia+1;
    }
    public void luuDuLieuCacBoThoaManCoTinhHonSoVoi(int carddp[],int countdp)
    {
        
        String kieubai=timKieuBai(countdp, carddp);
       for(int i=0;i<cardbot.size();i++)
             {
                 
       String[] elebot=cardbot.get(i).daycard.split("\\$");
    if(cardbot.get(i).loaibai.equals(kieubai)
    &&cardbot.get(i).sola==countdp&&
            carddp[countdp]<Integer.parseInt(elebot[countdp-1]))
   
           {
           luuDuLieuCacDapAnLienQuan(i);
          }
             }
       
        if(kieubai.equals("coc")&&carddp[countdp]>=49)
       {
           for(int i=0;i<cardbot.size();i++)
             {
                 if(cardbot.get(i).loaibai.equals("badoithong")
                         ||cardbot.get(i).loaibai.equals("tuquy")
                         ||cardbot.get(i).loaibai.equals("bondoithong"))
                 {
                     baitopdoduoc=true;
                      luuDuLieuCacDapAnLienQuan(i);
                 }
             }
       }
        if(kieubai.equals("doi")&&carddp[countdp]>=49||kieubai.equals("badoithong"))
       {
           for(int i=0;i<cardbot.size();i++)
             {
                 if(cardbot.get(i).loaibai.equals("tuquy")
                         ||cardbot.get(i).loaibai.equals("bondoithong"))
                 {
                     baitopdoduoc=true;
                      luuDuLieuCacDapAnLienQuan(i);
                 }
                   
             }
       }
       
        if(kieubai.equals("tuquy"))
       {
           for(int i=0;i<cardbot.size();i++)
             {
                 if(cardbot.get(i).loaibai.equals("bondoithong")
                         )
                 {
                     baitopdoduoc=true;
                      luuDuLieuCacDapAnLienQuan(i);
                 }
                   
             }
       }
      
    }
    public boolean BiVaCham2(Vector<String> local, String B) throws IOException
    {
       /* System.out.print("Enter a character: ");
        // Read the char
        char ch = (char) System.in.read();*/
        String bien1="",bien2=B;int count1=0,count2=0;
     for(int i=0;i<local.size();i++)
     {
        bien1+=local.get(i).toString();
     }
       
        int count=0;
        for(int i=0;i<bien1.length();i++)
        {
            if(bien1.charAt(i)=='$') count1++;
        }
        for(int i=0;i<bien2.length();i++)
        {
            if(bien2.charAt(i)=='$') count2++;
        }
     //   System.out.println("count1: "+count1); System.out.println("count2: "+count2);
      //   System.out.println("--"+bien1);
       // System.out.println("--"+bien2);
     String temp1[]=bien1.split("\\$");
     String temp2[]=bien2.split("\\$");
     
     for(int i=0;i<count1;i++)
     {
     int count3=0;   
         for(int j=0;j<count2;j++)
         {
             if(temp2[j].equals(temp1[i]))
             {
                 //System.out.println("va cham ne");
                 return true;}
             }
         
     }
     return false;
     
    }
    
    
boolean cochutrinhketthuc;
int chutrinhketthuc;
     void unique_combination(int l, String sumString, String K,
                                   Vector<String> local,Vector<String> local2,
                                   Vector<String> A, Vector<String> B) throws IOException
    {
      //  
        if(cochutrinhketthuc==true) return;
        if (sapXepGiaTriTheoThuTuTangDanString(sumString).equals(K)) 
        {
            cochutrinhketthuc=true;
           /* System.out.print("{");
            for (int i = 0; i < local.size(); i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print("Đánh: "); System.out.print(local2.get(i));
                if (i != local.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("}");*/
            return;
        }
 
        // For all other combinations
        for (int i = l; i < A.size(); i++) {
            // Check if the sum exceeds K
            if (sumString.length() + A.get(i).length() > K.length())
                continue;
 
            // Check if it is repeated or not
            if (i > l && A.get(i) == A.get(i - 1) )
                continue;
           if(local.contains(A.get(i))) continue;
           if(BiVaCham2(local2,B.get(i))) continue;
           if(local.size()>(chutrinhketthuc-1)) continue;
            // Take the element into the combination
            //if(BiVaCham(tempvacham+=B.get(i))==true){tempvacham=""; continue;}
          
            local.add(A.get(i));
            local2.add(B.get(i));
 
            // Recursive call
            unique_combination(i + 1, sumString + A.get(i), K,
                               local,local2, A,B);
 
            // Remove element from the combination
            local.remove(local.size() - 1);
            local2.remove(local2.size() - 1);
        }
    }
 
    // Function to find all combination
    // of the given elements
    void Combination(Vector<String> A,Vector<String> B, String K) throws IOException
    {
        // Sort the given elements
 
        // To store combination
        Vector<String> local = new Vector<String>();
        Vector<String> local2 = new Vector<String>();
      
        unique_combination(0, "", K, local,local2, A,B);
    }
    public String sapXepGiaTriTheoThuTuTangDanString (String str)
{
    
  if(str.equals("")) return "";
        int count=0;
        ////////System.out.println(""+chuoicontohopdacbietsanhdoi[i]);
        for(int t=0;t<str.length();t++)
        {
            if(str.charAt(t)=='$')
            {
                count++;
            }
        }
        ////////System.out.println("Count "+count);
       String[] s=str.split("\\$");
       int[] temgiatricuachuoi=new int[30];
       for(int j=1;j<=count;j++)
       {
           temgiatricuachuoi[j]=Integer.valueOf(s[j-1]);
        //   //////System.out.print("-"+temgiatricuachuoi[j]);
       }
        int tg=0;
           for(int u = 1; u < count ; u++){
        for(int v = u + 1; v < count+1; v++){
           if(temgiatricuachuoi[u] > temgiatricuachuoi[v]){
            tg = temgiatricuachuoi[u];  
              temgiatricuachuoi[u] = temgiatricuachuoi[v];
               temgiatricuachuoi[v] = tg;   
        
                   }
                    }
   
         }
           
           str="";
            for(int j=1;j<=count;j++)
       {
            str+=String.valueOf(temgiatricuachuoi[j])+"$";           
       }
         //   //////System.out.println(chuoitohopdacbietsanhdoi[i]);
               
    return str;
}
    String tempfullnameString[]=new String[5000];
     String tempdaycard[]=new String[5000];
     int tempsola[]=new int[5000];
     int count_tohopchutrinh;
     int maxla=0;
    public void sort()
    {
        
        for(int i=0;i<cardbot.size();i++)
        {
            tempfullnameString[i]=cardbot.get(i).fullnamecard;
            tempdaycard[i]=cardbot.get(i).daycard;
            tempsola[i]=cardbot.get(i).sola;
            if(tempsola[i]>maxla)
                maxla=tempsola[i];
        }
        String tg1,tg2;int tg3;
              for(int u = 0; u < cardbot.size()-1 ; u++){
        for(int v = u + 1; v < cardbot.size(); v++){
           if(tempsola[u] > tempsola[v]){
            tg1 = tempfullnameString[u];  
              tempfullnameString[u] = tempfullnameString[v];
               tempfullnameString[v] = tg1;   
               tg2 = tempdaycard[u];  
              tempdaycard[u] = tempdaycard[v];
               tempdaycard[v] = tg2;   
               
               tg3 = tempsola[u];  
              tempsola[u] = tempsola[v];
               tempsola[v] = tg3;   
        
                   }
                    }
        }
             /* for(int i=0;i<cardbot.size();i++)
              {
                  System.out.println(""+tempfullnameString[i]);
              }*/
    }
  public void duyetmoitohop() 
  {
    try {
         
        String K = baiconlai();
      
       sort();
       
        Integer[] arr = new Integer[900000];
        java.util.List<String> list = new ArrayList<String>();
        java.util.List<String> list2 = new ArrayList<String>();
        int count=0;
        for(int i=0;i<cardbot.size();i++)
        {
           /* System.out.println(""+i+"\t"+tempdaycard[i]
                    +"\t"+cardbot.get(i).loaibai+"\t"+cardbot.get(i).sola+
                    "\t"+cardbot.get(i).fullnamecard
+"\t"+cardbot.get(i).sumsohieu);*/
            
            list.add(tempdaycard[i]);
            list2.add(tempfullnameString[i]);
            
        }
        Vector<String> A = new Vector<String>(list);
        Vector<String> B = new Vector<String>(list2);
        
        Combination(A,B, K);
    } catch (IOException ex) {
        Logger.getLogger(GT_TLMN_BOT_TinhToan_va_RaQuyetDinh_ver_end.class.getName()).log(Level.SEVERE, null, ex);
    }
       
  }
  
  public int chuTrinhKetThucNganNhat() 
  {
      int i=0;
     /* for(;i<cardbot.size();i++)
            {
                if(cardbot.get(i).loaibai.equals("coc"))
                {
                    System.out.print(cardbot.get(i).daycard);
                }
            }*/
      int start=0;int end=0;
      /*if(tongSoLaConLai()>=13)
      {
          System.out.println("Thỏa mãn");
       
      }*/
         end=3;
          start=1;
      for(i=start;i<=end;i++)
      {
      this.chutrinhketthuc=i;
           duyetmoitohop();
           if(cochutrinhketthuc==true)
           {
               return i;
           }
           
      }
    return 13;
    
  }
  public int tongsohieubaiconlai()
  {
      int sum=0;
     for(int i=0;i<cardbot.size();i++)
            {
                if(cardbot.get(i).loaibai.equals("coc"))
                {
                    sum+=cardbot.get(i).sumsohieu;
                }
            }
     return sum;
  }
  public String baiconlai()
  {
      String sum="";
     for(int i=0;i<cardbot.size();i++)
            {
                if(cardbot.get(i).loaibai.equals("coc"))
                {
                 //   System.out.print(cardbot.get(i).daycard);
                    sum+=cardbot.get(i).daycard;
                }
            }
     return sum;
  }
  public int tongSoLaConLai()
  {
      int sum=0;
     for(int i=0;i<cardbot.size();i++)
            {
                if(cardbot.get(i).loaibai.equals("coc"))
                {
                    sum++;
                }
            }
     return sum;
  }
     public void luuDuLieuCacDapAnLienQuan(int i)
    {
         countdapanlienquan++;
         dapanlienquan[countdapanlienquan]=cardbot.get(i).daycard;
         dapanlienquansum[countdapanlienquansum]=cardbot.get(i).sumsohieu;
         
    }
      public void xacDinhCacThongSoLienQuan()
 {
     minactor=10000;
     maxactor=0;
        for(int i=1;i<=soLuongActor;i++)
        {
            if(i!=index_actor)
            {
                tongSoLaDoiThu+=SoLaConLaiCuaActor[i];
                if(SoLaConLaiCuaActor[i]<minactor)
                {
                    minactor=SoLaConLaiCuaActor[i];
                }
                else if(SoLaConLaiCuaActor[i]>maxactor)
                {
                    maxactor=SoLaConLaiCuaActor[i];
                }
            }
        }
        for(int i=0;i<cardbot.size();i++)
        {
        if(cardbot.get(i).loaibai.equals("coc")&&cardbot.get(i).sumsohieu>=45)
        {
          countbaimanh++;
          tongsohieubaimanh+=cardbot.get(i).sumsohieu;
        }
        if(cardbot.get(i).loaibai.equals("badoithong")||
                cardbot.get(i).loaibai.equals("tuquy")||
                cardbot.get(i).loaibai.equals("bondoithong"))
        {
          countbaimanh++;
          tongsohieubaimanh+=cardbot.get(i).sumsohieu;
        }
        if(cardbot.get(i).loaibai.equals("coc")&&cardbot.get(i).sumsohieu==52)
        {
            co2Co=true;
        }
        }
 }
       int ctkt;
      public int mucDoUuTienRaBaiChung()
      {
          xacDinhCacThongSoLienQuan();
           for(int i=0;i<cardbot.size();i++)
        {
        if(cardbot.get(i).loaibai.equals("coc")&&cardbot.get(i).sumsohieu==bainhonhat)
        {indexuutien=1;     return 999;}
        }
         
           if(ctkt>4) System.out.println("Bot "+index_actor+"co chu trinh > 3");
        else System.out.println("Chu trinh ket thuc ngan nhat cua bot "+index_actor+"la: "+ctkt);
           if((ctkt==1)||(tongSoLaConLai()>=10&&ctkt<=3&&countbaimanh>=3)
                       ||(SoLaConLaiCuaActor[index_actor_sau]==1)
                       ||(minactor==1&&(ctkt<=3))||((minactor==1)&&countbaimanh>=2)) 
         {System.out.println("uu tien chu trinh toc chien max lenght");
         System.out.println("tại 4");return 99;}
        return 0;
      }
     public int mucDoUuTienRaBai4Actor()
    {
      int mdutrbc=mucDoUuTienRaBaiChung();
       if(mdutrbc!=0) return mdutrbc;
        if(ctkt<=2)
        {
            if(tongSoLaConLai()==3&&countbaimanh>=1)
    {System.out.println("uu Tien chu trinh < 2"); System.out.println("tại 1");return 99;}
   if(ctkt<=tongSoLaConLai()&&tongSoLaConLai()!=2) 
   {System.out.println("uu tien chu trinh toc chien so la nhieu hon 2"); System.out.println("tại 2");return 99;}
    if(ctkt<=tongSoLaConLai()&&tongSoLaConLai()==2&&co2Co==true) 
   {System.out.println("uu tien chu trinh toc chien co 2 co"); System.out.println("tại 3");return 99;}
        }
        
         if(solabaitoira==1&&ctkt<=3&&countbaimanh>=3) 
         {System.out.println("tại 5"); return 99;}
           if(SoLaConLaiCuaActor[index_actor_sau]==1)
           {
               if(SoLaConLaiCuaActor[index_actor_truoc]==1) {  indexuutien=2;  System.out.println("tại 6");return 99; }
               else if(countbaimanh>=2&&SoLaConLaiCuaActor[index_actor]>=4) 
                   {
           Random rd=new Random();
            int index_dapanrandom = rd.nextInt(3);
            if(index_dapanrandom==0) {System.out.println("random=9");return 9;}
            else {System.out.println("random=99");System.out.println("tại 7");return 99;}
                   }
               else if(index_actor_sau==1) return 99;
            }       
           if(SoLaConLaiCuaActor[index_actor_truoc]==1&&tongSoLaDoiThu>=91) return 99;
       if(soLuongActor==2&&(SoLaConLaiCuaActor[index_actor_sau]==2)) return 99;
     if(tongsohieulabaidothura>=50&&co2Co==true
             &&index_actor_truoc==1&&solabaitoira==1) 
     {System.out.println("TM");System.out.println("tại 8");return 99;}
       
     if(SoLaConLaiCuaActor[1]<=2)
      {  if(countbaimanh>=3) return 99;
      else return 98;
       }
     else if(minactor<=3&&countbaimanh<3)
       {
       if(SoLaConLaiCuaActor[index_actor]>=maxactor||
    ((SoLaConLaiCuaActor[index_actor]>tongSoLaDoiThu/(soLuongActor-1)&&tongSoLaDoiThu<(soLuongActor-1)*11)))
       {
           
       {  indexuutien=13;  return 8; }
       }
       }
    return 0;
    
    }
     public int mucDoUuTienRaBai2Actor()
     {
          int mdutrbc=mucDoUuTienRaBaiChung();
         
       if(mdutrbc!=0) return mdutrbc;
        //System.out.println("LCK");
         
          if((ctkt==2&&countbaimanh>=2)) return 99;
        if (countbaimanh>=3&&SoLaConLaiCuaActor[index_actor_sau]<=2)
        {
        if(SoLaConLaiCuaActor[index_actor]>SoLaConLaiCuaActor[index_actor_sau])    
            return 99;
        }
System.out.println("cout ctkt: "+ctkt+", count bai manh: "
        +countbaimanh+",SoLaConLaiCuaActor[index_actor] "+SoLaConLaiCuaActor[index_actor]
         +",SoLaConLaiCuaActor[index_actor_sau]: "+SoLaConLaiCuaActor[index_actor_sau]
+",Tong so la doi thu: "+tongSoLaDoiThu);

          //Xử lý tạm chốt được
          if(ctkt<=3&&tongsohieubaimanh>=50&&SoLaConLaiCuaActor[index_actor]>=7) return 99;
          
          //Xử lý bài yếu
          if(countbaimanh<=2 &&SoLaConLaiCuaActor[index_actor]>=8) return 99;
          //Xử lý chống ra 2 tép trở lên
          if(tongsohieulabaidothura>=50) return 99;
          //Xử lý còn 2 lá
          if(tongsohieubaimanh>=49&&SoLaConLaiCuaActor[index_actor]==2
                  &&tongsohieulabaidothura<49) return 99;
       return 0;
     }
    

}


