/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.ChuyenManHinh;
import ListProduct.DanhMucHangHoa;
import game.Menu_Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author RAVEN
 */
public final class frmMain extends javax.swing.JFrame {
     private boolean isFormOpen = false;
    String TenNV, Email, matkhau;
    int vaitro;
    int manhanvien;
    boolean ghinho;

    
    /**
     * Creates new form Main
     * @param tennv
     * @param email
     * @param matkhau
     * @param vaitro
     * @param ghinho
     * @param manhanvien
     */
    public frmMain(String tennv, String email, String matkhau, int vaitro, boolean  ghinho, int manhanvien) throws IOException {
        
        this.TenNV = tennv;
        this.Email = email;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
        this.ghinho = ghinho;
        this.manhanvien = manhanvien;
        initComponents();
      
        
        ChuyenManHinh controller = new ChuyenManHinh(jp_Manager, TenNV, manhanvien);
        controller.setView(jpnTrangChu, jlbTrangChu);
       
        Font fontTK = new Font("Arial", Font.BOLD, 16);
        txtxinchao.setFont(fontTK);
        txtvt.setFont(fontTK);
        txtLogin.setFont(fontTK);
        txtVaitro.setFont(fontTK);
        
        List<DanhMucHangHoa> listItem = new ArrayList<>();
        if(vaitro == 0)
        {
            txtLogin.setText(manhanvien+ "- " + TenNV);
            txtVaitro.setText("Nhân viên");
           
           
            listItem.add(new DanhMucHangHoa("Trangchu", jpnTrangChu, jlbTrangChu));
            listItem.add(new DanhMucHangHoa("Hanghoa", jpnHangHoa, jlbHangHoa));
            listItem.add(new DanhMucHangHoa("Nhacungcap", jpnNhacungcap, jlbNhaCungCap));
            listItem.add(new DanhMucHangHoa("Khachhang", jpnKhachHang, jlbKhachHang));
            listItem.add(new DanhMucHangHoa("Hoadon", jpnHoaDon, jlbHoaDon));
            
            controller.setEvent(listItem);
            jpnNhanVien.hide();
            jpnThongKe.hide();
            
        }
        else
        {
            txtLogin.setText(manhanvien+ "- " + TenNV);
            txtVaitro.setText("Quản lý");
           
            listItem.add(new DanhMucHangHoa("Trangchu", jpnTrangChu, jlbTrangChu));
            listItem.add(new DanhMucHangHoa("Hanghoa", jpnHangHoa, jlbHangHoa));
            listItem.add(new DanhMucHangHoa("Nhacungcap", jpnNhacungcap, jlbNhaCungCap));
            listItem.add(new DanhMucHangHoa("Nhanvien", jpnNhanVien, jlbNhanVien));
            listItem.add(new DanhMucHangHoa("Thongke", jpnThongKe, jlbThongke));
            listItem.add(new DanhMucHangHoa("Khachhang", jpnKhachHang, jlbKhachHang));
            listItem.add(new DanhMucHangHoa("Hoadon", jpnHoaDon, jlbHoaDon));
           
            controller.setEvent(listItem);
           
        }
        
        
//        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        
    }

    public frmMain() throws IOException {
        initComponents();
        ChuyenManHinh controller = new ChuyenManHinh(jp_Manager,TenNV, manhanvien);
        controller.setView(jpnTrangChu, jlbTrangChu);
        Font font = new Font("Arial", Font.BOLD, 12);
        txtLogin.setFont(font);
        List<DanhMucHangHoa> listItem = new ArrayList<>();

        listItem.add(new DanhMucHangHoa("Trangchu", jpnTrangChu, jlbTrangChu));
        listItem.add(new DanhMucHangHoa("Hanghoa", jpnHangHoa, jlbHangHoa));
        listItem.add(new DanhMucHangHoa("Nhacungcap", jpnNhacungcap, jlbNhaCungCap));
        listItem.add(new DanhMucHangHoa("Nhanvien", jpnNhanVien, jlbNhanVien));
        listItem.add(new DanhMucHangHoa("Thongke", jpnThongKe, jlbThongke));
        listItem.add(new DanhMucHangHoa("Khachhang", jpnKhachHang, jlbKhachHang));
        listItem.add(new DanhMucHangHoa("Hoadon", jpnHoaDon, jlbHoaDon));
   
        controller.setEvent(listItem);
//
////        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            
    }


