/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Player_ver_end extends Actor_ver_end {

    String KQ_PlayerTranning;
    boolean playerChonSaiBai;
    String strbaivuachon, bainhonhat;
    boolean toitrang;
    boolean isKetThuc;
    String baitoitrang;
    boolean isTurnPlayer;
    JLabel nhannewgame = new JLabel();
    JLabel nhanbackhome = new JLabel();
    JLabel nhansoundon = new JLabel();
    JLabel nhansoundoff = new JLabel();
    JLabel nhanquestion = new JLabel();
    GT_TLMN_PhanNhomBai_ver_end checknutrabaigetdata;
    GT_TLMN_BOT_TinhToan_va_RaQuyetDinh_ver_end checknutrabaitimdapan;
    int soPlayerBiKhoa, SONGUOICHOI;
    ArrayList<Card_Player_ver_end> theyCard = new ArrayList<Card_Player_ver_end>();
    ArrayList<Card_Player_ver_end> baiplayervuachon = new ArrayList<Card_Player_ver_end>();

    public Player_ver_end(int indexActor, String listBaiDuocChia, int xclock, int yclock,
            int xtime, int ytime, int x_nhan_ktheo, int y_nhan_ktheo, int xcardhide,
            int ycardhide, int xbaira, int ybaira, int xcarddau, int ycarddau, int xrabai,
            int yrabai, int xktheo, int yktheo, int x_avatar, int y_avatar, String tenImageAvatar,
            int solabaiconlai, int toadoX3bich, int toadoY3bich) {
        this.toadoXnhanthongbaoditruoc = toadoX3bich;
        this.toadoYnhanthongbaoditruoc = toadoY3bich;
        this.solabaiconlai = solabaiconlai;
        this.indexActor = indexActor;
        this.listBaiDuocChia = listBaiDuocChia;
        this.toadoXavatar = x_avatar;
        this.toadoYavatar = y_avatar;
        //nhãn
        this.tenImageAvatar = tenImageAvatar;
        this.toadoXnhanclock = xclock;//400
        this.toadoYnhanclock = yclock;//530
        this.toadoXbodemthoigian = xtime;//416
        this.toadoYbodemthoigian = ytime;//545
        this.toadoXtrangthaikhongtheo = x_nhan_ktheo;//550
        this.toadoYtrangthaikhongtheo = y_nhan_ktheo;//540
        this.toadoXcardhide = xcardhide;//550
        this.toadoYcardhide = ycardhide;//630
        this.toadoXdautiencualabaitrongdanhsachbaivuara = xbaira;//400
        this.toadoYdautiencualabaitrongdanhsachbaivuara = ybaira;//530

        //nút
        this.toadoXnutcarddautien = xcarddau;//330
        this.toadoYnutcarddautien = ycarddau;//630
        this.toadoXnutrabai = xrabai;
        this.toadoYnutrabai = yrabai;
        this.toadoXnutkhongtheo = xktheo;
        this.toadoYnutkhongtheo = yktheo;
        System.out.println("cbnn.phanbai" + indexActor + "= " + (char) 34 + listBaiDuocChia + (char) 34 + ";");
        setUpCacOptionPlayer();
    }

    public void batOptionPlayer() {
        for (int i = 0; i < baivuachon.size(); i++) {
            int j = baivuachon.get(i).vitri;
            nhanbaira[j].setVisible(false);
        }
        bodem = 20;
        nhanthoigian.setText("" + 20);
        baivuachon.removeAll(baivuachon);
        nutkhongtheo.setVisible(false);
        nhanclock.setVisible(true);
        nhanthoigian.setVisible(true);
    }

    public void tatOptionPlayer() {
        nhanrabaian.setVisible(false);
        nutkhongtheo.setVisible(false);
        nutrabai.setVisible(false);
        nhanthoigian.setVisible(false);
        nhanclock.setVisible(false);

    }

    public void setUpCacOptionPlayer() {
        taoNhanWinner();
        taoNhanQuestion();
        taoNhanSoundOn();
        taoNhanNewGame();
        taoNhanBackHome();
        taoAvatar();
        taoNhanThoiGian();
        taoNhanThongBao3BichDiTruoc();
        //nhanthoigian.setVisible(false);
        taoNhanDongHo();
        taoNhanSoundOff();
        //nhanclock.setVisible(false);
        taoNhanTrangThaiKhongTheo();
        taoNhanThongBaoBaiNhoDiTruoc();
        //nhankhongtheo.setVisible(false);
        taoCardHide();
        cardhide.setVisible(false);
        taoNutKhongTheo();
        taoNhanRaBaiAn();
        taoNutRaBai();
        nutrabai.setVisible(false);
        SapXepDuLieuCacLaBaiTheoSoHieuTangDanKhiDuocChiaBai();

        setUpHinhAnhLaBaiChuaRa();
        taoToaDoXYChoCacLaBaiChuaRa();
        for (int i = 0; i < mycard.size(); i++) {
        }
    }

    public void taoNutRaBai() {

        setLayout(null);//cần phải dùng để thay đổi vị trí
        URL url = Player_ver_end.class.getResource("/ima_TLMN/rabai.png");
        ImageIcon icon = new ImageIcon(url);
        nutrabai = new JButton();
        nutrabai.setIcon(icon);
        nutrabai.setBounds(toadoXnutrabai, toadoYnutrabai, icon.getIconWidth(), icon.getIconHeight());

    }

    public void taoNhanRaBaiAn() {

        setLayout(null);//cần phải dùng để thay đổi vị trí
        URL url = Player_ver_end.class.getResource("/ima_TLMN/rabaian.png");
        ImageIcon icon = new ImageIcon(url);
        nhanrabaian = new JLabel();
        nhanrabaian.setIcon(icon);
        nhanrabaian.setBounds(toadoXnutrabai, toadoYnutrabai, icon.getIconWidth(), icon.getIconHeight());
        nhanrabaian.setVisible(false);
    }

    public void taoNutKhongTheo() {

        setLayout(null);//cần phải dùng để thay đổi vị trí
        URL url = Player_ver_end.class.getResource("/ima_TLMN/khongtheo.png");
        ImageIcon icon = new ImageIcon(url);
        nutkhongtheo = new JButton();
        nutkhongtheo.setIcon(icon);
        nutkhongtheo.setBounds(toadoXnutkhongtheo, toadoYnutkhongtheo, icon.getIconWidth(), icon.getIconHeight());
        nhankhongtheo.setVisible(false);
    }

    public void nhapLaBaiDuocChonLenHoacXuong(int i) {
        if (isKetThuc == true) {
            return;
        }
        baiplayervuachon.removeAll(baiplayervuachon);

        if (isDaDuocChon[i] == false) {
            nhanmycard[i].setBounds(toadoXcard[i], toadoYcard[i] - 42, 42, 57);

            isDaDuocChon[i] = true;

        } else if (isDaDuocChon[i] == true) {

            nhanmycard[i].setBounds(toadoXcard[i], toadoYcard[i], 42, 57);
            isDaDuocChon[i] = false;

        }
        for (int a = 0; a < mycard.size(); a++) {
            int j = mycard.get(a).vitri;
            int k = mycard.get(a).sohieu;

            if (isDaDuocChon[j] == true) {
                Card_Player_ver_end tempbaivuachon = new Card_Player_ver_end(j, k);
                baiplayervuachon.add(tempbaivuachon);
            } else {
                for (int b = 0; b < baiplayervuachon.size(); b++) {
                    if (j == baiplayervuachon.get(b).vitri) {
                        baiplayervuachon.remove(b);
                    }
                }
            }
        }
        String strbaivuachon = "";

        for (int t = 0; t < baiplayervuachon.size(); t++) {
            strbaivuachon += String.valueOf(baiplayervuachon.get(t).sohieu) + "$";
        }

        checknutrabaigetdata = new GT_TLMN_PhanNhomBai_ver_end(mycard);
        checknutrabaigetdata.xayDungDataCacLoaiBoBaiChoBot();
        GT_TLMN_Player_ver_end gtplayer = new GT_TLMN_Player_ver_end(theyCard, baiplayervuachon,
                 checknutrabaigetdata.cardbot);
        String temp = gtplayer.nhanThongBaoTinhHopLeBaiDaChonCuaToi();

        nutrabai.setVisible(true);
        if (temp.equals("khonghople")) {
            nutrabai.setVisible(false);
        }
        if (mycard.size() == 13 && gtplayer.baiChonChuaBaiNhoNhat(bainhonhat) == false
                && gtplayer.boBaiChuaBaiNhoNhat(bainhonhat) == true) {
            nutrabai.setVisible(false);
        }
        if (theyCard.size() != 0) {
            if (gtplayer.chanDuocBaiBot() == false) {
                nutrabai.setVisible(false);
            }
        }

    }

    public void xuLyRaBai(Player_ver_end player) {
        strbaivuachon = "";
        playerChonSaiBai = false;
        baivuachon.removeAll(baivuachon);
        int count = 0;
        ;
        if (baitoitrang != null) {
            String c[] = baitoitrang.split("\\$");

            for (int i = 0; i < baitoitrang.length(); i++) {
                if (baitoitrang.charAt(i) == '$') {
                    count++;
                }
            }
            for (int i = 0; i < mycard.size(); i++) {
                int j = mycard.get(i).vitri;
                int k = mycard.get(i).sohieu;

                for (int t = 0; t < count; t++) {
                    if (k == Integer.parseInt(c[t])) {
                        Card_Player_ver_end tempbaivuachon = new Card_Player_ver_end(j, k);
                        baivuachon.add(tempbaivuachon);
                    }
                }

            }
        }

        for (int i = 0; i < mycard.size(); i++) {
            int j = mycard.get(i).vitri;
            int k = mycard.get(i).sohieu;

            if (isDaDuocChon[j] == true) {
                strbaivuachon += String.valueOf(k) + "$";
                Card_Player_ver_end tempbaivuachon = new Card_Player_ver_end(j, k);
                baivuachon.add(tempbaivuachon);
            }
        }

        //System.out.println("size"+baivuachon.size());
        {
            GT_TLMN_PhanNhomBai_ver_end gttest = new GT_TLMN_PhanNhomBai_ver_end(mycard);
            gttest.xayDungDataCacLoaiBoBaiChoBot();
            for (int i = 0; i < gttest.cardbot.size(); i++) {
                if (strbaivuachon.equals(gttest.cardbot.get(i).daycard)) {
                    if (gttest.cardbot.get(i).loaibai.equals("sanh")) {
                        KQ_PlayerTranning = "sanh" + "$" + gttest.cardbot.get(i).sola;
                    } else {
                        KQ_PlayerTranning = gttest.cardbot.get(i).loaibai;

                    }
                }

            }
            if (theyCard.size() == 0) {

                NaiveBayes_player_tranningData_ditruoc_ver_end ml_naivebays_pl
                        = new NaiveBayes_player_tranningData_ditruoc_ver_end(player);
                //turn on tranning
                try {
                    ml_naivebays_pl.run();
                } catch (IOException ex) {
                }
            }

            /*Xóa dữ liệu vị trí và số hiệu bài vừa ra khỏi danh sách mycard, ẩn vị trí bài đã ra
      khỏi danh sách bài còn lại*/
            for (int i = 0; i < mycard.size(); i++) {
                for (int j = 0; j < baivuachon.size(); j++) {
                    int v = baivuachon.get(j).vitri;
                    nhanmycard[v].setVisible(false);
                    if (mycard.get(i).vitri == baivuachon.get(j).vitri) {
                        mycard.remove(i);
                    }
                }
            }

            /* for(int i=0;i<player.mycard.size();i++)
            {
                //////////////System.out.print("-"+player.mycard.get(i).sohieu);
            }*/
            //thu xếp (đặt lại vị trí)những lá bài còn lại chưa ra
            taoToaDoXYChoCacLaBaiChuaRa();
            //khoaLuotActor[2]=true;
            //tắt option player để chỗ trống cho vị trí lá bài ra
            tatOptionPlayer();

            //setup hình ảrnh những lá bài ra và thêm nó lên màn hình
            setUpHinhAnhRaBai();
            solabaiconlai -= baivuachon.size();

        }

    }

    public void taoNhanNewGame() {
        URL url = Player_ver_end.class.getResource("/ima_TLMN/newgame.png");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);
        nhannewgame.setIcon(icon);
        nhannewgame.setBounds(80, 20, icon.getIconWidth(), icon.getIconHeight());
    }

    public void taoNhanBackHome() {
        URL url = Player_ver_end.class.getResource("/ima_TLMN/backhome.png");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);
        nhanbackhome.setIcon(icon);
        nhanbackhome.setBounds(20, 20, icon.getIconWidth(), icon.getIconHeight());
    }

    public void taoNhanSoundOn() {
        URL url = Player_ver_end.class.getResource("/ima_TLMN/sound_on.png");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);
        nhansoundon.setIcon(icon);
        nhansoundon.setBounds(140, 20, icon.getIconWidth(), icon.getIconHeight());
    }

    public void taoNhanSoundOff() {
        URL url = Player_ver_end.class.getResource("/ima_TLMN/sound_off.png");
        ImageIcon icon = new ImageIcon(url);

        nhansoundoff.setIcon(icon);
        nhansoundoff.setBounds(140, 20, icon.getIconWidth(), icon.getIconHeight());
    }

    public void taoNhanQuestion() {
        URL url = Player_ver_end.class.getResource("/ima_TLMN/hoi.png");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);
        nhanquestion.setIcon(icon);
        nhanquestion.setBounds(200, 20, icon.getIconWidth(), icon.getIconHeight());
    }

    public MouseAdapter mouseAdapterPlayerChonBai = new MouseAdapter() {

//Tạo sự kiện dãy các thẻ bài button
        @Override
        public void mousePressed(MouseEvent e) {

            for (int i = 0; i < mycard.size(); i++) {
                int j = mycard.get(i).vitri;
                if (e.getSource() == nhanmycard[j]) {
                    if (isTurnPlayer == true) {
                        nhapLaBaiDuocChonLenHoacXuong(j);
                    }

                }
            }

        }
    };

//Tạo sự kiện dãy các thẻ bài button
}
