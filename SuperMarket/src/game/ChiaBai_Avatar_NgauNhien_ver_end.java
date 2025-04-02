/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.*;

public class ChiaBai_Avatar_NgauNhien_ver_end {

    public static int sophantulay = 13;
    public static int tongsophantu = 52;
    public String phanbai1;
    public String phanbai2;
    public String phanbai3;
    public String phanbai4;
    public String dataCard;
    boolean stop;
    String avatarnv[] = new String[1000];
    ArrayList arrInt, arrAVT;
    int m[] = new int[53];
//Constructor khong tham so

    public ChiaBai_Avatar_NgauNhien_ver_end() {
    }

//Phuong thuc xu ly
    public static ArrayList generate(int number) {

//Khai bao thanh phan trung gian
        ArrayList loca = new ArrayList();

        loca.add(0);
        int count = 0;
        int value;
        boolean flag;

        while (count < number) {

            flag = false;
            value = (int) (Math.random() * tongsophantu) + 1;//Gia su cac gia tri nam trong khoang tu 1 den 100
            for (int i = 0; i < loca.size(); i++) {

                if (((Integer) loca.get(i)).intValue() == value) {

                    flag = true;
                    break;

                }

            }

            if (!flag) {

                loca.add(value);
                count++;

            }

        }

        return loca;

    }
    int x[] = new int[1000];
    int avatarbot[][] = new int[1000][1000];
    int index_avatar_pl;
    int count;
    int n;

    public void getAvatar(int soluongavatar, int indexplayer) {
        n = soluongavatar;
        index_avatar_pl = indexplayer;
        toHopAvatar(1);
        Random rd = new Random();
        int temp;
        while (true) {
            temp = rd.nextInt(count);
            if (temp != 0) {
                break;
            }
        }
        avatarnv[1] = String.valueOf(index_avatar_pl);
        avatarnv[2] = String.valueOf(avatarbot[temp][1]);
        avatarnv[3] = String.valueOf(avatarbot[temp][2]);
        avatarnv[4] = String.valueOf(avatarbot[temp][3]);
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= 3; j++) {
                //  System.out.print(""+avatarbot[i][j]);
            }
            //   System.out.println("\n");
        }

    }

    public void toHopAvatar(int i) {

        for (int j = x[i - 1] + 1; j <= n - 3 + i; j++) {
            // if(stop==true) return;
            x[i] = j;
            if (i == 3) {
                Xuat();
            } else {
                toHopAvatar(i + 1);
            }
        }
    }

    private void Xuat() {

        for (int i = 1; i <= 3; i++) {
            //  System.out.print(" "+x[i]);
        }
        //  System.out.println("\n");
        if (x[1] != index_avatar_pl && x[2] != index_avatar_pl && x[3] != index_avatar_pl) {
            count++;
            avatarbot[count][1] = x[1];
            avatarbot[count][2] = x[2];
            avatarbot[count][3] = x[3];
            stop = true;
        }

    }

   
    public void getChiaBai() {
        arrInt = ChiaBai_Avatar_NgauNhien_ver_end.generate(52);
        phanbai1 = "";
        phanbai2 = "";
        phanbai3 = "";
        phanbai4 = "";
        dataCard = "";
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        int[] tempphanbai1 = new int[100];
        int[] tempphanbai2 = new int[100];
        int[] tempphanbai3 = new int[100];
        int[] tempphanbai4 = new int[100];
        for (int i = 1; i <= tongsophantu; i++) {
            m[i] = Integer.parseInt(arrInt.get(i).toString());
            dataCard += String.valueOf(m[i]) + "$";
            if (i >= 1 && i <= 13) {
                count1++;
                tempphanbai1[count1] = m[i];
            } else if (i >= 14 && i <= 26) {
                count2++;
                tempphanbai2[count2] = m[i];
            }
            if (i >= 27 && i <= 39) {
                count3++;
                tempphanbai3[count3] = m[i];
            }
            if (i >= 40 && i <= 52) {
                count4++;
                tempphanbai4[count4] = m[i];
            }
        }
        sapxep(tempphanbai1);
        sapxep(tempphanbai2);
        sapxep(tempphanbai3);
        sapxep(tempphanbai4);
        for (int i = 1; i <= 13; i++) {
            phanbai1 += String.valueOf(tempphanbai1[i]) + "$";
            phanbai2 += String.valueOf(tempphanbai2[i]) + "$";
            phanbai3 += String.valueOf(tempphanbai3[i]) + "$";
            phanbai4 += String.valueOf(tempphanbai4[i]) + "$";
        }
    }
    
    //Sắp xếp bài theo thứ tự từ bé đến lớn
    public void sapxep(int[] k) {
        int tg = 0;
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 12; j++) {
                if (k[i] < k[j]) {
                    tg = k[i];
                    k[i] = k[j];
                    k[j] = tg;
                }
            }
        }
    }

    public static void main(String[] args) {

        ChiaBai_Avatar_NgauNhien_ver_end s = new ChiaBai_Avatar_NgauNhien_ver_end();

        s.getAvatar(7, 2);

    }

}
