/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GT_TLMN_Player_ver_end extends GT_TLMN_General_ver_end{
 int solabaibotra;
 boolean coDapAn;
   int[] baibotra=new int[30];
   int solabaiplayerchon;
   String strbaitoichon;
   int[] labaiplayerchon=new int[30];
    public GT_TLMN_Player_ver_end(
            ArrayList<Card_Player_ver_end> arrLbaibotra,
            ArrayList<Card_Player_ver_end> arrLbaitoichon, 
            ArrayList<CardBot_ver_end> cacbobaicuatoi ) {
        int j=0;
        this.solabaiplayerchon=arrLbaitoichon.size();
        this.solabaibotra=arrLbaibotra.size();
        this.cardbot=cacbobaicuatoi;
        strbaitoichon="";
        for(int i=0;i<solabaiplayerchon;i++)
        {
            j++;
            labaiplayerchon[j]=arrLbaitoichon.get(i).sohieu;  
            strbaitoichon+=arrLbaitoichon.get(i).sohieu+"$";
        }
        j=0;
         for(int i=0;i<solabaibotra;i++)
        {
            j++;
            baibotra[j]=arrLbaibotra.get(i).sohieu;  
        }
    }
    public String nhanThongBaoTinhHopLeBaiDaChonCuaToi()
    {
       return timKieuBai(solabaiplayerchon,labaiplayerchon);
    }
    public boolean coDapAn()
    {
         luuDuLieuCacBoThoaManCoTinhHonSoVoi(baibotra,solabaibotra);
        if(countdapanlienquan!=0) return true;
        return false;
    }
    public boolean chanDuocBaiBot()
    {
        luuDuLieuCacBoThoaManCoTinhHonSoVoi(baibotra,solabaibotra);
                 for(int i=1;i<=countdapanlienquan;i++)
                 {
                    // //System.out.println("--"+dapanlienquan[i]);
                   if(strbaitoichon.equals(dapanlienquan[i])) return true;
                 }
         return false;
    }
    public boolean baiChonChuaBaiNhoNhat(String bainhonhat)
    {
        if(strbaitoichon.equals("")) return false;
        String[] temp=strbaitoichon.split("\\$");
        if(temp[0].equals(bainhonhat)) return true;
        return false;
    }
    public boolean boBaiChuaBaiNhoNhat(String bainhonhat)
    {
        for(int i=0;i<cardbot.size();i++)
        {
            if(cardbot.get(i).sumsohieu==Integer.parseInt(bainhonhat))
            {
                return true;
            }
        }
        return false;
    }
 
}
