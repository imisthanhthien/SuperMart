/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.util.ArrayList;


public class GT_TLMN_PhanNhomBai_ver_end extends GT_TLMN_General_ver_end {

    int numbbaiconlaicuatoi;

    String dapAnCuaBot;
    int[] baiconlaicuatoi = new int[30];
    int[] cardDBsanhdoi = new int[30];
    int[] cardDB3c3or4dt = new int[30];
    String dapantoitrang;
    int nsanhdoi, ksanhdoi, n3c3or4dt, k3c3or4dt, chuoihoanvithu;
    String[] vitrilabaidon = new String[20];
    String[] vitrilabailabaile = new String[20];
    String[] vitrilabaiLQtoidoi = new String[20];
    String[] vitrilabaiLQtoibacon = new String[20];
    String[] vitrilabaithuacua3dt_4dt = new String[20];
    String[] vitrilabaiLQtoituquy = new String[20];
    String[] vitrilabaiLQtoisanh = new String[20];
    String[] vitrilabaiLQtoibadoithong = new String[20];
    String[] vitrilabaiLQtoibondoithong = new String[20];
    String[] vitrilabaidacbietsanhdoi = new String[20];
    String[] chuoitohopdacbietsanhdoi = new String[1000];
    String[] chuoitohopdacbiet3convs3or4dt = new String[1000];

    String chuoirootsanhdoi, chuoiroot3convs3or4dt;
    int[] x = new int[1000];
    String[] chuoicontohopdacbietsanhdoi = new String[1000];
    String[] chuoicontohopdacbiet3convs3or4dt = new String[1000];
    int countchuoicontohopdacbietsanhdoi;
    int countchuoicontohopdacbiet3convs3or4dt;
    int countohopdacbietsanhdoihople, countohopdacbiet3convs3dtor4dthople;
    String chuoilabaiconlaicuatoi;
    int indexactor;

    public GT_TLMN_PhanNhomBai_ver_end(ArrayList<Card_Player_ver_end> baiconlaicuatoi) {

        ////////System.out.println("--"+theyCardVuaRastr+numbtheycardVuaRa);
        int j = 0;
        numbbaiconlaicuatoi = baiconlaicuatoi.size();
        chuoilabaiconlaicuatoi = "";
        for (int i = 0; i < numbbaiconlaicuatoi; i++) {
            j++;
            this.baiconlaicuatoi[j] = baiconlaicuatoi.get(i).sohieu;
            chuoilabaiconlaicuatoi += String.valueOf(baiconlaicuatoi.get(i).sohieu) + "$";

        }

    }

    //điền
    public int lamTronLen(float kqchia) {

     
        if (kqchia - (int) kqchia < 0.01) {
            return (int) kqchia;
        }

        return (int) kqchia + 1;
    }

