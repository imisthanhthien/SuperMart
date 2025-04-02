/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;


/**
 *
 * @author Admin
 */
public class CardBot_ver_end{
    public String loaibai;
    public int sola;
    public int sumsohieu;
    public String daycard;
    public String fullnamecard;
    public CardBot_ver_end(String loaibai,int sola,String daycard,int sumsohieu)
    {
        this.loaibai=loaibai;
        this.sola=sola;
        this.daycard=daycard;
        this.sumsohieu=sumsohieu;
       
        giaiMaSoHieuRaFullNameCard();
    }
   public  void giaiMaSoHieuRaFullNameCard()
    { 
        String[] s=daycard.split("\\$");
         fullnamecard="";
        int count=0;
        int[] temp=new int[30];
        for(int t=0;t<daycard.length();t++)
        {
            if(daycard.charAt(t)=='$')
            {
                count++;//////System.out.println(" "+count);
            }
        }
       for(int i=0;i<count;i++)
       {
           String str="";
           temp[i]=Integer.valueOf(s[i]);
           if(temp[i]==1) str="3B"; 
           if(temp[i]==2) str="3T"; 
           if(temp[i]==3) str="3R"; 
           if(temp[i]==4) str="3C"; 
           
           if(temp[i]==5) str="4B"; 
           if(temp[i]==6) str="4T"; 
           if(temp[i]==7) str="4R"; 
           if(temp[i]==8) str="4C"; 
           
           if(temp[i]==9) str="5B"; 
           if(temp[i]==10) str="5T"; 
           if(temp[i]==11) str="5R"; 
           if(temp[i]==12) str="5C"; 
           
           if(temp[i]==13) str="6B"; 
           if(temp[i]==14) str="6T"; 
           if(temp[i]==15) str="6R"; 
           if(temp[i]==16) str="6C"; 
           
           if(temp[i]==17) str="7B"; 
           if(temp[i]==18) str="7T"; 
           if(temp[i]==19) str="7R"; 
           if(temp[i]==20) str="7C"; 
           
           if(temp[i]==21) str="8B"; 
           if(temp[i]==22) str="8T"; 
           if(temp[i]==23) str="8R"; 
           if(temp[i]==24) str="8C"; 
           
           if(temp[i]==25) str="9B"; 
           if(temp[i]==26) str="9T"; 
           if(temp[i]==27) str="9R"; 
           if(temp[i]==28) str="9C"; 
           
            if(temp[i]==29) str="XB"; 
           if(temp[i]==30) str="XT"; 
           if(temp[i]==31) str="XR"; 
           if(temp[i]==32) str="XC";
           
            if(temp[i]==33) str="JB"; 
           if(temp[i]==34) str="JT"; 
           if(temp[i]==35) str="JR"; 
           if(temp[i]==36) str="JC";
           
             if(temp[i]==37) str="QB"; 
           if(temp[i]==38) str="QT"; 
           if(temp[i]==39) str="QR"; 
           if(temp[i]==40) str="QC";
           
             if(temp[i]==41) str="KB"; 
           if(temp[i]==42) str="KT"; 
           if(temp[i]==43) str="KR"; 
           if(temp[i]==44) str="KC";
           
             if(temp[i]==45) str="AB"; 
           if(temp[i]==46) str="AT"; 
           if(temp[i]==47) str="AR"; 
           if(temp[i]==48) str="AC";
           
             if(temp[i]==49) str="2B"; 
           if(temp[i]==50) str="2T"; 
           if(temp[i]==51) str="2R"; 
           if(temp[i]==52) str="2C";
           
               
           fullnamecard+=str+"$";
           
        // ////System.out.print("-"+temp[i]);
       }
        
    }
    
}
