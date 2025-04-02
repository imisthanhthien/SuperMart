/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controller.NumberOnlyFilter;
import DAO.DAO_CTPhieuXuat;
import DAO.DAO_PhieuXuat;
import DAO.SQLProvider;
import POJO.CTPhieuXuat;
import POJO.HangHoa;
import POJO.KhachHang;
import POJO.NhanVien;
import POJO.PhieuXuat;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AbstractDocument;


/**
 *
 * @author NGUYEN THANH THIEN
 */
public final class frmPhieuXuat extends javax.swing.JFrame {

    String T = "Đã duyệt";
    String F = "Chưa duyệt";
     DecimalFormat dfpx = new DecimalFormat("#,###");
    DecimalFormat df = new DecimalFormat("#.###");
    Map< String, Integer> items = new HashMap<>();
    Map< String, Integer> itemhh = new HashMap<>();

    PhieuXuat px = new PhieuXuat();
    CTPhieuXuat ctpx = new CTPhieuXuat();

    Vector dataPX = new Vector();
    Vector<String> headerPX = new Vector<>();
    DefaultTableModel tblModelPX = new DefaultTableModel();

    Vector dataCTPX = new Vector();
    Vector<String> headerCTPX = new Vector<>();
    DefaultTableModel tblModelCTPX = new DefaultTableModel();

    int manhanvien;
    String tennhanvien;
    int vaitro;
    float thanhtien = 0;
    NhanVien nv = new NhanVien();
    KhachHang kh = new KhachHang();
    HangHoa hh = new HangHoa();

    /**
     * Creates new form frmPhieuXuat
     *
     * @param manv
     * @param tennv
     * @param vaitro
     */
    public frmPhieuXuat(int manv, String tennv, int vaitro) {
        this.manhanvien = manv;
        this.tennhanvien = tennv;
        this.vaitro = vaitro;
        initComponents();
        setLocationRelativeTo(null);
        LoadCbbKhachHang();
        LoadComboboxHangHoa();

        //Phiếu xuất
        tblModelPX = (DefaultTableModel) this.tblPX.getModel();
        headerPX.add("SỐ PN");
        headerPX.add("NGÀY BÁN");
        headerPX.add("LÝ DO XUẤT");
        headerPX.add("NHÂN VIÊN XUẤT");
        headerPX.add("KHÁCH HÀNG");
        headerPX.add("TỔNG TIỀN");
        tblModelPX.setDataVector(dataPX, headerPX);
        LoadTablePhieuXuat();

        TableColumnModel columnModel = tblPX.getColumnModel();
        TableColumn column = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);
        TableColumn column2 = columnModel.getColumn(2);
        TableColumn column3 = columnModel.getColumn(3);
        TableColumn column4 = columnModel.getColumn(4);
        TableColumn column5 = columnModel.getColumn(5);

        column.setPreferredWidth(2);
        column1.setPreferredWidth(3);
        column2.setPreferredWidth(5);
        column3.setPreferredWidth(80);
        column4.setPreferredWidth(70);
        column5.setPreferredWidth(30);

        TableCellRenderer rendererFromHeader = tblPX.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        tblPX.getTableHeader().setDefaultRenderer(rendererFromHeader);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // tạo renderer
        renderer.setHorizontalAlignment(JLabel.CENTER); // thiết lập căn giữa cho dòng
        for (int i = 0; i < tblPX.getColumnCount(); i++) {
            tblPX.getColumnModel().getColumn(i).setCellRenderer(renderer); // sử dụng renderer cho tất cả các cột
        }

        tblPX.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblPX.getTableHeader().setOpaque(false);
        tblPX.getTableHeader().setBackground(new Color(32, 136, 203));
        tblPX.getTableHeader().setForeground(new Color(0, 0, 0));
        tblPX.setRowHeight(25);

