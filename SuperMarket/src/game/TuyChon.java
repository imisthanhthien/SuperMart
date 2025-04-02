package game;

import static game.AmThanh.chaynhac;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javazoom.jl.player.Player;

public class TuyChon extends JFrame {

    JLabel nhanoktab1 = new JLabel();
    JLabel nhanoktab2 = new JLabel();
    JLabel nhanoktab3 = new JLabel();

    int indexgreen;
    JPanel jp3 = new JPanel();
    JLabel[] avtnv = new JLabel[31];
    JLabel[] tickgreen = new JLabel[31];

    JRadioButton cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    ConnectDataBaseTLMN_NetBeans kn = new ConnectDataBaseTLMN_NetBeans();
    Connection cn = kn.getConnectdatabase();
    Statement stm = cn.createStatement();
    JLabel nhantestnow = new JLabel();
    JComboBox jcb;
    String nhactest;
    boolean nhac_on;
    int indexnhactemp;

    public TuyChon() throws SQLException {
        setTitle("GAME ĐÁNH BÀI TIẾN LÊN (phiên bản liên minh huyền thoại)");
        setBounds(50, 0, 650, 500);
        setLocation(300, 0);
        setVisible(false);
        setResizable(false);
        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("CHỌN AVATAR", caiDatNhanVat());
        jtp.addTab("TÙY CHỈNH GAME", tuyChinhGame());
        jtp.addTab("TÙY CHỈNH NHẠC", caiDatAmThanh());

        getContentPane().add(jtp);
        //getContentPane().setVisible(false);
        // jtp.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel caiDatNhanVat() throws SQLException {
        ResultSet rs = stm.executeQuery("SELECT AVATAR FROM TABLETLMNTUYCHON");
        while (rs.next()) {
            indexgreen = rs.getInt(1);
        }
        System.out.println("--" + indexgreen);

        for (int i = 1; i <= 30; i++) {
            avtnv[i] = new JLabel();
            tickgreen[i] = new JLabel();
        }
        JPanel panel = new JPanel();

        panel.setBackground(new Color(213, 234, 255));

        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 80;
        gbc.gridx = 2;
        gbc.gridy = 0;

        JLabel abc = new JLabel("");

        abc.setForeground(Color.red);

        panel.add(abc, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.ipady = 20;
        gbc.ipadx = 18;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(tickgreen[1], gbc);
        panel.add(NhanNV(1), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(tickgreen[2], gbc);
        panel.add(NhanNV(2), gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(tickgreen[3], gbc);
        panel.add(NhanNV(3), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(tickgreen[4], gbc);
        panel.add(NhanNV(4), gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(tickgreen[5], gbc);
        panel.add(NhanNV(5), gbc);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(tickgreen[6], gbc);
        panel.add(NhanNV(6), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(tickgreen[7], gbc);
        panel.add(NhanNV(7), gbc);
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(tickgreen[8], gbc);
        panel.add(NhanNV(8), gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(tickgreen[9], gbc);
        panel.add(NhanNV(9), gbc);

        tickgreen[indexgreen].setVisible(true);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(taoNutOK(), gbc);
        add(panel);
        return panel;

    }

    public JLabel NhanNV(int i) {

        ImageIcon Iconavt = new ImageIcon(getClass().getResource("/ima_TLMN/nhanvat/" + String.valueOf(i) + ".png"));
        ImageIcon Icontickgreen = new ImageIcon(getClass().getResource("/ima_TLMN/tickgreen.png"));
        avtnv[i].setIcon(Iconavt);
        avtnv[i].addMouseListener(mouseAdapterUserClickTab1);
        tickgreen[i].setIcon(Icontickgreen);
        tickgreen[i].setVisible(false);
        return avtnv[i];
    }

    public JLabel taoNutOK() {

        ImageIcon Iconplay = new ImageIcon(getClass().getResource("/ima_TLMN/ok1.png"));
        nhanoktab1.setIcon(Iconplay);
        nhanoktab1.setBounds(200, 200, Iconplay.getIconWidth(), Iconplay.getIconHeight());

        add(nhanoktab1);
        nhanoktab1.addMouseListener(mouseAdapterUserClickTab1);
        return nhanoktab1;
    }

    public MouseAdapter mouseAdapterUserClickTab1 = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == nhanoktab1) {
                if (nhac_on == true) {
                    chaynhac.stop();
                    nhac_on = false;
                }
                tickgreen[indexgreen].setVisible(true);
                Menu_Main m = new Menu_Main();
                setVisible(false);
                m.setVisible(true);
                try {
                    SetOKCheDoChoi();
                } catch (SQLException ex) {
                    Logger.getLogger(TuyChon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (int i = 1; i <= 9; i++) {
                if (e.getSource() == avtnv[i]) {
                    setLayout(null);
                    tickgreen[indexgreen].setVisible(false);
                    indexgreen = i;
                    tickgreen[i].setVisible(true);

                    String temp = "UPDATE TABLETLMNTUYCHON SET avatar = " + i + "";
                    try {
                        stm.executeUpdate(temp);
                    } catch (SQLException ex) {
                        //System.out.println(ex);
                    }

                }
            }
        }

    };
    JButton nuttang, nutgiam;
    JLabel textthoigiantre;

    public JPanel tuyChinhGame() throws SQLException {
        Font font = new Font("Segoe UI", Font.BOLD, 16);
          ImageIcon Icontickgreen = new ImageIcon(getClass().getResource("/ima_TLMN/tickgreen.png"));
        JLabel text1, text2, text3;
        JPanel panel = new JPanel();
        panel.setBackground(new Color(213, 234, 255));
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 80;
        gbc.gridx = 1;
        gbc.gridy = 6;
        text1 = new JLabel("CHỌN CHIỀU CỦA LƯỢT");
        text1.setForeground(Color.blue);
        text1.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(text1, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 1;
        gbc.gridy = 7;
        cb1 = new JRadioButton("CÙNG KIM ĐỒNG HỒ");
        
        panel.add(cb1, gbc);
        cb1.setFont(font);
        cb1.setBackground(new Color(213, 234, 255));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 2;
        gbc.gridy = 7;
        cb2 = new JRadioButton("NGƯỢC KIM ĐỒNG HỒ");
        panel.add(cb2, gbc);
        cb2.setFont(font);
        cb2.setBackground(new Color(213, 234, 255));
        ButtonGroup bg = new ButtonGroup();

        bg.add(cb1);
        bg.add(cb2);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 1;
        gbc.gridy = 2;

        text2 = new JLabel("CHỌN SỐ LƯỢNG MÁY");
        text2.setForeground(Color.blue);
        text2.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(text2, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 40;
        gbc.gridx = 1;
        gbc.gridy = 3;
        cb3 = new JRadioButton("1 MÁY");
        panel.add(cb3, gbc);
        cb3.setFont(font);
        cb3.setBackground(new Color(213, 234, 255));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 40;
        gbc.gridx = 2;
        gbc.gridy = 3;
        cb4 = new JRadioButton("2 MÁY");
        cb4.setFont(font);

        panel.add(cb4, gbc);
        cb4.setBackground(new Color(213, 234, 255));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 40;
        gbc.gridx = 3;
        gbc.gridy = 3;
        cb5 = new JRadioButton("3 MÁY");
        panel.add(cb5, gbc);
        cb5.setFont(font);
        cb5.setBackground(new Color(213, 234, 255));
        ButtonGroup slmay = new ButtonGroup();
        slmay.add(cb3);
        slmay.add(cb4);
        slmay.add(cb5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 1;
        gbc.gridy = 4;
        text3 = new JLabel("CHỌN CHẾ ĐỘ CHƠI");
        text3.setForeground(Color.blue);
        text3.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(text3, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 1;
        gbc.gridy = 5;
        cb6 = new JRadioButton("CHƠI TẬP LUYỆN");
        panel.add(cb6, gbc);
        cb6.setFont(font);
        cb6.setBackground(new Color(213, 234, 255));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 2;
        gbc.gridy = 5;
        cb7 = new JRadioButton("CHƠI BÌNH THƯỜNG");
        panel.add(cb7, gbc);
        cb7.setFont(font);
        cb7.setBackground(new Color(213, 234, 255));
        ButtonGroup chedochoi = new ButtonGroup();
        chedochoi.add(cb6);
        chedochoi.add(cb7);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 1;
        gbc.gridy = 0;
        ResultSet rs = null;
        try {
            rs = stm.executeQuery("SELECT thoigiantremayrabai FROM TABLETLMNTUYCHON");
            while (rs.next()) {
                thoigiantre = rs.getInt(1);
                //System.out.println("chieu: "+temp);
            }
        } catch (SQLException ex) {
        }
        textthoigiantre = new JLabel("Thời gian trễ máy ra bài (rcm 2s): " + thoigiantre + " giây");
        textthoigiantre.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(textthoigiantre, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        nuttang = new JButton("TĂNG ");
        // nuttang.addMouseListener(mouseAdapterUserClickTangGiam);
        panel.add(nuttang);
        nuttang.addMouseListener(mouseAdapterUserClickTangGiam);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        nutgiam = new JButton("GIẢM ");
        panel.add(nutgiam);
        nutgiam.addMouseListener(mouseAdapterUserClickTangGiam);
        // nuttang.addMouseListener(mouseAdapterUserClickTangGiam);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 50;
        gbc.gridx = 1;
        gbc.gridy = 8;
        try {
            panel.add(taoNutOKTab2(), gbc);
        } catch (SQLException ex) {
            //System.out.println(ex);
        }
        add(panel);
        String temp = "";
        try {
            rs = stm.executeQuery("SELECT chieucualuot FROM TABLETLMNTUYCHON");

        } catch (SQLException ex) {
            //System.out.println(ex);
        }
        try {
            while (rs.next()) {
                temp = rs.getString(1).trim();
                //System.out.println("chieu: "+temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TuyChon.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (temp.equals("cungchieu")) {
            cb1.setSelected(true);
        } else {
            cb2.setSelected(true);
        }
        rs = stm.executeQuery("SELECT soluongmay FROM TABLETLMNTUYCHON");
        while (rs.next()) {
            temp = rs.getString(1).trim();
            //System.out.println("chieu: "+temp);
        }
        if (temp.equals("1")) {
            cb3.setSelected(true);
        } else if (temp.equals("2")) {
            cb4.setSelected(true);
        } else if (temp.equals("3")) {
            cb5.setSelected(true);
        }
        rs = stm.executeQuery("SELECT chedochoi FROM TABLETLMNTUYCHON");
        while (rs.next()) {
            temp = rs.getString(1).trim();
            //System.out.println("chieu: "+temp);

        }
        if (temp.equals("tapluyen")) {
            cb6.setSelected(true);
        } else if (temp.equals("thucchien")) {
            cb7.setSelected(true);
        }
        return panel;

    }
    int thoigiantre;
    public MouseAdapter mouseAdapterUserClickTangGiam = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            ResultSet rs = null;
            int temp = 0;
            if (e.getSource() == nuttang) {
                if (thoigiantre + 1 > 10) {
                    return;
                }
                thoigiantre++;
                textthoigiantre.setText("Thời gian trễ máy ra bài (rcm 2s): " + thoigiantre + " giây");
                try {
                    stm.executeUpdate("UPDATE TABLETLMNTUYCHON SET thoigiantremayrabai = " + (thoigiantre) + "");

                } catch (SQLException ex) {
                    Logger.getLogger(TuyChon.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (e.getSource() == nutgiam) {
                if (thoigiantre - 1 < 1) {
                    return;
                }
                thoigiantre--;
                textthoigiantre.setText("Thời gian trễ máy ra bài (rcm 2s): " + thoigiantre + " giây");
                try {
                    stm.executeUpdate("UPDATE TABLETLMNTUYCHON SET thoigiantremayrabai = " + (thoigiantre) + "");

                } catch (SQLException ex) {
                    Logger.getLogger(TuyChon.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    };

    public JLabel taoNutOKTab2() throws SQLException {
        ImageIcon Iconplay = new ImageIcon(getClass().getResource("/ima_TLMN/ok.png"));
        nhanoktab2.setIcon(Iconplay);

        nhanoktab2.addMouseListener(mouseAdapterUserClickTab2);
        return nhanoktab2;
    }
    public MouseAdapter mouseAdapterUserClickTab2 = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == nhanoktab2) {
                try {
                    SetOKCheDoChoi();
                    setOKSound();
                } catch (SQLException ex) {
                }
                if (nhac_on == true) {
                    chaynhac.stop();
                    nhac_on = false;
                }

                Menu_Main m = new Menu_Main();
                setVisible(false);
                m.setVisible(true);

            }

        }

    };

    public void SetOKCheDoChoi() throws SQLException {

        if (cb1.isSelected()) {
            String temp = "UPDATE TABLETLMNTUYCHON SET chieucualuot = 'cungchieu'";
            try {
                stm.executeUpdate(temp);
            } catch (SQLException ex) {
                Logger.getLogger(TuyChon.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("update chieu: "+temp);
            //System.out.println("update chieu: "+temp);
        } else if (cb2.isSelected()) {
            String temp = "UPDATE TABLETLMNTUYCHON SET chieucualuot = 'nguocchieu'";
            try {
                stm.executeUpdate(temp);
            } catch (SQLException ex) {
                Logger.getLogger(TuyChon.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("update chieu: "+temp);
            //System.out.println("update chieu: "+temp);

        }
        if (cb3.isSelected()) {

            String temp = "UPDATE TABLETLMNTUYCHON SET soluongmay = '1'";
            stm.executeUpdate(temp);
        } else if (cb4.isSelected()) {
            String temp = "UPDATE TABLETLMNTUYCHON SET soluongmay = '2'";
            stm.executeUpdate(temp);
        } else if (cb5.isSelected()) {
            String temp = "UPDATE TABLETLMNTUYCHON SET soluongmay = '3'";
            stm.executeUpdate(temp);
        }
        if (cb6.isSelected()) {
            String temp = "UPDATE TABLETLMNTUYCHON SET chedochoi = 'tapluyen'";
            stm.executeUpdate(temp);
        } else if (cb7.isSelected()) {
            String temp = "UPDATE TABLETLMNTUYCHON SET chedochoi= 'thucchien'";
            stm.executeUpdate(temp);
            //System.out.println("update SL may "+temp);
        }
    }

    public void setOKSound() throws SQLException {
        switch (jcb.getSelectedIndex()) {
            case 0:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac= 'BLACKPINK'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 1:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'Độ Tộc 2'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 2:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'Hãy Trao Cho Anh '";
                    stm.executeUpdate(temp);
                    break;
                }
            case 3:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'Khuê Mộc Lang'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 4:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'Truyền Thái Y'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 5:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'Waiting For You'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 6:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'sauhonggai'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 7:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'MakingMyWay'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 8:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'TrueDamage'";
                    stm.executeUpdate(temp);
                    break;
                }
            case 9:
                {
                    String temp = "UPDATE TABLETLMNTUYCHON SET nhac = 'Enemy'";
                    stm.executeUpdate(temp);
                    break;
                }
            default:
                break;
        }
    }

    public JPanel caiDatAmThanh() {
        try {
            ImageIcon Iconplay = new ImageIcon(getClass().getResource("/ima_TLMN/nenmucsic.png"));
            JLabel text = new JLabel("CHỌN NHẠC NỀN TRONG GAME");
            JLabel textIMGE = new JLabel();

            text.setFont(new Font("Arial", Font.BOLD, 20));
            text.setBounds(200, 50, 500, 30);

            jp3.add(text);
            jcb = new JComboBox();
            jcb.addItem("BLACKPINK");
            jcb.addItem("Độ Tộc 2");
            jcb.addItem("Hãy Trao Cho Anh ");
            jcb.addItem("Khuê Mộc Lang");
            jcb.addItem("Truyền Thái Y");
            jcb.addItem("Waiting For You");
            jcb.addItem("sauhonggai");
            jcb.addItem("MakingMyWay");
            jcb.addItem("TrueDamage");
            jcb.addItem("Enemy");
            ResultSet rs = null;
            rs = stm.executeQuery("SELECT nhac FROM TABLETLMNTUYCHON");
            String temp = "";
            while (rs.next()) {
                temp = rs.getString(1).trim();

            }
            switch (temp) {
                case "BLACKPINK":
                    jcb.setSelectedIndex(0);
                    break;
                case "Độ Tộc 2":
                    jcb.setSelectedIndex(1);
                    break;
                case "Hãy Trao Cho Anh ":
                    jcb.setSelectedIndex(2);
                    break;
                case "Khuê Mộc Lang":
                    jcb.setSelectedIndex(3);
                    break;
                case "Truyền Thái Y":
                    jcb.setSelectedIndex(4);
                    break;
                case "Waiting For You":
                    jcb.setSelectedIndex(5);
                    break;
                case "sauhonggai":
                    jcb.setSelectedIndex(6);
                    break;
                case "MakingMyWay":
                    jcb.setSelectedIndex(7);
                    break;
                case "TrueDamage":
                    jcb.setSelectedIndex(8);
                    break;
                case "Enemy":
                    jcb.setSelectedIndex(9);
                    break;
                default:
                    break;
            }
            jcb.setBounds(200, 150, 120, 30);
            jp3.add(jcb);
            jp3.add(taoNutTestNow());
            jp3.add(taoNutOKTab3());

            textIMGE.setIcon(Iconplay);
            jp3.add(textIMGE);
            add(jp3);
            return jp3;

        } catch (SQLException ex) {
            Logger.getLogger(TuyChon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public JLabel taoNutTestNow() {

        ImageIcon Iconplay = new ImageIcon(getClass().getResource("/ima_TLMN/testsound.png"));
        nhantestnow.setIcon(Iconplay);
        nhantestnow.setBounds(200, 250, Iconplay.getIconWidth(), Iconplay.getIconHeight());

        nhantestnow.addMouseListener(mouseAdapterUserClickTab3);
        return nhantestnow;
    }

    public JLabel taoNutOKTab3() {
        ImageIcon Iconplay = new ImageIcon(getClass().getResource("/ima_TLMN/ok.png"));
        nhanoktab3.setIcon(Iconplay);
        nhanoktab3.setBounds(250, 250, Iconplay.getIconWidth(), Iconplay.getIconHeight());
        nhanoktab3.addMouseListener(mouseAdapterUserClickTab3);
        return nhanoktab3;
    }

    public void ganNhac() {
        switch (jcb.getSelectedIndex()) {
            case 0:
                nhactest = "BLACKPINK";
                break;
            case 1:
                nhactest = "Độ Tộc 2";
                break;
            case 2:
                nhactest = "Hãy Trao Cho Anh ";
                break;
            case 3:
                nhactest = "Khuê Mộc Lang";
                break;
            case 4:
                nhactest = "Truyền Thái Y";
                break;
            case 5:
                nhactest = "Waiting For You";
                break;
            case 6:
                nhactest = "sauhonggai";
                break;
            case 7:
                nhactest = "MakingMyWay";
                break;
            case 8:
                nhactest = "TrueDamage";
                break;
            case 9:
                nhactest = "Enemy";
                break;
            default:
                break;
        }
        playSound();
        chaynhac.start();
    }
    public MouseAdapter mouseAdapterUserClickTab3 = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == nhanoktab3) {
                try {
                    if (nhac_on == true) {
                        chaynhac.stop();
                        nhac_on = false;
                    }
                    SetOKCheDoChoi();
                    setOKSound();

                    {

                    }
                    Menu_Main m = new Menu_Main();
                    setVisible(false);
                    m.setVisible(true);

                } catch (Exception j) {

                }
            } else if (e.getSource() == nhantestnow) {

                if (nhac_on == true) {
                    if (jcb.getSelectedIndex() != indexnhactemp) {
                        chaynhac.stop();
                        ganNhac();

                    } else {
                        chaynhac.stop();
                        nhac_on = false;
                    }
                } else if (nhac_on == false) {
                    ganNhac();
                    nhac_on = true;

                }
                indexnhactemp = jcb.getSelectedIndex();
            }
        }
    };

    public void playSound() {
        chaynhac = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "/sound_TLMN/" + nhactest + ".mp3";
                    InputStream fis = InGame.class.getResourceAsStream(url);
                    Player play = new Player(fis);
                    play.play();
                } catch (Exception e) {
                }
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        TuyChon a = new TuyChon();
        a.setVisible(true);

    }
}
