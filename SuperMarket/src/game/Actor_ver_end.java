/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
// chứa dữ liệu các thành phần
public class Actor_ver_end extends JFrame {

    String thongbaokieubairahople;
    public int indexActor;
    String chedochoi;
    int isTurn;
    JLabel winner = new JLabel();
    public int toadoXnutcarddautien, toadoYnutcarddautien;
    public int[] toadoXcard = new int[14];
    public int[] toadoYcard = new int[14];
    public Timer time;
    public int toadoXnutstart, toadoYnutstart;
    public int locationXlabletime, locationYlabletime;
    public int toadoXnutrabai, toadoYnutrabai;
    public int toadoXnutkhongtheo, toadoYnutkhongtheo;
    public int toadoXnhanclock, toadoYnhanclock;
    public int toadoXcardhide, toadoYcardhide;
    public int toadoXbodemthoigian, toadoYbodemthoigian;
    public int locationstartYlabletime;
    public int toadoXavatar, toadoYavatar;
    String tenImageAvatar;
    public String listBaiDuocChia, listBaiConLai, listBaiVuaRa;
    public int toadoXdautiencualabaitrongdanhsachbaivuara,
            toadoYdautiencualabaitrongdanhsachbaivuara;
    public int toadoXtrangthaikhongtheo, toadoYtrangthaikhongtheo;
    public int toadoXnhansolabaiconlai, toadoYnhansolabaiconlai;
    public int toadoXnhanthongbaoditruoc, toadoYnhanthongbaoditruoc;
    public boolean[] isDaDuocChon = new boolean[53];
    public int[] sohieucard = new int[53];
    public int[] vitricard = new int[14];
    JLabel nhanmycard[] = new JLabel[52];
    JButton nutrabai, nuttest, nutkhongtheo = new JButton();
    JLabel nhanclock = new JLabel();
    JLabel cardhide = new JLabel();
    ;
    JLabel[] nhanbaira = new JLabel[14];
    JLabel nhankhongtheo = new JLabel("Bỏ");
    JLabel nhanbaiconlai = new JLabel("Bỏ");
    JLabel nhanrabaian;
    JLabel nhanthongbao3bichditruoc = new JLabel();
    JLabel nhanthongbaobainhoditruoc = new JLabel();
    public int solabaiconlai;
    JLabel avatar = new JLabel();
    int bodem;

    ArrayList danhsachbaivuara = new ArrayList();
    ArrayList<Card_Player_ver_end> mycard = new ArrayList<Card_Player_ver_end>();
    ArrayList<Card_Player_ver_end> baivuachon = new ArrayList<Card_Player_ver_end>();

    public JLabel nhanthoigian = new JLabel();

    public Actor_ver_end() {
    }

    public void setUpHinhAnhLaBaiChuaRa() {

        for (int i = 0; i < mycard.size(); i++) {
            int j = mycard.get(i).vitri;
            int k = mycard.get(i).sohieu;
            nhanmycard[j] = new JLabel();
            String s = String.valueOf(String.valueOf(k)) + ".png";
            String path = "/ima_TLMN/52labaiTLMN/" + s;
            URL url = Actor_ver_end.class.getResource(path);
            ImageIcon icon = new ImageIcon(url);
            // //////System.out.println(path);
            nhanmycard[j].setIcon(icon);
            setLayout(null);
            /*root ẩn bài bot*/

            if (indexActor == 2 || indexActor == 3 || indexActor == 4) {
                if (chedochoi.equals("thucchien")) {
                    nhanmycard[j].setVisible(false);
                }
            }
        }
    }

    public void taoNhanTrangThaiKhongTheo() {
        nhankhongtheo.setFont(new Font("NewellsHand", Font.BOLD, 19));//Kiểu cỡ chữ thời gian
        nhankhongtheo.setForeground(Color.RED);
        nhankhongtheo.setBounds(toadoXtrangthaikhongtheo, toadoYtrangthaikhongtheo, 120, 50);
        nhankhongtheo.setVisible(false);
    }