        //Chi tiết Phiếu xuất
        tblModelCTPX = (DefaultTableModel) this.tblCTPhieuXuat.getModel();
        headerCTPX.add("MÃ HÀNG");
        headerCTPX.add("TÊN HÀNG HÓA");
        headerCTPX.add("SỐ LƯỢNG");
        headerCTPX.add("ĐƠN GIÁ");
        headerCTPX.add("THÀNH TIỀN");
        tblModelCTPX.setDataVector(dataCTPX, headerCTPX);
        LoadTableCTPX();

        tblCTPhieuXuat.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblCTPhieuXuat.getTableHeader().setOpaque(false);
        tblCTPhieuXuat.getTableHeader().setBackground(new Color(32, 136, 203));
        tblCTPhieuXuat.getTableHeader().setForeground(new Color(0, 0, 0));
        tblCTPhieuXuat.setRowHeight(25);

        txtMaNV.setText("" + manv + " | " + tennv.toUpperCase());
        txtNgayBan.setText("" + java.time.LocalDate.now());
        buttonGroup1.add(checkGHF);
        buttonGroup1.add(checkGHT);
        
        if(vaitro == 0)
        {
            checkGHF.hide();
            checkGHT.hide();
           
        }
        else
        {
            checkGHF.show();
            checkGHT.show();
        }
        textPX.setText("Mã phiếu xuất: @mapx?" + "\n"
                + "Ngày xuất: @ngay?" + "\n"
                + "Lý do xuất: @lydo?" + "\n"
                + "Nhân viên xuất: @nhanvien?" + "\n"
                + "Xuất cho KH: @khachhang?" + "\n"
                + "Tiền nhận: @tien?" + "\n"
                + "Trạng thái: @trangthai?" + "\n"
        );
        
