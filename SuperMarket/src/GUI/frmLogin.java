/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.SQLProvider;
import Controller.RandomStringGenerator;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author NGUYEN THANH THIEN
 */
public class frmLogin extends javax.swing.JFrame {

    String password = RandomStringGenerator.generateRandomDigits(6);
    boolean ghinho;
   
    frmThongBaoHoi adu = new frmThongBaoHoi();
    frmThongBaoRong tt = new frmThongBaoRong();
    frmThongBaoTK tkerro = new frmThongBaoTK();
    frmThongBaoEmail erroEmail = new frmThongBaoEmail();
    frmThongBaoNV nhanvientb = new frmThongBaoNV();
    frmThongBaoMK mktb = new frmThongBaoMK();
    frmThongBaoLoi error = new frmThongBaoLoi();

    public JTextField getTxtTaikhoan() {
        return txtTaikhoan;
    }

    public void setTxtTaikhoan(JTextField txtTaikhoan) {
        this.txtTaikhoan = txtTaikhoan;
    }

   

    /**
     *
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        String[] itemx = new String[]{"Nhân viên", "Quản lý"};
        DefaultComboBoxModel ccbmodel = new DefaultComboBoxModel(itemx);
        cbbVaitro.setModel(ccbmodel);
        lbhide.hide();  
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_BanHang";
    String user = "sa";
    String pass = "123";
    Statement st;
    ResultSet rs;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTaikhoan = new javax.swing.JTextField();
        cbbVaitro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        ckbGhinho = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        lb_DangKy = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMatkhau = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbhide = new javax.swing.JLabel();
        lbshow = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(231, 87, 89));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel2.setBackground(new java.awt.Color(60, 45, 81));

        jPanel3.setBackground(new java.awt.Color(231, 87, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bia_login.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tài khoản:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mật khẩu:");

        txtTaikhoan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTaikhoan.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));

        cbbVaitro.setBackground(new java.awt.Color(255, 228, 150));
        cbbVaitro.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        cbbVaitro.setForeground(new java.awt.Color(255, 255, 255));
        cbbVaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn vai trò", "Quản lý", "Nhân viên" }));
        cbbVaitro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Chọn vai trò:");

        btnClose.setBackground(new java.awt.Color(60, 45, 81));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 51, 51));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/exitout.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        ckbGhinho.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ckbGhinho.setForeground(new java.awt.Color(255, 255, 255));
        ckbGhinho.setText("Nhớ mật khẩu");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nếu bạn quên mật khẩu?");

        lb_DangKy.setFont(new java.awt.Font("Segoe UI Black", 0, 22)); // NOI18N
        lb_DangKy.setForeground(new java.awt.Color(94, 220, 255));
        lb_DangKy.setText("Click here");
        lb_DangKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_DangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_DangKyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_DangKyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_DangKyMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/store-cartoon-illustration-free-vector (2).png"))); // NOI18N

        txtMatkhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMatkhau.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 102), null));

        jLabel7.setFont(new java.awt.Font("Arial", 2, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Phần mềm được thực hiện bởi nhóm 9");

        jButton1.setBackground(new java.awt.Color(255, 57, 57));
        jButton1.setFont(new java.awt.Font("Segoe WP Black", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ĐĂNG NHẬP");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(97, 250, 250));
        jLabel8.setText("Công Nghệ Java ");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-collaborator-male-32.png"))); // NOI18N

        lbhide.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbhide.setForeground(new java.awt.Color(255, 255, 255));
        lbhide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbhide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-hide-25.png"))); // NOI18N
        lbhide.setText("Hide");
        lbhide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbhideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbhideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbhideMouseExited(evt);
            }
        });

        lbshow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbshow.setForeground(new java.awt.Color(255, 255, 255));
        lbshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbshow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-eye-25.png"))); // NOI18N
        lbshow.setText("Show");
        lbshow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbshow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbshowMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbshowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbshowMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)))
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(ckbGhinho, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbshow, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lbhide))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(cbbVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(cbbVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3))
                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4))
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckbGhinho, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lbshow))
                            .addComponent(lbhide))))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lb_DangKy)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
          if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?","Thông báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void lb_DangKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_DangKyMouseClicked
        // TODO add your handling code here:
        String email = txtTaikhoan.getText();
        if (email.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Gmail trống");
        } else if (!isValidEmail(txtTaikhoan.getText())) {
            erroEmail.setVisible(true);

        } else {
            try {
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url, user, pass);
                String sql = "Update NhanVien set Matkhau = ?  where Email = ?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, password);
                ps.setString(2, txtTaikhoan.getText().trim());

                int x = ps.executeUpdate();

                if (x >= 1) {
                    try {
                        String username = "shopbanquanaonhom10@gmail.com";
                        String passs = "xcycqixgukzacblv";

                        String toMail = txtTaikhoan.getText().trim();

                        String tieudemau = "Cấp lại mật khẩu ứng dụng";
                        String textmau = "Chào bạn đây là mật khẩu mới của bạn."
                                + "Mk: \n" + password;

                        String data = new frmLogin().SendMail(username, passs, toMail, tieudemau, textmau);

                        if (data.equals("true")) {

                            mktb.setVisible(true);

                        } else {

                            error.setVisible(true);
                        }
                    } catch (Exception e) {

                        error.setVisible(true);
                    }
                }
                else
                {
                     error.setVisible(true);
                }

            } catch (Exception e) {
                
            }
        }


    }//GEN-LAST:event_lb_DangKyMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (txtTaikhoan.getText().isEmpty() || txtMatkhau.getText().isEmpty()) {
            tt.setVisible(true);
        } else {
            int vaitro;

            if (cbbVaitro.getSelectedItem() == "Nhân viên") {
                vaitro = 0;
            } else {
                vaitro = 1;
            }
            try {
                String sql = "Select *from NhanVien where Email  = ? and Matkhau = ?";
                SQLProvider data = new SQLProvider();
                data.open();
                PreparedStatement ps = (data.getConnection()).prepareStatement(sql);

                ps.setString(1, txtTaikhoan.getText());
                ps.setString(2, txtMatkhau.getText());
                rs = ps.executeQuery();

                if (rs.next()) {
                    int vaitroSQL = rs.getInt("Vaitro");
                    if (vaitroSQL == vaitro) {

                        if (ckbGhinho.isSelected()) {
                            ghinho = true;
                            frmMain main = new frmMain(
                                    rs.getString("TenNV"),
                                    rs.getString("Email"),
                                    rs.getString("Matkhau"),
                                    rs.getInt("Vaitro"), ghinho,
                                    rs.getInt("MaNV"));
                           
                           
                            
                            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                            
                            main.setVisible(true);
                            
                            nhanvientb.setVisible(true);
                            this.setVisible(false);

                        } else {
                            ghinho = false;
                             frmMain main = new frmMain(
                                    rs.getString("TenNV"),
                                    rs.getString("Email"),
                                    rs.getString("Matkhau"),
                                    rs.getInt("Vaitro"), ghinho,
                                    rs.getInt("MaNV")
                            );
                             
                             
                            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                          
                            main.setVisible(true);
                            nhanvientb.setVisible(true);
                            this.setVisible(false);

                        }

                    } else {

                        adu.setVisible(true);
                    }

                } else {
                    tkerro.setVisible(true);
                }
               
            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void lb_DangKyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_DangKyMouseExited
        // TODO add your handling code here:
        lb_DangKy.setForeground(new Color(32, 136, 203));
    }//GEN-LAST:event_lb_DangKyMouseExited

    private void lb_DangKyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_DangKyMouseEntered
        // TODO add your handling code here:

        lb_DangKy.setForeground(new Color(232, 57, 95));

    }//GEN-LAST:event_lb_DangKyMouseEntered

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jLabel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1KeyReleased

    private void jLabel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1KeyTyped

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbshowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbshowMouseClicked
        // TODO add your handling code here:
        txtMatkhau.setEchoChar((char) 0);
        lbshow.hide();
        lbhide.show();
        
    }//GEN-LAST:event_lbshowMouseClicked

    private void lbhideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhideMouseClicked
        // TODO add your handling code here:
         txtMatkhau.setEchoChar('*');
         lbhide.hide();
         lbshow.show();
    }//GEN-LAST:event_lbhideMouseClicked

    private void lbhideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhideMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbhideMouseEntered

    private void lbhideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbhideMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbhideMouseExited

    private void lbshowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbshowMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbshowMouseEntered

    private void lbshowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbshowMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lbshowMouseExited

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(new Color(255,57,57));
        jButton1.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        
         jButton1.setBackground(new Color(255,102,0));
        jButton1.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jButton1MouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        // TODO add your handling code here:
        ImageIcon Iconclose = new ImageIcon(getClass().getResource("/iconButtom/exitout.png")); 
          btnClose.setIcon(Iconclose);
        
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        // TODO add your handling code here:
          ImageIcon Iconclose = new ImageIcon(getClass().getResource("/iconButtom/enterout.png")); 
       btnClose.setIcon(Iconclose);
    }//GEN-LAST:event_btnCloseMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new splashscreen.SplashScreen(null, true).setVisible(true);
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox<String> cbbVaitro;
    private javax.swing.JCheckBox ckbGhinho;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_DangKy;
    private javax.swing.JLabel lbhide;
    private javax.swing.JLabel lbshow;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JTextField txtTaikhoan;
    // End of variables declaration//GEN-END:variables

    private String SendMail(String Email, String Pass, String toMail, String Subjec, String Text) {

        String mss;

        final String username = Email;
        final String passwordre = Pass;

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwordre);
            }
        });
        try {

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(Email));
            msg.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toMail)
            );
            msg.setSubject(Subjec);
            msg.setText(Text);

            Transport.send(msg);
            mss = "true";
            return mss;

        } catch (Exception e) {
            return e.toString();
        }
    }

    public boolean isValidEmail(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(regex);
    }

    public void ghinhoTK(String tk, String mk) {

        txtTaikhoan.setText("" + tk);
        txtMatkhau.setText("" + mk);
        ckbGhinho.setSelected(true);
    }

    public void ghinhoTKVippro(String tk, String mk) {

        txtTaikhoan.setText("" + tk);
        txtMatkhau.setText("" + mk);
        ckbGhinho.setSelected(true);
        cbbVaitro.setSelectedIndex(1);
    }
}