    public void SapXepDuLieuCacLaBaiTheoSoHieuTangDanKhiDuocChiaBai() {
        String[] temp = listBaiDuocChia.split("\\$");
        //  //System.out.println("index"+indexActor+"sola con lai"+solabaiconlai);
        for (int i = 1; i <= solabaiconlai; i++) {
            sohieucard[i] = Integer.parseInt(temp[i - 1]);
            vitricard[i] = i;
        }
        int tg1 = 0, tg2 = 0;
        for (int i = 1; i < solabaiconlai; i++) {
            for (int j = i + 1; j <= solabaiconlai; j++) {
                if (sohieucard[i] > sohieucard[j]) {
                    tg1 = sohieucard[i];
                    sohieucard[i] = sohieucard[j];
                    sohieucard[j] = tg1;
                }
            }
        }
        for (int i = 1; i <= solabaiconlai; i++) {
            Card_Player_ver_end x = new Card_Player_ver_end(i, sohieucard[i]);
            mycard.add(x);
        }
    }

    public void taoNhanDongHo() {

        URL url = Actor_ver_end.class.getResource("/ima_TLMN/clock.png");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);//cần phải dùng để thay `đổi 
        nhanclock.setIcon(icon);
        nhanclock.setBounds(toadoXnhanclock, toadoYnhanclock, icon.getIconWidth(), icon.getIconHeight());