        event();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    frmPhieuXuat() {
        JOptionPane.showMessageDialog(this,
                "Vui lòng đăng nhập");
        System.exit(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtSoluongXuat = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtNgayBan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtGiaXuat = new javax.swing.JTextField();
        txtLydoxuat = new javax.swing.JTextField();
        btnXuatHang = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbbhanghoa = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        btn_in = new javax.swing.JButton();
        btnLamMoiPX = new javax.swing.JButton();
        btnThemPX = new javax.swing.JButton();
        btnXoaPX = new javax.swing.JButton();
        btnSuaPX = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTPhieuXuat = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPX = new javax.swing.JTable();
        checkGHF = new javax.swing.JCheckBox();
        checkGHT = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPX = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(60, 45, 81));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 760));

        jPanel3.setBackground(new java.awt.Color(60, 45, 81));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN PHIẾU XUẤT HÀNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(360, 450));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Số lượng xuất:");

        txtSoluongXuat.setBackground(new java.awt.Color(252, 218, 209));
        txtSoluongXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoluongXuat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoluongXuatKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Mã NV|Tên NV:");

        txtMaNV.setEditable(false);
        txtMaNV.setBackground(new java.awt.Color(252, 218, 209));
        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtMaNV.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Chọn khách hàng cần xuất hàng:");

        cbbKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ngày xuất hàng");

        txtNgayBan.setEditable(false);
        txtNgayBan.setBackground(new java.awt.Color(252, 218, 209));
        txtNgayBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayBan.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 204));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Lý do xuất:");

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Giá xuất:");

        txtGiaXuat.setBackground(new java.awt.Color(252, 218, 209));
        txtGiaXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaXuat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaXuatKeyReleased(evt);
            }
        });

        txtLydoxuat.setBackground(new java.awt.Color(252, 218, 209));
        txtLydoxuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnXuatHang.setBackground(new java.awt.Color(0, 255, 255));
        btnXuatHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-export-50 (1).png"))); // NOI18N
        btnXuatHang.setText("XUẤT HÀNG");
        btnXuatHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHangActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Hàng hóa:");

        cbbhanghoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbbhanghoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 204));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Thành tiền:");

        txtThanhTien.setEditable(false);
        txtThanhTien.setBackground(new java.awt.Color(252, 218, 209));
        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtThanhTien.setEnabled(false);

        btn_in.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-bill-30.png"))); // NOI18N
        btn_in.setText("Lưu phiếu");
        btn_in.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayBan))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaNV))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbhanghoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(26, 26, 26)
                                .addComponent(txtLydoxuat))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSoluongXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                            .addComponent(txtGiaXuat)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnXuatHang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_in)))
                                .addGap(0, 2, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cbbhanghoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSoluongXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtGiaXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLydoxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_in))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        btnLamMoiPX.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoiPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-new-copy-50.png"))); // NOI18N
        btnLamMoiPX.setText(" THÊM MỚI ");
        btnLamMoiPX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoiPX.setPreferredSize(new java.awt.Dimension(190, 57));
        btnLamMoiPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiPXActionPerformed(evt);
            }
        });

        btnThemPX.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-paid-bill-50.png"))); // NOI18N
        btnThemPX.setText(" LƯU PHIẾU");
        btnThemPX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemPX.setPreferredSize(new java.awt.Dimension(190, 57));
        btnThemPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPXActionPerformed(evt);
            }
        });

        btnXoaPX.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-agreement-delete-50.png"))); // NOI18N
        btnXoaPX.setText("XÓA PHIẾU");
        btnXoaPX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPXActionPerformed(evt);
            }
        });

        btnSuaPX.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaPX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-renew-50.png"))); // NOI18N
        btnSuaPX.setText("SỬA PHIẾU");
        btnSuaPX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaPX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPXActionPerformed(evt);
            }
        });

        tblCTPhieuXuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCTPhieuXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblCTPhieuXuat.setFillsViewportHeight(true);
        tblCTPhieuXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhieuXuatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTPhieuXuat);

        tblPX.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblPX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tblPX.setFillsViewportHeight(true);
        tblPX.setFocusable(false);
        tblPX.setRowHeight(25);
        tblPX.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblPX.getTableHeader().setReorderingAllowed(false);
        tblPX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPXMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPX);

        checkGHF.setForeground(new java.awt.Color(255, 255, 0));
        checkGHF.setText("Không duyệt");
        checkGHF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGHFActionPerformed(evt);
            }
        });

        checkGHT.setForeground(new java.awt.Color(255, 255, 0));
        checkGHT.setText("Duyệt ");
        checkGHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGHTActionPerformed(evt);
            }
        });

        textPX.setEditable(false);
        textPX.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(textPX);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLamMoiPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoaPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnThemPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSuaPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(53, 53, 53))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(checkGHF, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkGHT)
                                .addGap(37, 37, 37)))
                        .addContainerGap(8, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoiPX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaPX)
                            .addComponent(btnSuaPX))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkGHF)
                            .addComponent(checkGHT)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPXMouseClicked
        // TODO add your handling code here:
        int pos = tblPX.getSelectedRow();

        int maphieu = (int) tblPX.getValueAt(pos, 0);
        try {
            String sql = "select *from PhieuXuat where MaPX = " + maphieu;
            SQLProvider kttt = new SQLProvider();
            kttt.open();
            ResultSet rskt = kttt.executeQuery(sql);
            if (rskt.next()) {
                if (rskt.getInt("Trangthai") == 0) {
                    textPX.setText("Mã phiếu xuất: " + tblModelPX.getValueAt(pos, 0) + "\n"
                            + "Ngày xuất: " + tblModelPX.getValueAt(pos, 1) + "\n"
                            + "Lý do xuất: " + tblModelPX.getValueAt(pos, 2) + "\n"
                            + "Nhân viên xuất: " + tblModelPX.getValueAt(pos, 3) + "\n"
                            + "Xuất cho KH: " + tblModelPX.getValueAt(pos, 4) + "\n"
                            + "Tiền nhận: " + tblModelPX.getValueAt(pos, 5) + " VNĐ \n"
                            + "Trạng thái: " + F + "\n"
                    );
                    buttonGroup1.clearSelection();
                    checkGHF.setSelected(true);

                } else {

                    textPX.setText("Mã phiếu xuất: " + tblModelPX.getValueAt(pos, 0) + "\n"
                            + "Ngày xuất: " + tblModelPX.getValueAt(pos, 1) + "\n"
                            + "Lý do xuất: " + tblModelPX.getValueAt(pos, 2) + "\n"
                            + "Nhân viên xuất: " + tblModelPX.getValueAt(pos, 3) + "\n"
                            + "Xuất cho KH: " + tblModelPX.getValueAt(pos, 4) + "\n"
                            + "Tiền nhận: " + tblModelPX.getValueAt(pos, 5) + " VNĐ \n"
                            + "Trạng thái: " + T + "\n"
                    );
                    buttonGroup1.clearSelection();
                    checkGHT.setSelected(true);

                }

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblPXMouseClicked

    private void btnLamMoiPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiPXActionPerformed
        // TODO add your handling code here:

        txtSoluongXuat.setText("");
        this.txtThanhTien.setText("");
        this.txtGiaXuat.setText("");
        this.txtLydoxuat.setText("");

        this.txtSoluongXuat.requestFocus();
    }//GEN-LAST:event_btnLamMoiPXActionPerformed

    private void btnThemPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPXActionPerformed
        // TODO add your handling code here:
        String soluong = txtSoluongXuat.getText();
        String giaban = txtGiaXuat.getText();
        String nhomHH = (String) cbbhanghoa.getSelectedItem();
        int manhomHH = itemhh.get(nhomHH);
        String mahh = String.valueOf(manhomHH);
        if (soluong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lượng!!!");
        } else if (giaban.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập giá!!!");
        } else if (KT_TonTaiHangHoa(mahh)) {
            JOptionPane.showMessageDialog(this, "Mặt hàng xuất đã có, vui lòng (tăng - giảm) số lượng hoặc chọn mặt hàng khác!!!");
        } else {
            InsertCTPhieuXuat();
            cbbhanghoa.removeAllItems();
            LoadComboboxHangHoa();
        }

    }//GEN-LAST:event_btnThemPXActionPerformed

    private void btnXoaPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPXActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int pos = tblCTPhieuXuat.getSelectedRow();
        try {
            if (pos < 0) {
                JOptionPane.showMessageDialog(this, "Chưa chọn hàng hóa cần xóa trên bảng, vui lòng thử lại!!!");
            } else {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa phiếu này không", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.DeleteCTPhieuXuat();
                    cbbhanghoa.removeAllItems();
                    LoadComboboxHangHoa();
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnXoaPXActionPerformed

    private void btnSuaPXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPXActionPerformed
        // TODO add your handling code here:
        int pos = tblCTPhieuXuat.getSelectedRow();
        try {
            if (pos < 0) {
                JOptionPane.showMessageDialog(this, "Chưa chọn mặt hàng cần sửa!!!");
            } else {
                this.UpdateCTPhieuXuat();
                cbbhanghoa.removeAllItems();
                LoadComboboxHangHoa();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnSuaPXActionPerformed

    private void btnXuatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHangActionPerformed
        // TODO add your handling code here:
        int pos = tblCTPhieuXuat.getSelectedRow();
        try {
            if (KT_CTXuatEmpty()) {

                PayCTPhieuXuat();

            } else {
                JOptionPane.showMessageDialog(this, "Không có đơn hàng nào để xuất!!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnXuatHangActionPerformed

    private void tblCTPhieuXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhieuXuatMouseClicked
        // TODO add your handling code here:
        try {
            int pos = tblCTPhieuXuat.getSelectedRow();

            this.cbbhanghoa.setSelectedItem((String) (tblCTPhieuXuat.getValueAt(pos, 1)));
            this.txtSoluongXuat.setText("" + tblModelCTPX.getValueAt(pos, 2));
            this.txtGiaXuat.setText("" + tblModelCTPX.getValueAt(pos, 3));
            this.txtThanhTien.setText("" + tblModelCTPX.getValueAt(pos, 4));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblCTPhieuXuatMouseClicked

    private void txtSoluongXuatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoluongXuatKeyReleased
        // TODO add your handling code here:
        try {
            int soluong = Integer.parseInt(txtSoluongXuat.getText());
            float giaxuat = Float.parseFloat(txtGiaXuat.getText());
            if (txtGiaXuat.getText().equals("")) {

            } else {
                double tt = soluong * giaxuat;
                
                txtThanhTien.setText("" + df.format(tt));
            }

        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_txtSoluongXuatKeyReleased

    private void txtGiaXuatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaXuatKeyReleased
        // TODO add your handling code here:
        try {
            int soluong = Integer.parseInt(txtSoluongXuat.getText());
            float giaxuat = Float.parseFloat(txtGiaXuat.getText());

            if (txtSoluongXuat.getText().equals("")) {

            } else {
                double tt = soluong * giaxuat;
                
                txtThanhTien.setText("" + df.format(tt));
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtGiaXuatKeyReleased

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_BanHang";
    String user = "sa";
    String pass = "123";
    Statement st;
    ResultSet rs;
    private void btn_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inActionPerformed
        // TODO add your handling code here:
        String tenkh = (String) cbbKhachHang.getSelectedItem();
        ArrayList<CTPhieuXuat> lisst = DAO_CTPhieuXuat.DS_CTPhieuXuat();
        frmxuat xuathang = new frmxuat(tenkh,tennhanvien,lisst);
        xuathang.setVisible(true);
    }//GEN-LAST:event_btn_inActionPerformed

    private void checkGHFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGHFActionPerformed
        // TODO add your handling code here:
        int pos = tblPX.getSelectedRow();
        int maphieu = (int) tblPX.getValueAt(pos, 0);
        int rootTrangThai;
        if (checkGHF.isSelected()) {
            rootTrangThai = 0;
        } else {
            rootTrangThai = 1;
        }

        boolean KT = DAO_PhieuXuat.UpdateTrangThai(maphieu, rootTrangThai);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Đã cập nhập trạng thái thành công");
            ChuaDuyet();
        }
    }//GEN-LAST:event_checkGHFActionPerformed

    private void checkGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGHTActionPerformed
        // TODO add your handling code here:
        int pos = tblPX.getSelectedRow();
        int maphieu = (int) tblPX.getValueAt(pos, 0);
        int rootTrangThai;
        if (checkGHF.isSelected()) {
            rootTrangThai = 0;
        } else {
            rootTrangThai = 1;
        }

        boolean KT = DAO_PhieuXuat.UpdateTrangThai(maphieu, rootTrangThai);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Đã cập nhập trạng thái thành công");
            Duyet();
        }
    }//GEN-LAST:event_checkGHTActionPerformed

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
            java.util.logging.Logger.getLogger(frmPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPhieuXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPhieuXuat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiPX;
    private javax.swing.JButton btnSuaPX;
    private javax.swing.JButton btnThemPX;
    private javax.swing.JButton btnXoaPX;
    private javax.swing.JButton btnXuatHang;
    private javax.swing.JButton btn_in;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbhanghoa;
    private javax.swing.JCheckBox checkGHF;
    private javax.swing.JCheckBox checkGHT;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCTPhieuXuat;
    private javax.swing.JTable tblPX;
    private javax.swing.JTextPane textPX;
    private javax.swing.JTextField txtGiaXuat;
    private javax.swing.JTextField txtLydoxuat;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayBan;
    private javax.swing.JTextField txtSoluongXuat;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables

    private void LoadTablePhieuXuat() {
        try {
            SQLProvider data = new SQLProvider();
            data.open();
            CallableStatement cs = (data.getConnection()).prepareCall("{call DS_Xuat()}");
            cs.execute();
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Vector v = new Vector();

                px.setMaPX(rs.getInt(1));
                px.setNgayBan(rs.getString(2));
                px.setLyDoXuat(rs.getString(3));
                nv.setTenNV(rs.getString(4));
                kh.setTenKH(rs.getString(5));
                px.setThanhtien(rs.getFloat(6));
                v.add(px.getMaPX());
                v.add(px.getNgayBan());
                v.add(px.getLyDoXuat());
                v.add(nv.getTenNV());
                v.add(kh.getTenKH());
                v.add(dfpx.format(px.getThanhtien()));

                dataPX.add(v);
            }

        } catch (Exception e) {
        }

    }

    private void LoadCbbKhachHang() {
        try {
            String SQL = "SELECT *FROM KhachHang";
            SQLProvider data = new SQLProvider();
            data.open();
            DefaultComboBoxModel ccbmodel = new DefaultComboBoxModel();
            cbbKhachHang.setModel(ccbmodel);
            ResultSet rs = data.executeQuery(SQL);

            while (rs.next()) {
                int id = rs.getInt("MaKH");
                String name = rs.getString("TenKH");
                items.put(name, id);
                ccbmodel.addElement(name);
            }

            data.close();
        } catch (SQLException e) {
            System.out.println("LỗI: " + e.getMessage());
        }
    }

    private void LoadTableCTPX() {
        try {
            SQLProvider data = new SQLProvider();
            data.open();
            CallableStatement cs = (data.getConnection()).prepareCall("{call LoadCTPhieuXuat()}");
            cs.execute();

            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Vector v = new Vector();

                hh.setMaHH(rs.getInt(1));
                hh.setTenHH(rs.getString(2));
                ctpx.setSoluongXuat(rs.getInt(3));
                ctpx.setGiaxuat(rs.getFloat(4));
                ctpx.setThanhtien(rs.getFloat(5));

                v.add(hh.getMaHH());
                v.add(hh.getTenHH());
                v.add(ctpx.getSoluongXuat());
                v.add(df.format(ctpx.getGiaxuat()));
                v.add(df.format(ctpx.getThanhtien()));

                dataCTPX.add(v);
            }
        } catch (Exception e) {
        }
    }

    public void LoadComboboxHangHoa() {
        try {
            String SQL = "SELECT *FROM HangHoa";
            SQLProvider data = new SQLProvider();
            data.open();

            DefaultComboBoxModel ccbmodelhh = new DefaultComboBoxModel();
            cbbhanghoa.setModel(ccbmodelhh);
            ResultSet rs = data.executeQuery(SQL);

            // Thêm các sản phẩm vào mô hình ComboBox và lưu trữ tên và khóa chính tương ứng vào Map
            while (rs.next()) {
                int id = rs.getInt(1);
                int sl = rs.getInt(6);
                String adu = String.valueOf(sl);
                String name = rs.getString(2);
                String aduvip = name + " | " + adu;
                itemhh.put(aduvip, id);
                ccbmodelhh.addElement(aduvip);
            }

            data.close();

        } catch (SQLException e) {
            System.out.println("LỗI: " + e.getMessage());
        }
    }

    private void InsertCTPhieuXuat() {
        String nhomHH = (String) cbbhanghoa.getSelectedItem();
        int manhomHH = itemhh.get(nhomHH);
        int soluong = Integer.parseInt(txtSoluongXuat.getText().trim());
        float gianhap = Float.parseFloat(txtGiaXuat.getText().trim());

        boolean KT = DAO_CTPhieuXuat.InsertCTPhieuXuat(manhomHH, soluong, gianhap, thanhtien);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Thêm thành công phiếu xuất");
        }
        tblModelCTPX.setRowCount(0);
        LoadTableCTPX();
        tblCTPhieuXuat.updateUI();
    }

    public void DeleteCTPhieuXuat() {

        int pos = tblCTPhieuXuat.getSelectedRow();
        int maHH = (int) tblCTPhieuXuat.getValueAt(pos, 0);

        boolean KT = DAO_CTPhieuXuat.DeleteCTPhieuXuat(maHH);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Xóa thành công phiếu xuất");
        }
        tblModelCTPX.setRowCount(0);
        LoadTableCTPX();
        tblCTPhieuXuat.updateUI();
    }

    private void UpdateCTPhieuXuat() {
        int pos = tblCTPhieuXuat.getSelectedRow();

        int maHH = (int) tblCTPhieuXuat.getValueAt(pos, 0);
        int soluong = Integer.parseInt(txtSoluongXuat.getText().trim());
        float giaxuat = Float.parseFloat(txtGiaXuat.getText().trim());

        boolean KT = DAO_CTPhieuXuat.UpdateCTPhieuXuat(maHH, soluong, giaxuat, thanhtien);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Sửa thành công phiếu xuất");
        }
        tblModelCTPX.setRowCount(0);
        LoadTableCTPX();
        tblCTPhieuXuat.updateUI();

    }

    private void PayCTPhieuXuat() {
        String lydo = txtLydoxuat.getText();
        String nhomKH = (String) cbbKhachHang.getSelectedItem();
        int manhomKH = items.get(nhomKH);
        float tongtien = 0;

        try {
            String sql = "Select *from CTPhieuXuat";
            SQLProvider sss = new SQLProvider();
            sss.open();
            ResultSet rs = sss.executeQuery(sql);
            while (rs.next()) {
                float value = rs.getFloat("Thanhtien");
                tongtien += value;
            }
        } catch (Exception e) {
        }

        if (JOptionPane.showConfirmDialog(this, "Bạn có xuất hàng hóa này cho khách hàng : " + cbbKhachHang.getSelectedItem() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            boolean KT = DAO_PhieuXuat.ThanhToanCTPhieuXuat(lydo, manhanvien, manhomKH, tongtien);
            if (KT) {
                JOptionPane.showMessageDialog(this, "Xuất hàng thành công");
                RemoveCTPhieuXuathadPay();
            }

        }

    }

    private void RemoveCTPhieuXuathadPay() {

        boolean KT = DAO_PhieuXuat.RemoveCTPhieuXuathadPay();
        if (KT) {
            JOptionPane.showMessageDialog(this, "Đã thêm vào phiếu xuất hàng");
        }

        tblModelCTPX.setRowCount(0);
        LoadTableCTPX();
        tblCTPhieuXuat.updateUI();

        tblModelPX.setRowCount(0);
        LoadTablePhieuXuat();
        tblPX.updateUI();
    }

    public boolean KT_TonTaiHangHoa(String mahh) {
        try {
            String sql = "Select * from CTPhieuXuat";
            SQLProvider kthh = new SQLProvider();
            kthh.open();
            ResultSet rs = kthh.executeQuery(sql);

            while (rs.next()) {
                int maloaihh = rs.getInt("MaHH");
                String maloaiHH = String.valueOf(maloaihh);
                if (mahh.equals(maloaiHH)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean KT_CTXuatEmpty() {
        if (tblCTPhieuXuat.getRowCount() == 0) {
            return false;
        }
        return true;
    }

    public void Duyet() {
        int pos = tblPX.getSelectedRow();
        textPX.setText("Mã phiếu xuất: " + tblModelPX.getValueAt(pos, 0) + "\n"
                + "Ngày xuất: " + tblModelPX.getValueAt(pos, 1) + "\n"
                + "Lý do xuất: " + tblModelPX.getValueAt(pos, 2) + "\n"
                + "Nhân viên xuất: " + tblModelPX.getValueAt(pos, 3) + "\n"
                + "Xuất cho KH: " + tblModelPX.getValueAt(pos, 4) + "\n"
                + "Tiền nhận: " + tblModelPX.getValueAt(pos, 5) + " VNĐ \n"
                + "Trạng thái: " + T + "\n"
        );
    }

    public void ChuaDuyet() {
        int pos = tblPX.getSelectedRow();
        textPX.setText("Mã phiếu xuất: " + tblModelPX.getValueAt(pos, 0) + "\n"
                + "Ngày xuất: " + tblModelPX.getValueAt(pos, 1) + "\n"
                + "Lý do xuất: " + tblModelPX.getValueAt(pos, 2) + "\n"
                + "Nhân viên xuất: " + tblModelPX.getValueAt(pos, 3) + "\n"
                + "Xuất cho KH: " + tblModelPX.getValueAt(pos, 4) + "\n"
                + "Tiền nhận: " + tblModelPX.getValueAt(pos, 5) + " VNĐ \n"
                + "Trạng thái: " + F + "\n"
        );
    }

    private void event() {
         ((AbstractDocument) txtSoluongXuat.getDocument()).setDocumentFilter(new NumberOnlyFilter());
        ((AbstractDocument) txtGiaXuat.getDocument()).setDocumentFilter(new NumberOnlyFilter());
    }

}