    String driver  = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_BanHang";
    String user = "sa";
    String pass = "123";
    Statement st ;
    ResultSet rs;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnclose = new javax.swing.JButton();
        txtxinchao = new javax.swing.JLabel();
        txtLogin = new javax.swing.JLabel();
        jlb_taikhoan = new javax.swing.JLabel();
        txtvt = new javax.swing.JLabel();
        txtVaitro = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jpnHangHoa = new javax.swing.JPanel();
        jlbHangHoa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jpnNhacungcap = new javax.swing.JPanel();
        jlbNhaCungCap = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongke = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGame = new javax.swing.JButton();
        jp_Manager = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jbl_dangxuat = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 176, 97));
        setUndecorated(true);

        jButton1.setText("jButton1");

        jPanel1.setBackground(new java.awt.Color(60, 45, 81));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jPanel2.setBackground(new java.awt.Color(60, 45, 81));

        btnclose.setBackground(new java.awt.Color(60, 45, 81));
        btnclose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnclose.setForeground(new java.awt.Color(0, 51, 51));
        btnclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/exitout.png"))); // NOI18N
        btnclose.setBorder(null);
        btnclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncloseMouseExited(evt);
            }
        });
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        txtxinchao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtxinchao.setForeground(new java.awt.Color(253, 81, 38));
        txtxinchao.setText("Xin chào: ");

        txtLogin.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(253, 81, 38));
        txtLogin.setText("Username");
        txtLogin.setEnabled(false);

        jlb_taikhoan.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlb_taikhoan.setForeground(new java.awt.Color(236, 236, 25));
        jlb_taikhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlb_taikhoan.setText("Thông tin tài khoản");
        jlb_taikhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlb_taikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_taikhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlb_taikhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlb_taikhoanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlb_taikhoanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlb_taikhoanMouseReleased(evt);
            }
        });

        txtvt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtvt.setForeground(new java.awt.Color(253, 81, 38));
        txtvt.setText("Vai trò:");

        txtVaitro.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtVaitro.setText("Vaitro");
        txtVaitro.setEnabled(false);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pngtree-account-avatar-user-abstract-circle-background-flat-color-icon-png-image_1650938 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtxinchao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtvt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlb_taikhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtvt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtxinchao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtVaitro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlb_taikhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnclose, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(60, 45, 81));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        jpnHangHoa.setBackground(new java.awt.Color(213, 234, 255));
        jpnHangHoa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        jpnHangHoa.setForeground(new java.awt.Color(0, 0, 102));
        jpnHangHoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlbHangHoa.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jlbHangHoa.setForeground(new java.awt.Color(0, 0, 102));
        jlbHangHoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHangHoa.setText("QUẢN LÝ HÀNG HÓA");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-open-box-50.png"))); // NOI18N

        javax.swing.GroupLayout jpnHangHoaLayout = new javax.swing.GroupLayout(jpnHangHoa);
        jpnHangHoa.setLayout(jpnHangHoaLayout);
        jpnHangHoaLayout.setHorizontalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHangHoaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnHangHoaLayout.setVerticalGroup(
            jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHangHoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlbHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnNhanVien.setBackground(new java.awt.Color(213, 234, 255));
        jpnNhanVien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        jpnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlbNhanVien.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jlbNhanVien.setForeground(new java.awt.Color(0, 0, 102));
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhanVien.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-employee-50.png"))); // NOI18N

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnHoaDon.setBackground(new java.awt.Color(213, 234, 255));
        jpnHoaDon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        jpnHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnHoaDonMouseClicked(evt);
            }
        });

        jlbHoaDon.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jlbHoaDon.setForeground(new java.awt.Color(0, 0, 102));
        jlbHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHoaDon.setText("QUẢN LÝ HÓA ĐƠN");
        jlbHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHoaDonMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-tear-off-calendar-50.png"))); // NOI18N

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlbHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnNhacungcap.setBackground(new java.awt.Color(213, 234, 255));
        jpnNhacungcap.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        jpnNhacungcap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnNhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnNhacungcapMouseClicked(evt);
            }
        });

        jlbNhaCungCap.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jlbNhaCungCap.setForeground(new java.awt.Color(0, 0, 102));
        jlbNhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhaCungCap.setText("ĐỐI TÁC LÀM ĂN");
        jlbNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbNhaCungCapMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-handshake-50.png"))); // NOI18N

        javax.swing.GroupLayout jpnNhacungcapLayout = new javax.swing.GroupLayout(jpnNhacungcap);
        jpnNhacungcap.setLayout(jpnNhacungcapLayout);
        jpnNhacungcapLayout.setHorizontalGroup(
            jpnNhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhacungcapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnNhacungcapLayout.setVerticalGroup(
            jpnNhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhacungcapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnNhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlbNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnKhachHang.setBackground(new java.awt.Color(213, 234, 255));
        jpnKhachHang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        jpnKhachHang.setForeground(new java.awt.Color(0, 0, 102));
        jpnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlbKhachHang.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jlbKhachHang.setForeground(new java.awt.Color(0, 0, 102));
        jlbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbKhachHang.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-administrator-male-50.png"))); // NOI18N

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnThongKe.setBackground(new java.awt.Color(213, 234, 255));
        jpnThongKe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        jpnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlbThongke.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        jlbThongke.setForeground(new java.awt.Color(0, 0, 102));
        jlbThongke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongke.setText("THỐNG KÊ DANH THU");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-statistics-50.png"))); // NOI18N

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbThongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlbThongke, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnGame.setBackground(new java.awt.Color(153, 255, 255));
        btnGame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-game-controller-52.png"))); // NOI18N
        btnGame.setText("GAME GIẢI TRÍ");
        btnGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 4));
        btnGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGameMouseExited(evt);
            }
        });
        btnGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnHangHoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnNhacungcap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnHangHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnNhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_Manager.setPreferredSize(new java.awt.Dimension(963, 751));

        javax.swing.GroupLayout jp_ManagerLayout = new javax.swing.GroupLayout(jp_Manager);
        jp_Manager.setLayout(jp_ManagerLayout);
        jp_ManagerLayout.setHorizontalGroup(
            jp_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_ManagerLayout.setVerticalGroup(
            jp_ManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(60, 45, 81));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/store-cartoon-illustration-free-vector (2).png"))); // NOI18N

        jpnTrangChu.setBackground(new java.awt.Color(213, 234, 255));
        jpnTrangChu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 255), 2, true));
        jpnTrangChu.setForeground(new java.awt.Color(92, 218, 92));
        jpnTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlbTrangChu.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(0, 0, 102));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrangChu.setText("TRANG CHỦ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconMain/icons8-home-50.png"))); // NOI18N

        javax.swing.GroupLayout jpnTrangChuLayout = new javax.swing.GroupLayout(jpnTrangChu);
        jpnTrangChu.setLayout(jpnTrangChuLayout);
        jpnTrangChuLayout.setHorizontalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnTrangChuLayout.setVerticalGroup(
            jpnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChuLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jlbTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-logout-35.png"))); // NOI18N

        jbl_dangxuat.setBackground(new java.awt.Color(255, 153, 153));
        jbl_dangxuat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jbl_dangxuat.setForeground(new java.awt.Color(255, 84, 84));
        jbl_dangxuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbl_dangxuat.setText("Đăng xuất");
        jbl_dangxuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbl_dangxuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbl_dangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbl_dangxuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_dangxuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_dangxuatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbl_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jp_Manager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp_Manager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbl_dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát phần mềm không?","Thông báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_btncloseActionPerformed

    
    public void Thoat()
    { 
        this.dispose();
        frmLogin dn = new frmLogin();
        dn.setVisible(true);
       
        
    }
    
    public void LayTThoaDOn()
    {
     
         try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "Select *from NhanVien where Email = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Email);
            rs = ps.executeQuery();
            
           if(rs.next()) {
               frmCTHoaDon ct = new frmCTHoaDon(rs.getInt("MaNV"),rs.getString("TenNV"));
            
               ct.setVisible(true);
               
            }    
        } catch (Exception e) {
        }     
    }
    private void jlb_taikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_taikhoanMouseClicked
        // TODO add your handling code here:

        try {
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "Select *from NhanVien where Email = '" + Email + "'";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                frmTaiKhoan tk = new frmTaiKhoan(
                        rs.getString("Email"),
                        rs.getString("Matkhau"));
                
                    tk.setVisible(true);

            }

        } catch (Exception e) {
        }



    }//GEN-LAST:event_jlb_taikhoanMouseClicked

    private void jbl_dangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_dangxuatMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (ghinho == true && vaitro == 0) {
                JOptionPane.showMessageDialog(frmMain.this, "Đăng xuất thành công");
                setVisible(false);
                frmLogin dn = new frmLogin();
                dn.ghinhoTK(Email, matkhau);
                dn.setVisible(true);
            }else if(ghinho == true && vaitro == 1)
                
            {
                JOptionPane.showMessageDialog(frmMain.this, "Đăng xuất thành công");
                setVisible(false);
                frmLogin dn = new frmLogin();
                dn.ghinhoTKVippro(Email, matkhau);
                dn.setVisible(true);
            }
            
            else {
                JOptionPane.showMessageDialog(frmMain.this, "Đăng xuất thành công");
                setVisible(false);
                frmLogin dn = new frmLogin();

                dn.setVisible(true);
            }
        }
    }//GEN-LAST:event_jbl_dangxuatMouseClicked

    private void jlb_taikhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_taikhoanMouseEntered
        // TODO add your handling code here:
        jlb_taikhoan.setForeground(Color.red);
    }//GEN-LAST:event_jlb_taikhoanMouseEntered

    private void jlb_taikhoanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_taikhoanMouseReleased
        // TODO add your handling code here:
        jlb_taikhoan.setForeground(new Color(236,236,25));
    }//GEN-LAST:event_jlb_taikhoanMouseReleased

    private void jlb_taikhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_taikhoanMousePressed
        // TODO add your handling code here:
         jlb_taikhoan.setForeground(new Color(236,236,25));
    }//GEN-LAST:event_jlb_taikhoanMousePressed

    private void jlb_taikhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_taikhoanMouseExited
        // TODO add your handling code here:
        jlb_taikhoan.setForeground(new Color(236,236,25));
    }//GEN-LAST:event_jlb_taikhoanMouseExited

    private void jbl_dangxuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_dangxuatMouseEntered
        // TODO add your handling code here:
        jbl_dangxuat.setForeground(new Color(236,236,25));
    }//GEN-LAST:event_jbl_dangxuatMouseEntered

    private void jbl_dangxuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_dangxuatMouseExited
        // TODO add your handling code here:
        jbl_dangxuat.setForeground(new Color(255,84,84));
        
    }//GEN-LAST:event_jbl_dangxuatMouseExited

    private void jlbNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbNhaCungCapMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jlbNhaCungCapMouseClicked

    private void jpnNhacungcapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhacungcapMouseClicked
        // TODO add your handling code here:
         
          
    }//GEN-LAST:event_jpnNhacungcapMouseClicked

    private void jlbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHoaDonMouseClicked
          
       
         
    }//GEN-LAST:event_jlbHoaDonMouseClicked

    private void jpnHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnHoaDonMouseClicked

        
           
    }//GEN-LAST:event_jpnHoaDonMouseClicked

    private void btnGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGameActionPerformed
        // TODO add your handling code here:
      
        Menu_Main game = new Menu_Main();
        if (!isFormOpen) {
            isFormOpen = true;
            
            game.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    isFormOpen = false;
                    
                }
            });
             new splashscreen.SplashScreenGame(null, true).setVisible(true);
            game.setVisible(true);

        }
        else
        {
             game.dispose();
             game.setVisible(true);
        }
    }//GEN-LAST:event_btnGameActionPerformed

    private void btnGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGameMouseEntered
        // TODO add your handling code here:
        btnGame.setBackground(new Color(255,255,0));
    }//GEN-LAST:event_btnGameMouseEntered

    private void btnGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGameMouseExited
        // TODO add your handling code here:
        btnGame.setBackground(new Color(153,255,255));
    }//GEN-LAST:event_btnGameMouseExited

    private void btncloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncloseMouseEntered
        // TODO add your handling code here:
       ImageIcon Iconclose = new ImageIcon(getClass().getResource("/iconButtom/enterout.png")); 
       btnclose.setIcon(Iconclose);
    }//GEN-LAST:event_btncloseMouseEntered

    private void btncloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncloseMouseExited
        // TODO add your handling code here:
         ImageIcon Iconclose = new ImageIcon(getClass().getResource("/iconButtom/exitout.png")); 
          btnclose.setIcon(Iconclose);
    }//GEN-LAST:event_btncloseMouseExited

    public void dangxuat()
    {
         JOptionPane.showMessageDialog(frmMain.this, "Vui long dang nhap lai");
        setVisible(false);
        frmLogin dn = new frmLogin();
        dn.setVisible(true);
    }
        
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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmMain().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGame;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JLabel jbl_dangxuat;
    private javax.swing.JLabel jlbHangHoa;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbNhaCungCap;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbThongke;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JLabel jlb_taikhoan;
    private javax.swing.JPanel jp_Manager;
    private javax.swing.JPanel jpnHangHoa;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnNhacungcap;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtVaitro;
    private javax.swing.JLabel txtvt;
    private javax.swing.JLabel txtxinchao;
    // End of variables declaration//GEN-END:variables

    public void resetName()
    {
        txtLogin.setText(manhanvien+ "- " + TenNV);
    }
   
}
