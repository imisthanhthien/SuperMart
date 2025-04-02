
package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
 public class GT_TLMN_BOT_TinhToan_va_RaQuyetDinh_ver_end extends GT_TLMN_General_ver_end{

    
  public GT_TLMN_BOT_TinhToan_va_RaQuyetDinh_ver_end(ArrayList<Card_Player_ver_end> arrLbaiplayerra,
        ArrayList<CardBot_ver_end> cacbobaicuatoi,int[] SoLaActor,
       int soLuongActor,int index_actor,int index_actor_truoc,int index_actor_sau,int bainhonhat) throws IOException {
      
      this.cardbot=cacbobaicuatoi;
      this.chieucualuot=chieucualuot;
      this.solabaitoira=arrLbaiplayerra.size();
       this.soLuongActor=soLuongActor;
       this.index_actor_sau=index_actor_sau;
       this.index_actor_truoc=index_actor_truoc;
        this.index_actor=index_actor;
        this.bainhonhat=bainhonhat;
        this.SoLaConLaiCuaActor=SoLaActor;
      int j=0;
     for(int i=0;i<solabaitoira;i++)
        {
            j++;
            sohieu_baidoithura[j]=arrLbaiplayerra.get(i).sohieu;  
            strbaiplayerchon+=arrLbaiplayerra.get(i).sohieu+"$";
            tongsohieulabaidothura+=arrLbaiplayerra.get(i).sohieu;
        }
      //System.out.println("Chu Trinh ket thuc ngan nhat: "+chuTrinhKetThucNganNhat());
       ctkt=chuTrinhKetThucNganNhat();
    }
 
  
  public String dapAnDiTruocMaxLength()
  {
       
       int lengthmax=1;
        String dapanmaxlength="koco";
      for(int i=0;i<cardbot.size();i++)
        {
         if(cardbot.get(i).sola>lengthmax)
            {
            lengthmax=cardbot.get(i).sola;
            dapanmaxlength=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
            }
        } 
     if(lengthmax==1) {return "koco";}
        return dapanmaxlength;
  }
  public String dapAnDiTruocMaxLengthGiuTop()
  {
       String s= sanhDep();
    if(!s.equals("koco")) 
    {
        for(int i=0;i<cardbot.size();i++)
        {
            if(s.equals(cardbot.get(i).daycard))
            {
                return cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
            }
        }
    }
       int lengthmax=0;
        String dapanmaxlength="koco";
      for(int i=0;i<cardbot.size();i++)
        {
            if((cardbot.get(i).loaibai.equals("sanh")
            ||(cardbot.get(i).loaibai.equals("bacon")&&cardbot.get(i).sumsohieu<138)
           ||(cardbot.get(i).loaibai.equals("doi")&&cardbot.get(i).sumsohieu<91))
           &&khongAnhHuongDenBaiBoBaiTop(cardbot.get(i).daycard)&&cardbot.get(i).sola>lengthmax
             )
                {
            lengthmax=cardbot.get(i).sola;
            dapanmaxlength=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
              }
      
        }
      return dapanmaxlength;
  }
   public String sanhDep()
  {
      
       int lengthmax=0;
       int sumsohieulengthmax=0;
        String sanhdep="koco";
      for(int i=0;i<cardbot.size();i++)
        {
            if(((cardbot.get(i).loaibai.equals("sanh")
             &&cardbot.get(i).sola>lengthmax&&
               khongAnhHuongDenBaiBoBaiTop(cardbot.get(i).daycard)==true)||  
               (((cardbot.get(i).loaibai.equals("badoithong")||cardbot.get(i).loaibai.equals("bondoithong"))
               &&SoLaConLaiCuaActor[index_actor]-cardbot.get(i).sola==1)))&&cardbot.get(i).sola>lengthmax)
            {
                lengthmax=cardbot.get(i).sola;
                sanhdep=cardbot.get(i).daycard;
                sumsohieulengthmax=cardbot.get(i).sumsohieu;
            }
        } 
       if(SoLaConLaiCuaActor[index_actor]-lengthmax<=3)
       {
       return  sanhdep;}
       if(lengthmax>=SoLaConLaiCuaActor[index_actor]/2||sumsohieulengthmax>tongsohieubaiconlai()/2)
       {
         return sanhdep;
       }
       
    return "koco";
  }
   public String dapAnDiTruocMaxSoHieu()
  {
       int sohieumax=0;
        String dapanmaxsohieu="koco";
      for(int i=0;i<cardbot.size();i++)
        {
           
            if((cardbot.get(i).loaibai.equals("doi")||cardbot.get(i).loaibai.equals("coc"))
             &&cardbot.get(i).sumsohieu>sohieumax)
            {
                sohieumax=cardbot.get(i).sumsohieu;
                dapanmaxsohieu=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
            }
        } 
      return dapanmaxsohieu;
  }
    public String dapAnDiTruocMaxSoHieuGiuTop()
  {
       int sohieumax=0;
        String dapanmaxsohieu="koco";
      for(int i=0;i<cardbot.size();i++)
        {
            if((cardbot.get(i).loaibai.equals("doi")||cardbot.get(i).loaibai.equals("coc")
             &&cardbot.get(i).sumsohieu>sohieumax)&&
                    khongAnhHuongDenBaiBoBaiTop(cardbot.get(i).daycard))
            {
                sohieumax=cardbot.get(i).sumsohieu;
                dapanmaxsohieu=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
            }
        } 
      return dapanmaxsohieu;
  }
   public String dapDiTruocLienQuanToiBaiNhoNhat(String bainhonhat)
   {
       String s=sanhDep();
       String k=s;
       if(!s.equals("koco"))
       {
           
               if(s.charAt(0)==bainhonhat.charAt(0) &&s.charAt(1)=='$') 
               {
                 for(int i=0;i<cardbot.size();i++)
        {
            if(s.equals(cardbot.get(i).daycard))
            {
                return cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
            }
        }
               }
       }
       String tempchua3bich="";
       int maxsola=0;
       for(int i=0;i<cardbot.size();i++)
        {
            if((cardbot.get(i).loaibai.equals("bacon")||
                    cardbot.get(i).loaibai.equals("sanh")
                    ||cardbot.get(i).loaibai.equals("doi"))&&
                    cardbot.get(i).daycard.charAt(0)==bainhonhat.charAt(0)&&
                    cardbot.get(i).daycard.charAt(1)=='$'&&
                    khongAnhHuongDenBaiBoBaiTop(cardbot.get(i).daycard)
                    &&cardbot.get(i).sola>maxsola)
            {
                maxsola=cardbot.get(i).sola;
                tempchua3bich=cardbot.get(i).daycard;
            }
        }
        for(int i=0;i<cardbot.size();i++)
        {
            if(tempchua3bich.equals(cardbot.get(i).daycard))
            {
                return cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
            }
        }
        
    return "1$coc$"+bainhonhat;
   }

  public String dapAnMinChanBaiGiuBaiTop()
  {
      luuDuLieuCacBoThoaManCoTinhHonSoVoi(sohieu_baidoithura,solabaitoira);
      int min=10000;
     String dapanmin="koco";
     if(baitopdoduoc==true)
      {
     if(SoLaConLaiCuaActor[1]==1&&tongsohieulabaidothura>=49&&mucDoUuTienRaBai()==0)
              return "koco";
      min=10000;
      for(int i=0;i<cardbot.size();i++)
      {
         for(int j=1;j<=countdapanlienquan;j++)
                 {
               if(dapanlienquan[j].equals(cardbot.get(i).daycard))
                 {
      if(cardbot.get(i).sumsohieu<min)
            {
                
            min=cardbot.get(i).sumsohieu;
  dapanmin=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
              }
                 }
                 }
      }
      }
     
     else if(solabaitoira==1&&sohieu_baidoithura[1]<49)
      {
           min=10000;
          for(int i=0;i<cardbot.size();i++)
          {
              String[] elebot=cardbot.get(i).daycard.split("\\$");
                     if(((cardbot.get(i).loaibai).equals("coc")||
                     (cardbot.get(i).loaibai).equals("baile")||
                     (cardbot.get(i).loaibai).equals("bathua")||
                     (cardbot.get(i).loaibai).equals("badacbiet"))&&
                    sohieu_baidoithura[solabaitoira]<Integer.parseInt(elebot[0]))
                     
             {
      if(cardbot.get(i).sumsohieu<min&&khongAnhHuongDenBaiBoBaiTop(cardbot.get(i).daycard)==true
          &&GiuDuocSanhDep(cardbot.get(i).daycard)==true
              /*&&khongLamTangChuTrinhKetThuc(cardbot.get(i).daycard)*/)
            {
            min=cardbot.get(i).sumsohieu;
  dapanmin=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
              }
             }
          }
      }
      else{
      for(int i=0;i<cardbot.size();i++)
      {
         for(int j=1;j<=countdapanlienquan;j++)
                 {
               if(dapanlienquan[j].equals(cardbot.get(i).daycard))
                 {
         if(cardbot.get(i).sumsohieu<min&&
            khongAnhHuongDenBaiBoBaiTop(cardbot.get(i).daycard)==true
                 &&GiuDuocSanhDep(cardbot.get(i).daycard)==true)
            {
            min=cardbot.get(i).sumsohieu;
  dapanmin=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
              }
                 }
                 }
      }
     }
      return dapanmin;
  }
  public boolean khongLamTangChuTrinhKetThuc(String baichon)
  {
int x=chuTrinhKetThucNganNhatTry(baichon);
      return true;
  }
  public void duyetmoitohopTry(String baichon) 
  {
    try {
       
        String K = baiconlai();
      
        sortTry(baichon);
       
        Integer[] arr = new Integer[900000];
        java.util.List<String> list = new ArrayList<String>();
        java.util.List<String> list2 = new ArrayList<String>();
        int count=0;
        for(int i=0;i<cardbot.size();i++)
        {
         /*   System.out.println(""+i+"\t"+tempdaycard[i]
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
  public int chuTrinhKetThucNganNhatTry(String baichon) 
  {
     /* for(;i<cardbot.size();i++)
            {
                if(cardbot.get(i).loaibai.equals("coc"))
                {
                    System.out.print(cardbot.get(i).daycard);
                }
            }*/
      /*if(tongSoLaConLai()>=13)
      {
          System.out.println("Thỏa mãn");
       
      }*/
      this.chutrinhketthuc=ctkt;
           duyetmoitohopTry(baichon);
           if(cochutrinhketthuc==true)
           {
               return ctkt;
           }
           
    return 13;
    
  }
  int country;
  
  
 public void sortTry(String baichon)
    {
        
        for(int i=0;i<cardbot.size();i++)
        {
            if(cardbot.get(i).daycard.equals(baichon)) 
            tempfullnameString[country]=cardbot.get(i).fullnamecard;
            tempdaycard[country]=cardbot.get(i).daycard;
            tempsola[country]=cardbot.get(i).sola;
            if(tempsola[country]>maxla)
                maxla=tempsola[country];
            System.out.println(""+tempfullnameString[country]);
            country++;
        }
        String tg1,tg2;int tg3;
              for(int u = 0; u < country-1 ; u++){
        for(int v = u + 1; v < country; v++){
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
              for(int i=0;i<country;i++)
              {
                 System.out.println(""+tempfullnameString[i]);
              }
    }
  public String dapAnMinDiTruoc_naivebayes(Bot_ver_end bot) throws IOException
{
   String s= sanhDep();
    if(!s.equals("koco")) 
    {
        for(int i=0;i<cardbot.size();i++)
        {
            if(s.equals(cardbot.get(i).daycard))
            {
                return cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
            }
        }
    }
     ml_naivebays_bot =new NaiveBayes_Bot_LearnData_ver_end(bot);
         ml_naivebays_bot.run();
       for(int i=1;i<ml_naivebays_bot.danhsachkieubaixacsuat.size();i++)
         {
             String temploaibainaivebayes=ml_naivebays_bot.
                     danhsachkieubaixacsuat.get(i).toString().trim();
             String[] c=temploaibainaivebayes.split("\\$");
                     
             for(int j=0;j<cardbot.size();j++)
             {
                  if((cardbot.get(j).loaibai.equals(temploaibainaivebayes)||
           (cardbot.get(j).loaibai.equals(c[0])&&cardbot.get(j).loaibai.equals(c[1])))
            &&khongAnhHuongDenBaiBoBaiTop(cardbot.get(j).daycard)==true)
          {
             return cardbot.get(j).sola+"$"+cardbot.get(j).loaibai+"$"+
  cardbot.get(j).daycard;
          }
             }
         }
     
    return "koco";
}
   public String dapAnMaxChanBaiGiuBaiTop()
  {
      luuDuLieuCacBoThoaManCoTinhHonSoVoi(sohieu_baidoithura,solabaitoira);
     String dapanmax="koco";
      int max=0;
      for(int i=0;i<cardbot.size();i++)
      {
         for(int j=1;j<=countdapanlienquan;j++)
                 {
               if(dapanlienquan[j].equals(cardbot.get(i).daycard))
                 {
         if(cardbot.get(i).sumsohieu>max&&
            khongAnhHuongDenBaiBoBaiTop(cardbot.get(i).daycard)==true
                 &&GiuDuocSanhDep(cardbot.get(i).daycard))
         {
                       max=cardbot.get(i).sumsohieu;
                       dapanmax=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
         }
                  }
                 }
      }
      return dapanmax;
  }
    public String dapChanBaiKhongDieuKien()
  {
      luuDuLieuCacBoThoaManCoTinhHonSoVoi(sohieu_baidoithura,solabaitoira);
     String dapanmax="koco";
      int max=0;
      for(int i=0;i<cardbot.size();i++)
      {
         for(int j=1;j<=countdapanlienquan;j++)
                 {
               if(dapanlienquan[j].equals(cardbot.get(i).daycard))
                 {
                     
         if(cardbot.get(i).sumsohieu>max)
         {
           max=cardbot.get(i).sumsohieu;
           dapanmax=cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
         }             
                  }
                 }
      }
      return dapanmax;
  }
     public String dapDiTruocMaxGiuTop()
  {
      String maxdapan=dapAnDiTruocMaxLengthGiuTop();
      if(maxdapan.equals("koco"))
      {
      maxdapan=dapAnDiTruocMaxSoHieuGiuTop();
      }
      return maxdapan;
  }
    public String dapDiTruocKhongDieuKien()
  {
      String maxdapan=dapAnDiTruocMaxLength();
      if(maxdapan.equals("koco"))
      {
      maxdapan=dapAnDiTruocMaxSoHieu();
      }
      return maxdapan;
  }
public boolean khongAnhHuongDenBaiBoBaiTop(String baichon)
     {
         int countSPTbaichon=0;
         for(int i=0;i<baichon.length();i++)
         {
             if(baichon.charAt(i)=='$') countSPTbaichon++;
         }
         String[] elebaichon=baichon.split("\\$");
         for(int i=0;i<cardbot.size();i++)
         {
             String[] elebot=cardbot.get(i).daycard.split("\\$");
        if(cardbot.get(i).loaibai.equals("badoithong")
        ||cardbot.get(i).loaibai.equals("tuquy")
        ||cardbot.get(i).loaibai.equals("bondoithong"))
        {
            int countSPTbaitop=0;
            for(int t=0;t<cardbot.get(i).daycard.length();t++)
            {
              if(cardbot.get(i).daycard.charAt(t)=='$')  countSPTbaitop++;
            }
            String[] elebaitop=cardbot.get(i).daycard.split("\\$");
            for(int a=0;a<countSPTbaitop;a++)
            {
                for(int b=0;b<countSPTbaichon;b++)
                {
                    if(elebaitop[a].equals(elebaichon[b]))
                    {
                        return false;
                    }
                }
            }
         }
      else if(cardbot.get(i).daycard.equals(baichon)
              &&cardbot.get(i).sumsohieu>=91&&cardbot.get(i).sola==2)
      {
      return false;}
         else if(cardbot.get(i).daycard.equals(baichon)
           &&cardbot.get(i).sumsohieu>=49&&cardbot.get(i).sola==1)
      {
          return false;}
         else if(cardbot.get(i).daycard.equals(baichon)
              &&cardbot.get(i).sumsohieu>=126&&cardbot.get(i).sola==3)
      {
          return false;}
         }
        return true;
     }
 

 
  public String dapAnBotChonRanDom()
    {
            Random rd = new Random();
            int index_dapanrandom = rd.nextInt(cardbot.size()-1);
            for(int i=0;i<cardbot.size();i++)
            {
                if(i==index_dapanrandom)
                {
                   return cardbot.get(i).sola+"$"+cardbot.get(i).loaibai+"$"+
  cardbot.get(i).daycard;
                }
            }
        return null;
        }
    public boolean GiuDuocSanhDep(String baichon)
  {
      String sanhdep=sanhDep();
      int n=0,m=0;
      for(int i=0;i<cardbot.size();i++)
            {
                if(cardbot.get(i).daycard.equals(sanhdep))
                {
                    n=cardbot.get(i).sola;
                }
                 if(cardbot.get(i).daycard.equals(baichon))
                {
                    m=cardbot.get(i).sola;
                }
            }
      if(sanhdep.equals("koco"))
      {
          return true;
      }
      else{
          int count=0;
          String[] s=sanhdep.split("\\$");
          String[] c=baichon.split("\\$");
          int start=0,end=0;
           for(int i=0;i<cardbot.size();i++)
           {
               String temp=s+"$";
               if(cardbot.get(i).daycard.equals(s[0]+"$")&&cardbot.get(i).loaibai.equals("coc"))
               {
                   start=i;
               }
               if(cardbot.get(i).daycard.equals(s[n-1]+"$")&&cardbot.get(i).loaibai.equals("coc"))
               {
                   end=i;
               }
           }
           for(int i=start;i<=end;i++)
           {
         if(lamTronLen((float)(cardbot.get(i).sumsohieu)/4)-
     lamTronLen((float)(Integer.parseInt(c[0]))/4)==0)
         {
                     count++;
         }
           }
          if(count==m) return false;
      }
    return true;
  }
  public int mucDoUuTienRaBai()
{
   if(soLuongActor==4) return mucDoUuTienRaBai4Actor();
   if(soLuongActor==3) return mucDoUuTienRaBai4Actor();
   if(soLuongActor==2) return mucDoUuTienRaBai2Actor();
      return 0;
}
  
 
 
}