        nhanclock.setVisible(false);
    }

    public void taoCardHide() {
        URL url = Actor_ver_end.class.getResource("/ima_TLMN/card_hide.png");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);//cần phải dùng để thay `đổi 
        cardhide.setIcon(icon);
        cardhide.setBounds(toadoXcardhide, toadoYcardhide, icon.getIconWidth(), icon.getIconHeight());
    }

    public void taoAvatar() {
        URL url = Actor_ver_end.class.getResource("/ima_TLMN/nhanvat/" + tenImageAvatar + ".png");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);//cần phải dùng để thay `đổi 
        avatar.setIcon(icon);
        avatar.setBounds(toadoXavatar, toadoYavatar, icon.getIconWidth(), icon.getIconHeight());
    }

    public void taoToaDoXYChoCacLaBaiChuaRa() /*đánh dấu nao bỏ*/ {
        int xpadding = 0;
        if (indexActor == 1 || indexActor == 2 || indexActor == 3) {
            for (int i = 0; i < mycard.size(); i++) {
                int j = mycard.get(i).vitri;
                toadoYcard[j] = toadoYnutcarddautien;
                toadoXcard[j] = toadoXnutcarddautien + xpadding;
                xpadding += 23;
                nhanmycard[j].setBounds(toadoXcard[j], toadoYcard[j], 42, 57);
            }
        } else {
            for (int i = mycard.size() - 1; i >= 0; i--) {
                int j = mycard.get(i).vitri;
                toadoYcard[j] = toadoYnutcarddautien;
                toadoXcard[j] = toadoXnutcarddautien + xpadding;
                xpadding -= 23;
                nhanmycard[j].setBounds(toadoXcard[j], toadoYcard[j], 42, 57);
            }
        }

    }

    public void taoNhanWinner() {
        URL url = Actor_ver_end.class.getResource("/ima_TLMN/winner.gif");
        ImageIcon icon = new ImageIcon(url);
        setLayout(null);
        winner.setIcon(icon);
        winner.setBounds(toadoXavatar - 10, toadoYavatar - 100, icon.getIconWidth(), icon.getIconHeight());
        winner.setVisible(false);

    }

    public void setUpHinhAnhRaBai() {
        int xpadding = 0;
        if (indexActor == 1 || indexActor == 2) {
            for (int i = 0; i < baivuachon.size(); i++) {
                int j = baivuachon.get(i).sohieu;
                int k = baivuachon.get(i).vitri;
                nhanbaira[k] = new JLabel();

                String path = "/ima_TLMN/52labaiTLMN/" + String.valueOf(j) + ".png";
                URL url = Actor_ver_end.class.getResource(path);
                ImageIcon icon = new ImageIcon(url);

                setLayout(null);//cần phải dùng để thay `đổi 
                nhanbaira[k].setIcon(icon);
                nhanbaira[k].setBounds(toadoXdautiencualabaitrongdanhsachbaivuara + xpadding,
                        toadoYdautiencualabaitrongdanhsachbaivuara, 42, 57);
                xpadding += 30;
                nhanbaira[k].setVisible(false);
            }
        } else {
            for (int i = baivuachon.size() - 1; i >= 0; i--) {
                int j = baivuachon.get(i).sohieu;
                int k = baivuachon.get(i).vitri;

                nhanbaira[k] = new JLabel();

                String path = "/ima_TLMN/52labaiTLMN/" + String.valueOf(j) + ".png";
                URL url = Actor_ver_end.class.getResource(path);
                ImageIcon icon = new ImageIcon(url);
                setLayout(null);//cần phải dùng để thay `đổi 
                nhanbaira[k].setIcon(icon);
                nhanbaira[k].setBounds(toadoXdautiencualabaitrongdanhsachbaivuara + xpadding,
                        toadoYdautiencualabaitrongdanhsachbaivuara, 42, 57);
                xpadding -= 30;
                nhanbaira[k].setVisible(false);
            }
        }
    }

    public void taoNhanThoiGian() {
        nhanthoigian.setText("" + 30);
        nhanthoigian.setFont(new Font("Arial", Font.BOLD, 20));//Kiểu cỡ chữ thời gian
        nhanthoigian.setForeground(Color.darkGray);
        nhanthoigian.setBounds(toadoXbodemthoigian, toadoYbodemthoigian, 120, 20);
        nhanthoigian.setVisible(false);
    }

    public void taoNhanSoLuongLaConLai() {
        nhanbaiconlai.setText("" + solabaiconlai);
        nhanbaiconlai.setFont(new Font("Arial", Font.BOLD, 25));//Kiểu cỡ chữ thời gian
        nhanbaiconlai.setForeground(Color.PINK);
        nhanbaiconlai.setBounds(toadoXnhansolabaiconlai, toadoYnhansolabaiconlai, 120, 20);
    }

    public void taoNhanThongBao3BichDiTruoc() {
        ImageIcon icon = null;
        if (indexActor == 2 || indexActor == 3) {
            URL url = Actor_ver_end.class.getResource("/ima_TLMN/thongbao3bich1.png");
            icon = new ImageIcon(url);
        } else if (indexActor == 1 || indexActor == 4) {
            URL url = Actor_ver_end.class.getResource("/ima_TLMN/thongbao3bich2.png");
            icon = new ImageIcon(url);
        }
        setLayout(null);
        nhanthongbao3bichditruoc.setIcon(icon);
        nhanthongbao3bichditruoc.setBounds(toadoXnhanthongbaoditruoc,
                toadoYnhanthongbaoditruoc, icon.getIconWidth(), icon.getIconHeight());
        nhanthongbao3bichditruoc.setVisible(false);
    }

    public void taoNhanThongBaoBaiNhoDiTruoc() {
        ImageIcon icon = null;
        if (indexActor == 2 || indexActor == 3) {
            URL url = Actor_ver_end.class.getResource("/ima_TLMN/thongbaobainhoditruoc1.png");
            icon = new ImageIcon(url);
        } else if (indexActor == 1 || indexActor == 4) {
            icon = new ImageIcon(getClass().getResource("/ima_TLMN/thongbaobainhoditruoc2.png"));
        }
        setLayout(null);
        nhanthongbaobainhoditruoc.setIcon(icon);
        nhanthongbaobainhoditruoc.setBounds(toadoXnhanthongbaoditruoc,
                toadoYnhanthongbaoditruoc, icon.getIconWidth(), icon.getIconHeight());
        nhanthongbaobainhoditruoc.setVisible(false);
    }
}