    public void xacDinhViTriLaBaiDon() {
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            vitrilabaidon[i] = "c";
            int SUM = baiconlaicuatoi[i];
            CardBot_ver_end temp = new CardBot_ver_end("coc",
                    1, String.valueOf(baiconlaicuatoi[i]) + "$", SUM);
            cardbot.add(temp);
        }
    }

    public void xacDinhViTriLienQuanVaLuuDuLieuLaBaiLaDoi() {
        String tempSDL;
        int SUM = 0;
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if ((baiconlaicuatoi[i + 1] - baiconlaicuatoi[i] <= 3) && (lamTronLen((float) baiconlaicuatoi[i + 1] / 4) - lamTronLen((float) baiconlaicuatoi[i] / 4)) == 0) {
                vitrilabaiLQtoidoi[i + 1] = vitrilabaiLQtoidoi[i] = "d";
                tempSDL = String.valueOf(baiconlaicuatoi[i]) + "$" + String.valueOf(baiconlaicuatoi[i + 1]) + "$";
                SUM = baiconlaicuatoi[i] + baiconlaicuatoi[i + 1];
                CardBot_ver_end temp = new CardBot_ver_end("doi", 2, tempSDL, SUM);
                cardbot.add(temp);
            }
        }
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (vitrilabaiLQtoidoi[i] == null) {

                vitrilabaiLQtoidoi[i] = "x";
            }
        }

    }

    public void xacDinhViTriLienQuanVaLuuDuLieuLaBaiLaBaCon() {
        String tempSDL;
        int SUM;
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (baiconlaicuatoi[i + 2] - baiconlaicuatoi[i] <= 3 && (lamTronLen((float) baiconlaicuatoi[i + 2] / 4) - lamTronLen((float) baiconlaicuatoi[i] / 4)) == 0) {
                vitrilabaiLQtoibacon[i + 2] = vitrilabaiLQtoibacon[i + 1] = vitrilabaiLQtoibacon[i] = "bc";
                tempSDL = String.valueOf(baiconlaicuatoi[i]) + "$" + String.valueOf(baiconlaicuatoi[i + 1]) + "$" + String.valueOf(baiconlaicuatoi[i + 2]) + "$";
                SUM = baiconlaicuatoi[i] + baiconlaicuatoi[i + 1] + baiconlaicuatoi[i + 2];
                CardBot_ver_end temp = new CardBot_ver_end("bacon", 3, tempSDL, SUM);
                cardbot.add(temp);
                SUM = baiconlaicuatoi[i] + baiconlaicuatoi[i + 2];
                CardBot_ver_end tempdoi1 = new CardBot_ver_end("doi", 2, String.valueOf(baiconlaicuatoi[i]) + "$" + String.valueOf(baiconlaicuatoi[i + 2]) + "$", SUM);
                cardbot.add(tempdoi1);
                //bo sung them to hop la doi
       
            }
        }
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (vitrilabaiLQtoibacon[i] == null) {

                vitrilabaiLQtoibacon[i] = "x";
            }
        }

    }

    public void xacDinhViTriLienQuanVaLuuDuLieuLaBaiLaTuQuy() {
        String tempSDL;
        int SUM;
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (baiconlaicuatoi[i + 3] - baiconlaicuatoi[i] <= 3 && (lamTronLen((float) baiconlaicuatoi[i + 3] / 4) - lamTronLen((float) baiconlaicuatoi[i] / 4)) == 0) {
                vitrilabaiLQtoituquy[i + 3] = vitrilabaiLQtoituquy[i + 2]
                        = vitrilabaiLQtoituquy[i + 1] = vitrilabaiLQtoituquy[i] = "tq";
                tempSDL = String.valueOf(baiconlaicuatoi[i]) + "$" + String.valueOf(baiconlaicuatoi[i + 1])
                        + "$" + String.valueOf(baiconlaicuatoi[i + 2]) + "$" + String.valueOf(baiconlaicuatoi[i + 3]) + "$";
                SUM = baiconlaicuatoi[i] + baiconlaicuatoi[i + 1] + baiconlaicuatoi[i + 2] + baiconlaicuatoi[i + 3];
                CardBot_ver_end temp = new CardBot_ver_end("tuquy", 4, tempSDL, SUM);
                cardbot.add(temp);
                SUM = baiconlaicuatoi[i] + baiconlaicuatoi[i + 2];
                CardBot_ver_end tempdoi1 = new CardBot_ver_end("doi", 2, String.valueOf(baiconlaicuatoi[i]) + "$" + String.valueOf(baiconlaicuatoi[i + 2]) + "$", SUM);
                cardbot.add(tempdoi1);
                SUM = baiconlaicuatoi[i + 1] + baiconlaicuatoi[i + 3];
                CardBot_ver_end tempdoi2 = new CardBot_ver_end("doi", 2, String.valueOf(baiconlaicuatoi[i + 1]) + "$" + String.valueOf(baiconlaicuatoi[i + 3]) + "$", SUM);
                cardbot.add(tempdoi2);
                SUM = baiconlaicuatoi[i + 3] + baiconlaicuatoi[i + 2] + baiconlaicuatoi[i];
                CardBot_ver_end temp3con1 = new CardBot_ver_end("bacon", 3, String.valueOf(baiconlaicuatoi[i]) + "$" + String.valueOf(baiconlaicuatoi[i + 2]) + "$" + String.valueOf(baiconlaicuatoi[i + 3]) + "$", SUM);
                cardbot.add(temp3con1);
                SUM = baiconlaicuatoi[i] + baiconlaicuatoi[i + 1] + baiconlaicuatoi[i + 3];
                CardBot_ver_end temp3con2 = new CardBot_ver_end("bacon", 3, String.valueOf(baiconlaicuatoi[i]) + "$" + String.valueOf(baiconlaicuatoi[i + 1]) + "$" + String.valueOf(baiconlaicuatoi[i + 3]) + "$", SUM);
                cardbot.add(temp3con2);
            }
        }
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (vitrilabaiLQtoituquy[i] == null) {

                vitrilabaiLQtoituquy[i] = "x";
            }
        }

    }

    /**/
    public void xacDinhViTriLienQuanVaLuuDuLieuLaBaiLe() {
        int SUM;
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (vitrilabaiLQtoibacon[i].equals("x")
                    && vitrilabaiLQtoidoi[i].equals("x")
                    && vitrilabaiLQtoisanh[i].equals("x")) {
                vitrilabailabaile[i] = "bl";

                CardBot_ver_end temp = new CardBot_ver_end("baile", 1, String.valueOf(baiconlaicuatoi[i]) + "$", baiconlaicuatoi[i]);
                cardbot.add(temp);
            } else {
                vitrilabailabaile[i] = "x";
            }
        }
    }

    public void xacDinhCacViTri() {
        xacDinhViTriLaBaiDon();
        xacDinhViTriLienQuanVaLuuDuLieuLaBaiLaDoi();
        xacDinhViTriLienQuanVaLuuDuLieuLaBaiLaBaCon();
        xacDinhViTriLienQuanVaLuuDuLieuLaBaiLaTuQuy();
        xacDinhViTriLienQuanLaBaiLaSanh();
        xacDinhViTriLienQuanVaLuuDuLieuLaBaiLe();
        xacDinhViTriLienQuanLaBaiDacBiet();
    }

    public void xacDinhViTriLienQuanLaBaiLaSanh() {
        int t = 0;
        for (int i = 1; i <= 13; i++) {
            if (checkXuoivsXuoiNguocvsNguocViTriLQToiSanh(i) == true) {
                vitrilabaiLQtoisanh[i] = "s";
            } else {
                vitrilabaiLQtoisanh[i] = "x";
            }
        }
    }

    public boolean checkXuoivsXuoiNguocvsNguocViTriLQToiSanh(int i) {
        for (int j = i; j <= 13; j++) {
            for (int t = i; t <= 13; t++) {
                
                if (baiconlaicuatoi[t] <= 48 && baiconlaicuatoi[j] <= 48
                        && baiconlaicuatoi[i] <= 48 && lamTronLen((float) baiconlaicuatoi[j] / 4)
                        - lamTronLen((float) baiconlaicuatoi[i] / 4) == 1
                        && lamTronLen((float) baiconlaicuatoi[t] / 4) - lamTronLen((float) baiconlaicuatoi[i] / 4) == 2) {
                   
                    return true;
                }
            }
        }

        for (int j = i; j <= 13; j++) {
            for (int t = i; t >= 1; t--) {

                if (baiconlaicuatoi[j] <= 48 && lamTronLen((float) baiconlaicuatoi[j] / 4) - lamTronLen((float) baiconlaicuatoi[i] / 4) == 1
                        && lamTronLen((float) baiconlaicuatoi[i] / 4) - lamTronLen((float) baiconlaicuatoi[t] / 4) == 1) {
                  
                    return true;
                }
            }

        }
        for (int j = i; j >= 1; j--) {
            for (int t = i; t >= 1; t--) {

                if (baiconlaicuatoi[i] <= 48 && lamTronLen((float) baiconlaicuatoi[i] / 4) - lamTronLen((float) baiconlaicuatoi[j] / 4) == 1
                        && lamTronLen((float) baiconlaicuatoi[i] / 4) - lamTronLen((float) baiconlaicuatoi[t] / 4) == 2) {
                    
                    return true;
                }
            }
        }
        return false;
    }

    public void xacDinhViTriLienQuanLaBaiDacBiet() {

        chuoirootsanhdoi = "";

        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
        
        }
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
           
        }
        
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if ((vitrilabaiLQtoidoi[i].equals("d") || vitrilabaiLQtoibacon[i].equals("bc"))
                    & vitrilabaiLQtoisanh[i].equals("s")) {
                vitrilabaidacbietsanhdoi[i] = "dbsanhdoi";
                CardBot_ver_end temp = new CardBot_ver_end("baidacbiet", 1, String.valueOf(baiconlaicuatoi[i]) + "$", baiconlaicuatoi[i]);
                cardbot.add(temp);
            } else {
                vitrilabaidacbietsanhdoi[i] = "x";
                chuoirootsanhdoi += baiconlaicuatoi[i] + "$";
            }
        }
    }

    public void MoRongToHopSanhDoi() {

        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (vitrilabaidacbietsanhdoi[i].equals("dbsanhdoi")) {
                if ((vitrilabaiLQtoituquy[i].equals("tq"))) {
                    ksanhdoi++;
                    i += 3;
                } else if ((vitrilabaiLQtoibacon[i].equals("bc"))) {
                    ksanhdoi++;
                    i += 2;
                } else if ((vitrilabaiLQtoidoi[i].equals("d"))) {
                    ksanhdoi++;
                    i += 1;
                }
            }
        }
    
        if (ksanhdoi == 0) {
          
            for (int l = 3; l <= 13; l++) {
                timSanhTuChuoiToHopVaDoDaiChuoiChoTruoc(chuoilabaiconlaicuatoi, l);
            }
            return;
        }

        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if (vitrilabaidacbietsanhdoi[i].equals("dbsanhdoi")) {
               
                nsanhdoi++;
                cardDBsanhdoi[nsanhdoi] = baiconlaicuatoi[i];

            }
        }
      

        x[0] = 0;
        ToHopSanhDoi(1);

        for (int i = 1; i <= countchuoicontohopdacbietsanhdoi; i++) {/* //////System.out.println(""+chuoicontohopdacbietsanhdoi[i]);*/

            if (toHopConBaiDBSanhDoiCoChuaDoi(ksanhdoi, chuoicontohopdacbietsanhdoi[i]) == false) {
              
                countohopdacbietsanhdoihople++;
                chuoitohopdacbietsanhdoi[countohopdacbietsanhdoihople] = chuoirootsanhdoi + chuoicontohopdacbietsanhdoi[i];
               
            }

        }
        

    }

    void XuatnghiemSanhDoi() {
        countchuoicontohopdacbietsanhdoi++;
        chuoicontohopdacbietsanhdoi[countchuoicontohopdacbietsanhdoi] = "";
        for (int i = 1; i <= ksanhdoi; i++) {

            ////////System.out.print(" "+x[i]);
            chuoicontohopdacbietsanhdoi[countchuoicontohopdacbietsanhdoi] += cardDBsanhdoi[x[i]] + "$";

        }
        // //////System.out.println("");

    }

    void ToHopSanhDoi(int i) {
        for (int j = x[i - 1] + 1; j <= nsanhdoi - ksanhdoi + i; j++) {
            x[i] = j;
            if (i == ksanhdoi) {
                XuatnghiemSanhDoi();
            } else {
                ToHopSanhDoi(i + 1);
            }
        }
    }

    public boolean toHopConBaiDBSanhDoiCoChuaDoi(int num, String s) {
        int[] card = new int[10];
        String[] c = s.split("\\$");
        for (int i = 1; i <= num; i++) {
            ////////System.out.print(""+Integer.parseInt(c[i]));
            card[i] = Integer.parseInt(c[i - 1]);
        }

        for (int i = 1; i <= num; i++) {
            if ((card[i + 1] - card[i] <= 3) && (lamTronLen((float) card[i + 1] / 4) - lamTronLen((float) card[i] / 4)) == 0) {
                return true;
            }
        }
        return false;
    }

    public void sapXepGiaTriTheoThuTuTangDanTrongToHopDB(String[] str, int n) {

        for (int i = 1; i <= n; i++) {
            int count = 0;
            ////////System.out.println(""+chuoicontohopdacbietsanhdoi[i]);
            for (int t = 0; t < str[i].length(); t++) {
                if (str[i].charAt(t) == '$') {
                    count++;
                }
            }
            ////////System.out.println("Count "+count);
            String[] s = str[i].split("\\$");
            int[] temgiatricuachuoi = new int[30];
            for (int j = 1; j <= count; j++) {
                temgiatricuachuoi[j] = Integer.valueOf(s[j - 1]);
                //   //////System.out.print("-"+temgiatricuachuoi[j]);
            }
            int tg = 0;
            for (int u = 1; u < count; u++) {
                for (int v = u + 1; v < count + 1; v++) {
                    if (temgiatricuachuoi[u] > temgiatricuachuoi[v]) {
                        tg = temgiatricuachuoi[u];
                        temgiatricuachuoi[u] = temgiatricuachuoi[v];
                        temgiatricuachuoi[v] = tg;

                    }
                }

            }

            str[i] = "";
            for (int j = 1; j <= count; j++) {
                str[i] += String.valueOf(temgiatricuachuoi[j]) + "$";
            }
            //   //////System.out.println(chuoitohopdacbietsanhdoi[i]);

        }
    }

    public void timBonDoiThongTuChuoiToHopVaDoDaiChuoiChoTruoc(String str) {
        String temp4DT;
        int count = 0;
        int[] temp = new int[30];
        for (int t = 0; t < str.length(); t++) {
            if (str.charAt(t) == '$') {
                count++;
            }
        }
        ////////System.out.println("Count "+count);
        String[] s = str.split("\\$");

        for (int j = 1; j <= count; j++) {
            temp[j] = Integer.valueOf(s[j - 1]);
            // //////System.out.print("-"+temp[j]);
        }
        for (int i = 1; i <= count; i++) {
            if (temp[i + 6] >= 49) {
                continue;
            }
            if ((lamTronLen((float) temp[i + 1] / 4) - lamTronLen((float) temp[i] / 4)) == 0
                    && (lamTronLen((float) temp[i + 2] / 4) - lamTronLen((float) temp[i + 1] / 4)) == 1
                    && (lamTronLen((float) temp[i + 3] / 4) - lamTronLen((float) temp[i + 2] / 4)) == 0
                    && (lamTronLen((float) temp[i + 4] / 4) - lamTronLen((float) temp[i + 3] / 4)) == 1
                    && (lamTronLen((float) temp[i + 5] / 4) - lamTronLen((float) temp[i + 4] / 4)) == 0
                    && (lamTronLen((float) temp[i + 6] / 4) - lamTronLen((float) temp[i + 5] / 4)) == 1
                    && (lamTronLen((float) temp[i + 7] / 4) - lamTronLen((float) temp[i + 6] / 4)) == 0) {
                for (int j = 1; j <= numbbaiconlaicuatoi; j++) {
                    for (int k = 0; k <= 7; k++) {
                        if (temp[i + k] == baiconlaicuatoi[j]) {
                            vitrilabaiLQtoibondoithong[j] = "4dt";
                        }
                    }
                }
                temp4DT = String.valueOf(temp[i]) + "$" + String.valueOf(temp[i + 1])
                        + "$" + String.valueOf(temp[i + 2]) + "$" + String.valueOf(temp[i + 3])
                        + "$" + String.valueOf(temp[i + 4]) + "$" + String.valueOf(temp[i + 5])
                        + "$" + String.valueOf(temp[i + 6]) + "$" + String.valueOf(temp[i + 7]) + "$";
                CardBot_ver_end bondt = new CardBot_ver_end("bondoithong", 8, temp4DT, 0);

                cardbot.add(bondt);
            }
        }

    }

    public void timBaDoiThongTuChuoiToHopVaDoDaiChuoiChoTruoc(String str) {
        String temp3DT;
        int count = 0, SUM;
        int[] temp = new int[30];
        for (int t = 0; t < str.length(); t++) {
            if (str.charAt(t) == '$') {
                count++;
            }
        }
        ////////System.out.println("Count "+count);
        String[] s = str.split("\\$");

        for (int j = 1; j <= count; j++) {
            temp[j] = Integer.valueOf(s[j - 1]);
            // //////System.out.print("-"+temp[j]);
        }
        for (int i = 1; i <= count; i++) {
            if (temp[i + 4] >= 48) {
                continue;
            }
            if ((lamTronLen((float) temp[i + 1] / 4) - lamTronLen((float) temp[i] / 4)) == 0
                    && (lamTronLen((float) temp[i + 2] / 4) - lamTronLen((float) temp[i + 1] / 4)) == 1
                    && (lamTronLen((float) temp[i + 3] / 4) - lamTronLen((float) temp[i + 2] / 4)) == 0
                    && (lamTronLen((float) temp[i + 4] / 4) - lamTronLen((float) temp[i + 3] / 4)) == 1
                    && (lamTronLen((float) temp[i + 5] / 4) - lamTronLen((float) temp[i + 4] / 4)) == 0) {
                for (int j = 1; j <= numbbaiconlaicuatoi; j++) {
                    for (int k = 0; k <= 5; k++) {
                        if (temp[i + k] == baiconlaicuatoi[j]) {
                            vitrilabaiLQtoibadoithong[j] = "3dt";
                        }
                    }
                }
                temp3DT = String.valueOf(temp[i]) + "$" + String.valueOf(temp[i + 1])
                        + "$" + String.valueOf(temp[i + 2]) + "$" + String.valueOf(temp[i + 3])
                        + "$" + String.valueOf(temp[i + 4]) + "$" + String.valueOf(temp[i + 5]) + "$";
                int kt = 0;
                SUM = temp[i] + temp[i + 1] + temp[i + 2] + temp[i + 3] + temp[i + 4] + temp[i + 5];
                for (int u = 0; u < cardbot.size(); u++) {

                    if (cardbot.get(u).daycard.equals(temp3DT)) {
                        kt = 1;
                        break;
                    }

                }
                if (kt == 0) {
                    CardBot_ver_end badt = new CardBot_ver_end("badoithong", 6, temp3DT, SUM);
                    cardbot.add(badt);
                }

            }
        }
    }

    public void timSanhTuChuoiToHopVaDoDaiChuoiChoTruoc(String str, int dodaisanh) {
        int count = 0, SUM = 0;
        int[] temp = new int[30];

        for (int t = 0; t < str.length(); t++) {
            if (str.charAt(t) == '$') {
                count++;
            }
        }
      
        String[] s = str.split("\\$");

        for (int j = 1; j <= count; j++) {
            temp[j] = Integer.valueOf(s[j - 1]);
           
        }
       

        for (int i = 1; i <= count - 2; i++) {
            SUM = 0;
            String sanh = "";
            int flag = 0;
            for (int j = i; j <= i + dodaisanh - 2; j++) {
                sanh += String.valueOf(temp[j]) + "$";
                SUM += temp[j];
                if (j == i + dodaisanh - 2) {
                    sanh += String.valueOf(temp[j + 1]) + "$";
                    SUM += temp[j + 1];
                }
                if (lamTronLen((float) temp[j + 1] / 4) - lamTronLen((float) temp[j] / 4) != 1 || temp[j + 1] > 48 || temp[j] > 48) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 0) {
                int kt = 0;
                for (int u = 0; u < cardbot.size(); u++) {

                    if (cardbot.get(u).daycard.equals(sanh)) {
                        kt = 1;
                        break;
                    }

                }
                if (kt == 0) {
                    CardBot_ver_end cb = new CardBot_ver_end("sanh", dodaisanh, sanh, SUM);
                    cardbot.add(cb);
                }

               
            }
        }
    }

    public void MoRongToHopBaConvaBahoacBonDoiThong() {
        chuoiroot3convs3or4dt = "";
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            vitrilabaiLQtoibondoithong[i] = "x";
            vitrilabaiLQtoibadoithong[i] = "x";
            if (vitrilabaiLQtoibacon[i].equals("bc")) {
                n3c3or4dt++;
                cardDB3c3or4dt[n3c3or4dt] = baiconlaicuatoi[i];
            } else {
                chuoiroot3convs3or4dt += baiconlaicuatoi[i] + "$";
            }
        }

        k3c3or4dt = 2 * n3c3or4dt / 3;
     
        if (n3c3or4dt == 0) {
          
            timBaDoiThongTuChuoiToHopVaDoDaiChuoiChoTruoc(chuoilabaiconlaicuatoi);
            timBonDoiThongTuChuoiToHopVaDoDaiChuoiChoTruoc(chuoilabaiconlaicuatoi);

            return;
        }
      

        x[0] = 0;
        ToHopBaConva3or4DoiThong(1);

     
        for (int i = 1; i <= countchuoicontohopdacbiet3convs3or4dt; i++) {

            if (toHopConBaiDBBaConva3DTor4DTCoChuaBaCon(k3c3or4dt, chuoicontohopdacbiet3convs3or4dt[i]) == false) { /*//////System.out.println(""+chuoicontohopdacbiet3convs3or4dt[i])*/;
                countohopdacbiet3convs3dtor4dthople++;
                chuoitohopdacbiet3convs3or4dt[countohopdacbiet3convs3dtor4dthople] = chuoiroot3convs3or4dt + chuoicontohopdacbiet3convs3or4dt[i];

            }

        }

    }

    void ToHopBaConva3or4DoiThong(int i) {
        for (int j = x[i - 1] + 1; j <= n3c3or4dt - k3c3or4dt + i; j++) {
            x[i] = j;
            if (i == k3c3or4dt) {
                Xuatnghiem3Convs3or4DT();
            } else {
                ToHopBaConva3or4DoiThong(i + 1);
            }
        }
    }

    void Xuatnghiem3Convs3or4DT() {
        countchuoicontohopdacbiet3convs3or4dt++;
        chuoicontohopdacbiet3convs3or4dt[countchuoicontohopdacbiet3convs3or4dt] = "";

        for (int i = 1; i <= k3c3or4dt; i++) {

            chuoicontohopdacbiet3convs3or4dt[countchuoicontohopdacbiet3convs3or4dt] += cardDB3c3or4dt[x[i]] + "$";

        }

    }

    public boolean toHopConBaiDBBaConva3DTor4DTCoChuaBaCon(int num, String s) {
        int[] card = new int[16];
        String[] c = s.split("\\$");
        for (int i = 1; i <= num; i++) {
            ////////System.out.print(""+Integer.parseInt(c[i]));
            card[i] = Integer.parseInt(c[i - 1]);
        }

        for (int i = 1; i <= num; i++) {
            if ((lamTronLen((float) card[i + 2] / 4) - lamTronLen((float) card[i + 1] / 4)) == 0
                    && (lamTronLen((float) card[i + 1] / 4) - lamTronLen((float) card[i] / 4)) == 0) {
                return true;
            }
        }
        return false;
    }

    public void xacDinhViTriLaBaiThuaCuaBaDoiThongorBonDoiThong() {
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if ((vitrilabaiLQtoibadoithong[i].equals("3dt") || vitrilabaiLQtoibondoithong[i].equals("4dt"))
                    && vitrilabaiLQtoibacon[i].equals("bc")) {
                vitrilabaithuacua3dt_4dt[i] = "bthua";
                CardBot_ver_end temp = new CardBot_ver_end("baithua", 1, String.valueOf(baiconlaicuatoi[i]) + "$", baiconlaicuatoi[i]);
                cardbot.add(temp);
            }
            if (i <= numbbaiconlaicuatoi - 1 && (vitrilabaiLQtoibadoithong[i].equals("3dt") || vitrilabaiLQtoibondoithong[i].equals("4dt"))
                    && !(vitrilabaiLQtoibadoithong[i + 1].equals("3dt") || vitrilabaiLQtoibondoithong[i + 1].equals("4dt"))) {
                {
                    for (int j = 1; j <= 2; j++) {
                        if (lamTronLen((float) baiconlaicuatoi[i + j] / 4) - lamTronLen((float) baiconlaicuatoi[i] / 4) == j) {
                            if (i + j == numbbaiconlaicuatoi + 1) {
                                break;
                            }
                            vitrilabaithuacua3dt_4dt[i + j] = "baithua";
                            CardBot_ver_end temp = new CardBot_ver_end("baithua", 1,
                                    String.valueOf(baiconlaicuatoi[i + j]) + "$", baiconlaicuatoi[i + j]);
                            cardbot.add(temp);
                        }
                    }
                }

            }
            if (i >= 2 && (vitrilabaiLQtoibadoithong[i].equals("3dt") || vitrilabaiLQtoibondoithong[i].equals("4dt"))
                    && !(vitrilabaiLQtoibadoithong[i - 1].equals("3dt") || vitrilabaiLQtoibondoithong[i - 1].equals("4dt"))) {
                {
                    for (int j = 1; j <= 2; j++) {
                        if (i - j == 0) {
                            break;
                        }
                        if (lamTronLen((float) baiconlaicuatoi[i] / 4) - lamTronLen((float) baiconlaicuatoi[i - j] / 4) == j) {
                            vitrilabaithuacua3dt_4dt[i - j] = "baithua";
                            CardBot_ver_end temp = new CardBot_ver_end("baithua", 1,
                                    String.valueOf(baiconlaicuatoi[i - j]) + "$", baiconlaicuatoi[i - j]);
                            cardbot.add(temp);
                        }
                    }
                }

            }
            if (vitrilabaithuacua3dt_4dt[i] == null) {
                vitrilabaithuacua3dt_4dt[i] = "x";
            }
        }

    }

    public boolean baiCoLucPheBon() {
        if (numbbaiconlaicuatoi != 13) {
            return false;
        }
        int countdoi = 0, count3con = 0;
        for (int i = 1; i <= 13; i++) {
            if (vitrilabaiLQtoidoi[i].equals("d")) {
                countdoi++;
            }
            if (vitrilabaiLQtoibacon[i].equals("bc")) {
                count3con++;
            }
        }
        String templucphebon = "";
        if (countdoi >= 12 && count3con <= 3) {
            for (int i = 1; i <= 13; i++) {
                if (vitrilabaiLQtoidoi[i].equals("d")) {
                    templucphebon += baiconlaicuatoi[i] + "$";
                }
            }
            CardBot_ver_end cb = new CardBot_ver_end("lucphebon", 12, templucphebon, 0);
            cardbot.add(cb);
        }
        for (int i = 0; i < cardbot.size(); i++) {
            if (cardbot.get(i).loaibai.equals("lucphebon")) {
                if (indexactor == 1) {
                    dapantoitrang = cardbot.get(i).daycard;
                } else {
                    dapantoitrang = cardbot.get(i).sola + "$" + cardbot.get(i).loaibai + "$"
                            + cardbot.get(i).daycard;
                }
                return true;
            }
        }
        return false;
    }

    public boolean baiCo3DoiThongChua3Bich() {
        if (numbbaiconlaicuatoi != 13) {
            return false;
        }
        for (int i = 0; i < cardbot.size(); i++) {
            if (cardbot.get(i).loaibai.equals("badoithong")
                    && cardbot.get(i).daycard.charAt(0) == '1' && cardbot.get(i).daycard.charAt(1) == '$') {
                if (indexactor == 1) {
                    dapantoitrang = cardbot.get(i).daycard;
                } else {
                    dapantoitrang = cardbot.get(i).sola + "$" + cardbot.get(i).loaibai + "$"
                            + cardbot.get(i).daycard;
                }
                return true;
            }
        }

        return false;
    }

    public boolean baiCoTuQuy2() {
        if (numbbaiconlaicuatoi != 13) {
            return false;
        }
        int counttuquy = 0;
        for (int i = 0; i < cardbot.size(); i++) {
            if (cardbot.get(i).loaibai.equals("tuquy") && cardbot.get(i).sumsohieu == 202) {
                if (indexactor == 1) {
                    dapantoitrang = cardbot.get(i).daycard;
                } else {
                    dapantoitrang = cardbot.get(i).sola + "$" + cardbot.get(i).loaibai + "$"
                            + cardbot.get(i).daycard;
                }
                return true;
            }
        }
        return false;
    }

    public boolean baiCoTuQuy3() {
        if (numbbaiconlaicuatoi != 13) {
            return false;
        }

        for (int i = 0; i < cardbot.size(); i++) {

            if (cardbot.get(i).loaibai.equals("tuquy") && cardbot.get(i).sumsohieu == 10) {

                if (indexactor == 1) {
                    dapantoitrang = cardbot.get(i).daycard;
                } else {
                    dapantoitrang = cardbot.get(i).sola + "$" + cardbot.get(i).loaibai + "$"
                            + cardbot.get(i).daycard;
                }
                return true;
            }
        }
        return false;
    }

    public boolean baiCoSanhRong() {
        if (numbbaiconlaicuatoi != 13) {
            return false;
        }
        for (int i = 0; i < cardbot.size(); i++) {
            if (cardbot.get(i).loaibai.equals("sanh") && cardbot.get(i).sola == 12) {
                if (indexactor == 1) {
                    dapantoitrang = cardbot.get(i).daycard;
                } else {
                    dapantoitrang = cardbot.get(i).sola + "$" + cardbot.get(i).loaibai + "$"
                            + cardbot.get(i).daycard;
                }
                return true;
            }
        }
        return false;
    }

    public boolean baiCoDongHoa() {
        if (numbbaiconlaicuatoi != 13) {
            return false;
        }
        int countdo = 0, countden = 0;
        String tempdonghoado = "", tempdonghoaden = "";
        for (int i = 1; i <= numbbaiconlaicuatoi; i++) {
            if ((baiconlaicuatoi[i] + 1) % 4 == 0 || (baiconlaicuatoi[i] % 4 == 0)) {
                tempdonghoado += String.valueOf(baiconlaicuatoi[i]) + "$";
                countdo++;
            } else if ((baiconlaicuatoi[i] + 2) % 4 == 0 || (baiconlaicuatoi[i] + 3) % 4 == 0) {
                tempdonghoaden += String.valueOf(baiconlaicuatoi[i]) + "$";
                countden++;
            }
        }
        if (countden >= 12) {
            if (countden == 12) {
                CardBot_ver_end cb = new CardBot_ver_end("donghoaden", 12, tempdonghoaden, 0);
                cardbot.add(cb);
            } else if (countden == 13) {
                CardBot_ver_end cb = new CardBot_ver_end("donghoaden", 13, tempdonghoaden, 0);
                cardbot.add(cb);
            }
            for (int i = 0; i < cardbot.size(); i++) {
                if (cardbot.get(i).loaibai.equals("donghoaden")) {
                    if (indexactor == 1) {
                        dapantoitrang = cardbot.get(i).daycard;
                    } else {
                        dapantoitrang = cardbot.get(i).sola + "$" + cardbot.get(i).loaibai + "$"
                                + cardbot.get(i).daycard;
                    }
                    return true;
                }
            }

            return true;
        }
        if (countdo >= 12) {
            if (countdo == 12) {
                CardBot_ver_end cb = new CardBot_ver_end("donghoado", 12, tempdonghoado, 0);
                cardbot.add(cb);
            } else if (countdo == 13) {
                CardBot_ver_end cb = new CardBot_ver_end("donghoado", 13, tempdonghoado, 0);
                cardbot.add(cb);
            }
            for (int i = 0; i < cardbot.size(); i++) {
                if (cardbot.get(i).loaibai.equals("donghoado")) {
                    if (indexactor == 1) {
                        dapantoitrang = cardbot.get(i).daycard;
                    } else {
                        dapantoitrang = cardbot.get(i).sola + "$" + cardbot.get(i).loaibai + "$"
                                + cardbot.get(i).daycard;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void xayDungDataCacLoaiBoBaiChoBot() {
        xacDinhCacViTri();
        MoRongToHopSanhDoi();

        sapXepGiaTriTheoThuTuTangDanTrongToHopDB(chuoitohopdacbietsanhdoi, countohopdacbietsanhdoihople);
        MoRongToHopBaConvaBahoacBonDoiThong();

        sapXepGiaTriTheoThuTuTangDanTrongToHopDB(chuoitohopdacbiet3convs3or4dt, countohopdacbiet3convs3dtor4dthople);
      
        for (int i = 1; i <= countohopdacbiet3convs3dtor4dthople; i++) {
            timBonDoiThongTuChuoiToHopVaDoDaiChuoiChoTruoc(chuoitohopdacbiet3convs3or4dt[i]);
            timBaDoiThongTuChuoiToHopVaDoDaiChuoiChoTruoc(chuoitohopdacbiet3convs3or4dt[i]);
        }
        xacDinhViTriLaBaiThuaCuaBaDoiThongorBonDoiThong();

        //Tim moi sanh tu cac to hop dac biet
        for (int i = 1; i <= countohopdacbietsanhdoihople; i++) {
            for (int dodaisanh = 3; dodaisanh <= 13; dodaisanh++) {
                timSanhTuChuoiToHopVaDoDaiChuoiChoTruoc(chuoitohopdacbietsanhdoi[i], dodaisanh);
            }
        }
    }
}
