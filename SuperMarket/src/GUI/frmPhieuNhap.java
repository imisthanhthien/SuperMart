/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Controller.NumberOnlyFilter;
import DAO.DAO_CTPhieuNhap;
import DAO.DAO_PhieuNhap;
import DAO.SQLProvider;
import POJO.CTPhieuNhap;
import POJO.HangHoa;
import POJO.KhachHang;
import POJO.NhaCungCap;
import POJO.NhanVien;
import POJO.PhieuNhap;
import java.awt.Color;
import java.awt.Font;
import java.sql.CallableStatement;
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
public final class frmPhieuNhap extends javax.swing.JFrame {
    String T = "Đã giao";
    String F = "Chưa giao";
    DecimalFormat dfpn = new DecimalFormat("#,###");
    DecimalFormat df = new DecimalFormat("#.###");
    Map< String, Integer> items = new HashMap<>();
    Map< String, Integer> itemhh = new HashMap<>();
    String emailnhap;
    float thanhtien = 0;
    PhieuNhap pn = new PhieuNhap();

    Vector<String> headerPN = new Vector<>();
    Vector dataPN = new Vector();
    DefaultTableModel tblModelPN = new DefaultTableModel();

    Vector<String> headerCTPN = new Vector<>();
    Vector dataCTPN = new Vector();
    DefaultTableModel tblModelCTPN = new DefaultTableModel();

    int manhanvien;
    String tennhanvien;
    int vaitro;
    NhanVien nv = new NhanVien();
    NhaCungCap ncc = new NhaCungCap();
    KhachHang kh = new KhachHang();
    HangHoa hh = new HangHoa();
    CTPhieuNhap ctpn = new CTPhieuNhap();
    

    /**
     * Creates new form frmPhieuNhap
     *
     * @param manv
     * @param tennv
     * @param vaitro
     */
    public frmPhieuNhap(int manv, String tennv, int vaitro) {
        this.manhanvien = manv;
        this.tennhanvien = tennv;
        this.vaitro = vaitro;
        initComponents();
        setLocationRelativeTo(null);
        LoadComboboxNhaCungCap();
        LoadComboboxHangHoa();

        //Phiếu nhập
        tblModelPN = (DefaultTableModel) this.tblPN.getModel();
        headerPN.add("MÃ PN");
        headerPN.add("NGÀY NHẬP");
        headerPN.add("LÝ DO NHẬP");
        headerPN.add("NHÂN VIÊN LẬP");
        headerPN.add("NHÀ CUNG CẤP");
        headerPN.add("TỔNG TIỀN");
        tblModelPN.setDataVector(dataPN, headerPN);
        LoadTablePhieuNhap();

        TableColumnModel columnModel = tblPN.getColumnModel();
        TableColumn column = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);
        TableColumn column2 = columnModel.getColumn(2);
        TableColumn column3 = columnModel.getColumn(3);
        TableColumn column4 = columnModel.getColumn(4);
        TableColumn column5 = columnModel.getColumn(5);
        column.setPreferredWidth(5);
        column1.setPreferredWidth(5);
        column2.setPreferredWidth(5);
        column3.setPreferredWidth(50);
        column4.setPreferredWidth(100);
        column5.setPreferredWidth(12);

        TableCellRenderer rendererFromHeader = tblPN.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        tblPN.getTableHeader().setDefaultRenderer(rendererFromHeader);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // tạo renderer
        renderer.setHorizontalAlignment(JLabel.CENTER); // thiết lập căn giữa cho dòng
        for (int i = 0; i < tblPN.getColumnCount(); i++) {
            tblPN.getColumnModel().getColumn(i).setCellRenderer(renderer); // sử dụng renderer cho tất cả các cột
        }

        tblPN.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tblPN.getTableHeader().setOpaque(false);
        tblPN.getTableHeader().setBackground(new Color(32, 136, 203));
        tblPN.getTableHeader().setForeground(new Color(0, 0, 0));
        tblPN.setRowHeight(25);

        //Chi tiêt Phiếu nhập
        tblModelCTPN = (DefaultTableModel) this.tblCTPhieuNhap.getModel();
        headerCTPN.add("MÃ HÀNG");
        headerCTPN.add("TÊN HÀNG HÓA");
        headerCTPN.add("SỐ LƯỢNG");
        headerCTPN.add("ĐƠN GIÁ");
        headerCTPN.add("THÀNH TIỀN");
        tblModelCTPN.setDataVector(dataCTPN, headerCTPN);
        LoadTableCTPhieuNhap();

        tblCTPhieuNhap.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));
        tblCTPhieuNhap.getTableHeader().setOpaque(false);
        tblCTPhieuNhap.getTableHeader().setBackground(new Color(32, 136, 203));
        tblCTPhieuNhap.getTableHeader().setForeground(new Color(0, 0, 0));
        tblCTPhieuNhap.setRowHeight(25);

        txtMaNV.setText("" + manv + " | " + tennv.toUpperCase());
        txtNgayNhap.setText("" + java.time.LocalDate.now());
        
        
        textPN.setText("Mã phiếu nhập:  @mapn?" + "\n"
                + "Ngày lập: @ngaylap?"+ "\n"
                 + "Lý do: @lydo?"+ "\n"
                 + "Nhân viên lập: @nhanvienlap?"+ "\n"
                 + "Nhà cung cấp hàng: @nhacungcap?"+ "\n"
                 + "Tiền thanh toán: @tien?"+ "\n"
                 + "Trạng thái: @trang thai?"+ "\n"
        );
        
        buttonGroup1.add(checkGHF);
         buttonGroup1.add(checkGHT);
        if(vaitro == 0)
        {
            checkGHF.hide();
            checkGHT.hide();
            textPN.setSize(259, 239);
        }
        else
        {
            checkGHF.show();
            checkGHT.show();
        }
        
        event();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            
    }

    public frmPhieuNhap() {
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
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLydoNhap = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbbNCC = new javax.swing.JComboBox<>();
        txtMaNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSoLuongNhap = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        cbbhanghoa = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        btn_in = new javax.swing.JButton();
        btnLamMoiPV = new javax.swing.JButton();
        btnThemPN = new javax.swing.JButton();
        btnXoaPN = new javax.swing.JButton();
        btnSuaPN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTPhieuNhap = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPN = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPN = new javax.swing.JTextPane();
        checkGHF = new javax.swing.JCheckBox();
        checkGHT = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(60, 45, 81));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 760));

        jPanel4.setBackground(new java.awt.Color(60, 45, 81));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN PHIẾU NHẬP HÀNG", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(360, 450));
        jPanel4.setRequestFocusEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ngày nhập:");

        txtNgayNhap.setEditable(false);
        txtNgayNhap.setBackground(new java.awt.Color(252, 218, 209));
        txtNgayNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayNhap.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lý do nhập:");

        txtLydoNhap.setBackground(new java.awt.Color(252, 218, 209));
        txtLydoNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 204));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("NCC:");

        cbbNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMaNV.setEditable(false);
        txtMaNV.setBackground(new java.awt.Color(252, 218, 209));
        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtMaNV.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mã NV|Tên NV:");

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-import-50.png"))); // NOI18N
        jButton1.setText("NHẬP HÀNG");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Số lượng nhập:");

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Hàng hóa:");

        txtSoLuongNhap.setBackground(new java.awt.Color(252, 218, 209));
        txtSoLuongNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSoLuongNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongNhapKeyReleased(evt);
            }
        });

        txtGiaNhap.setBackground(new java.awt.Color(252, 218, 209));
        txtGiaNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiaNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtGiaNhapMouseExited(evt);
            }
        });
        txtGiaNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiaNhapKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaNhapKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 204));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Thành tiền:");

        txtThanhTien.setEditable(false);
        txtThanhTien.setBackground(new java.awt.Color(252, 218, 209));
        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtThanhTien.setEnabled(false);

        cbbhanghoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbhanghoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 204));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Giá nhập:");

        btn_in.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-bill-30.png"))); // NOI18N
        btn_in.setText("Lưu phiếu");
        btn_in.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(txtGiaNhap)
                                            .addComponent(txtThanhTien))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtLydoNhap, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbNCC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(cbbhanghoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(btn_in)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbbhanghoa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLydoNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btn_in))
                .addContainerGap())
        );

        btnLamMoiPV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoiPV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-new-copy-50.png"))); // NOI18N
        btnLamMoiPV.setText(" THÊM MỚI");
        btnLamMoiPV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoiPV.setPreferredSize(new java.awt.Dimension(190, 57));
        btnLamMoiPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiPVActionPerformed(evt);
            }
        });

        btnThemPN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-paid-bill-50.png"))); // NOI18N
        btnThemPN.setText("LƯU PHIẾU");
        btnThemPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemPN.setPreferredSize(new java.awt.Dimension(190, 57));
        btnThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPNActionPerformed(evt);
            }
        });

        btnXoaPN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-agreement-delete-50.png"))); // NOI18N
        btnXoaPN.setText("XÓA PHIẾU");
        btnXoaPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaPN.setPreferredSize(new java.awt.Dimension(190, 57));
        btnXoaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPNActionPerformed(evt);
            }
        });

        btnSuaPN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaPN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-renew-50.png"))); // NOI18N
        btnSuaPN.setText("SỬA PHIẾU");
        btnSuaPN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPNActionPerformed(evt);
            }
        });

        tblCTPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCTPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCTPhieuNhap.setFillsViewportHeight(true);
        tblCTPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTPhieuNhap);

        tblPN.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblPN.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPN.setFillsViewportHeight(true);
        tblPN.setFocusable(false);
        tblPN.setRowHeight(25);
        tblPN.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblPN.getTableHeader().setReorderingAllowed(false);
        tblPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPNMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPN);

        textPN.setEditable(false);
        textPN.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jScrollPane2.setViewportView(textPN);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );

        checkGHF.setForeground(new java.awt.Color(255, 255, 0));
        checkGHF.setText("Chưa giao");
        checkGHF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGHFActionPerformed(evt);
            }
        });

        checkGHT.setForeground(new java.awt.Color(255, 255, 0));
        checkGHT.setText("Đã giao");
        checkGHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGHTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnThemPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLamMoiPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSuaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkGHF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(checkGHT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLamMoiPV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkGHF)
                            .addComponent(checkGHT))
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPNMouseClicked
        // TODO add your handling code here:
        int pos = tblPN.getSelectedRow();
        
        int maphieu = (int) tblPN.getValueAt(pos, 0);
        try {
            String sql = "select *from PhieuNhap where MaPN = " + maphieu;
            SQLProvider kttt = new SQLProvider();
            kttt.open();
            ResultSet rskt = kttt.executeQuery(sql);
            if (rskt.next()) {
                if (rskt.getInt("TrangThai") == 0) {
                    textPN.setText("Mã phiếu nhập: " + tblModelPN.getValueAt(pos, 0) + "\n"
                            + "Ngày lập: " + tblModelPN.getValueAt(pos, 1) + "\n"
                            + "Lý do: " + tblModelPN.getValueAt(pos, 2) + "\n"
                            + "Nhân viên lập: " + tblModelPN.getValueAt(pos, 3) + "\n"
                            + "Nhà cung cấp hàng: " + tblModelPN.getValueAt(pos, 4) + "\n"
                            + "Tiền thanh toán: " + tblModelPN.getValueAt(pos, 5) + " VNĐ \n"
                            + "Trạng thái: " + F + "\n"
                    
                    );
                    buttonGroup1.clearSelection();
                    checkGHF.setSelected(true);
                    
                }
                else
                {
                    
                    textPN.setText("Mã phiếu nhập: " + tblModelPN.getValueAt(pos, 0) + "\n"
                            + "Ngày lập: " + tblModelPN.getValueAt(pos, 1) + "\n"
                            + "Lý do: " + tblModelPN.getValueAt(pos, 2) + "\n"
                            + "Nhân viên lập: " + tblModelPN.getValueAt(pos, 3) + "\n"
                            + "Nhà cung cấp hàng: " + tblModelPN.getValueAt(pos, 4) + "\n"
                            + "Tiền thanh toán: " + tblModelPN.getValueAt(pos, 5) + " VNĐ \n"
                            + "Trạng thái: " + T + "\n"
                    );
                    buttonGroup1.clearSelection();
                    checkGHT.setSelected(true);
                    
                }

            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblPNMouseClicked

    private void btnLamMoiPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiPVActionPerformed
        // TODO add your handling code here:
//        this.txtPN.setText("");
        this.txtSoLuongNhap.setText("");
        this.txtThanhTien.setText("");
        this.txtGiaNhap.setText("");
        this.txtLydoNhap.setText("");

        this.txtSoLuongNhap.requestFocus();
    }//GEN-LAST:event_btnLamMoiPVActionPerformed

    private void tblCTPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhieuNhapMouseClicked
        // TODO add your handling code here:
        try {
            int pos = tblCTPhieuNhap.getSelectedRow();

            this.cbbhanghoa.setSelectedItem((String) (tblCTPhieuNhap.getValueAt(pos, 1)));
            this.txtSoLuongNhap.setText("" + tblModelCTPN.getValueAt(pos, 2));
            this.txtGiaNhap.setText("" + tblModelCTPN.getValueAt(pos, 3));
            this.txtThanhTien.setText("" + tblModelCTPN.getValueAt(pos, 4));
        } catch (Exception e) {
        }

    }//GEN-LAST:event_tblCTPhieuNhapMouseClicked

    private void btnThemPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPNActionPerformed
        // TODO add your handling code here:
        String soluong = txtSoLuongNhap.getText();
        String giaban = txtGiaNhap.getText();
        String nhomHH = (String) cbbhanghoa.getSelectedItem();

        int manhomHH = itemhh.get(nhomHH);
        String mahh = String.valueOf(manhomHH);
        if (soluong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập số lượng!!!");
        } else if (giaban.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập giá!!!");
        } else if (KT_TonTaiHangHoa(mahh)) {
            JOptionPane.showMessageDialog(this, "Mặt hàng nhập đã có, vui lòng (tăng - giảm) số lượng hoặc chọn mặt hàng khác!!!");
        } else {

            InsertCTPhieuNhap();
            cbbhanghoa.removeAllItems();
            LoadComboboxHangHoa();

        }

    }//GEN-LAST:event_btnThemPNActionPerformed

    private void btnXoaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPNActionPerformed
        // TODO add your handling code here:
        int pos = tblCTPhieuNhap.getSelectedRow();
        try {
            if (pos < 0) {
                JOptionPane.showMessageDialog(this, "Chưa chọn hàng hóa cần xóa trên bảng, vui lòng thử lại!!!");
            } else {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa phiếu này không", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.DeleteCTPhieuNhap();
                    cbbhanghoa.removeAllItems();
                    LoadComboboxHangHoa();
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnXoaPNActionPerformed

    private void btnSuaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPNActionPerformed
        // TODO add your handling code here:

        int pos = tblCTPhieuNhap.getSelectedRow();
        try {
            if (pos < 0) {
                JOptionPane.showMessageDialog(this, "Chưa chọn mặt hàng cần sửa!!!");
            } else {
                this.UpdateCTPhieuNhap();
                cbbhanghoa.removeAllItems();
                LoadComboboxHangHoa();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnSuaPNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (KT_CTNhapEmpty()) {
                PayCTPhieuNhap();

            } else {
                JOptionPane.showMessageDialog(this, "Không có đơn hàng nào để nhập!!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtGiaNhapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGiaNhapMouseExited

    }//GEN-LAST:event_txtGiaNhapMouseExited

    private void txtGiaNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaNhapKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:

    }//GEN-LAST:event_txtGiaNhapKeyPressed

    private void txtGiaNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaNhapKeyReleased
        // TODO add your handling code here:
        try {
            int soluong = Integer.parseInt(txtSoLuongNhap.getText());
            float gianhap = Float.parseFloat(txtGiaNhap.getText());

            if (txtSoLuongNhap.getText().equals("")) {

            } else {
                double tt = soluong * gianhap;
                
                txtThanhTien.setText("" + df.format(tt));
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtGiaNhapKeyReleased

    private void txtSoLuongNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongNhapKeyReleased
        // TODO add your handling code here:

        try {
            int soluong = Integer.parseInt(txtSoLuongNhap.getText());
            float gianhap = Float.parseFloat(txtGiaNhap.getText());
            if (txtGiaNhap.getText().equals("")) {

            } else {
                double tt = soluong * gianhap;
               
                txtThanhTien.setText("" +  df.format(tt));
            }

        } catch (NumberFormatException e) {
        }


    }//GEN-LAST:event_txtSoLuongNhapKeyReleased

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_BanHang";
    String user = "sa";
    String pass = "123";
    Statement st;
    ResultSet rs;
    private void btn_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inActionPerformed
        // TODO add your handling code here:
            ArrayList<CTPhieuNhap> lisst = DAO_CTPhieuNhap.DS_CTPhieuNHap();
            String nhacungcap = (String) cbbNCC.getSelectedItem();
            
            frmnhap nhaphang = new frmnhap(nhacungcap,tennhanvien,lisst);
            nhaphang.setVisible(true);
    }//GEN-LAST:event_btn_inActionPerformed

    private void checkGHFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGHFActionPerformed
        // TODO add your handling code here:
        int pos = tblPN.getSelectedRow();
        int maphieu = (int) tblPN.getValueAt(pos, 0);
        int rootTrangThai;
        if(checkGHF.isSelected())
        {
            rootTrangThai = 0;
        }
        else
        {
            rootTrangThai = 1;
        }
        
        boolean KT = DAO_PhieuNhap.UpdateTrangThai(maphieu, rootTrangThai);
                    if(KT)
                    {
                        JOptionPane.showMessageDialog(this, "Đã cập nhập trạng thái thành công");
                        ChuaDuyet();
                    }
    }//GEN-LAST:event_checkGHFActionPerformed

    private void checkGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGHTActionPerformed
        // TODO add your handling code here:
         int pos = tblPN.getSelectedRow();
        int maphieu = (int) tblPN.getValueAt(pos, 0);
        int rootTrangThai;
        if(checkGHF.isSelected())
        {
            rootTrangThai = 0;
        }
        else
        {
            rootTrangThai = 1;
        }
        
        boolean KT = DAO_PhieuNhap.UpdateTrangThai(maphieu, rootTrangThai);
                    if(KT)
                    {
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
            java.util.logging.Logger.getLogger(frmPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiPV;
    private javax.swing.JButton btnSuaPN;
    private javax.swing.JButton btnThemPN;
    private javax.swing.JButton btnXoaPN;
    private javax.swing.JButton btn_in;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbNCC;
    private javax.swing.JComboBox<String> cbbhanghoa;
    private javax.swing.JCheckBox checkGHF;
    private javax.swing.JCheckBox checkGHT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblCTPhieuNhap;
    private javax.swing.JTable tblPN;
    private javax.swing.JTextPane textPN;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtLydoNhap;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables

    private void LoadTablePhieuNhap() {
        try {
            SQLProvider data = new SQLProvider();
            data.open();
            CallableStatement cs = (data.getConnection()).prepareCall("{call DS_Nhap()}");
            cs.execute();

            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Vector v = new Vector();

                pn.setMaPN(rs.getInt(1));
                pn.setNgayNhap(rs.getString(2));
                pn.setLydoNhap(rs.getString(3));
                nv.setTenNV(rs.getString(4));
                ncc.setTenNCC(rs.getString(5));
                pn.setThanhtien(rs.getFloat(6));

                v.add(pn.getMaPN());
                v.add(pn.getNgayNhap());
                v.add(pn.getLydoNhap());
                v.add(nv.getTenNV());
                v.add(ncc.getTenNCC());
                v.add(dfpn.format(pn.getThanhtien()));

                dataPN.add(v);
            }
        } catch (Exception e) {
        }

    }

    private void LoadComboboxNhaCungCap() {
        try {
            String SQL = "SELECT *FROM NhaCungCap";
            SQLProvider data = new SQLProvider();
            data.open();

            DefaultComboBoxModel ccbmodel = new DefaultComboBoxModel();
            cbbNCC.setModel(ccbmodel);
            ResultSet rs = data.executeQuery(SQL);

            // Thêm các sản phẩm vào mô hình ComboBox và lưu trữ tên và khóa chính tương ứng vào Map
            while (rs.next()) {
                int id = rs.getInt("MaNCC");
                String name = rs.getString("TenNCC");
                items.put(name, id);
                ccbmodel.addElement(name);
            }

            data.close();
        } catch (SQLException e) {
            System.out.println("LỗI: " + e.getMessage());
        }
    }

    private void LoadTableCTPhieuNhap() {
        try {
            SQLProvider data = new SQLProvider();
            data.open();
            CallableStatement cs = (data.getConnection()).prepareCall("{call LoadCTPhieuNHap()}");
            cs.execute();

            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Vector v = new Vector();

                hh.setMaHH(rs.getInt(1));
                hh.setTenHH(rs.getString(2));
                ctpn.setSoluongNhap(rs.getInt(3));
                ctpn.setGiaNhap(rs.getFloat(4));
                ctpn.setThanhtien(rs.getFloat(5));

                v.add(hh.getMaHH());
                v.add(hh.getTenHH());
                v.add(ctpn.getSoluongNhap());
                v.add(df.format(ctpn.getGiaNhap()));
                v.add(df.format(ctpn.getThanhtien()));

                dataCTPN.add(v);
            }
        } catch (Exception e) {
        }
    }

    private void UpdateCTPhieuNhap() {
        int pos = tblCTPhieuNhap.getSelectedRow();
        int maHH = (int) tblCTPhieuNhap.getValueAt(pos, 0);
        int soluong = Integer.parseInt(txtSoLuongNhap.getText().trim());
        float gianhap = Float.parseFloat(txtGiaNhap.getText().trim());

        boolean KT = DAO.DAO_CTPhieuNhap.UpdateCTPhieuNhap(maHH, soluong, gianhap, thanhtien);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Sửa thành công phiếu nhập ");
        }
        tblModelCTPN.setRowCount(0);
        LoadTableCTPhieuNhap();
        tblCTPhieuNhap.updateUI();

    }

    public void DeleteCTPhieuNhap() {

        int pos = tblCTPhieuNhap.getSelectedRow();
        int maHH = (int) tblCTPhieuNhap.getValueAt(pos, 0);
        boolean KT = DAO.DAO_CTPhieuNhap.DeleteCTPhieuNhap(maHH);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Xóa thành công phiếu nhập ");
        }
        tblModelCTPN.setRowCount(0);
        LoadTableCTPhieuNhap();
        tblCTPhieuNhap.updateUI();

    }

    private void InsertCTPhieuNhap() {
        String nhomHH = (String) cbbhanghoa.getSelectedItem();
        int manhomHH = itemhh.get(nhomHH);
        int soluong = Integer.parseInt(txtSoLuongNhap.getText().trim());
        float gianhap = Float.parseFloat(txtGiaNhap.getText().trim());

        boolean KT = DAO.DAO_CTPhieuNhap.InsertCTPhieuNhap(manhomHH, soluong, gianhap, thanhtien);
        if (KT) {
            JOptionPane.showMessageDialog(this, "Thêm thành công phiếu nhập ");
        }
        tblModelCTPN.setRowCount(0);
        LoadTableCTPhieuNhap();
        tblCTPhieuNhap.updateUI();
    }

    public void LoadComboboxHangHoa() {
        try {

            String SQL = "SELECT *FROM HangHoa";
            SQLProvider data = new SQLProvider();
            data.open();
            DefaultComboBoxModel ccbmodelhh = new DefaultComboBoxModel();
            cbbhanghoa.setModel(ccbmodelhh);
            ResultSet rs = data.executeQuery(SQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                int sl = rs.getInt(6);
                String adu = String.valueOf(sl);
                String name = rs.getString(2);
                String aduvip = name + " | " + adu;
                itemhh.put(aduvip, id);

                ccbmodelhh.addElement(aduvip);

//                ccbmodelhh.addElement(name);
            }

            data.close();

        } catch (SQLException e) {
            System.out.println("LỗI: " + e.getMessage());
        }
    }

    private void PayCTPhieuNhap() {
        String lydo = txtLydoNhap.getText();
        String nhomNCC = (String) cbbNCC.getSelectedItem();
        int manhomNCC = items.get(nhomNCC);
        float tongtien = 0;

        try {
            String sql = "Select *from CTPhieuNhap";
            SQLProvider sss = new SQLProvider();
            sss.open();
            ResultSet rs = sss.executeQuery(sql);
            while (rs.next()) {
                float value = rs.getFloat("Thanhtien");
                tongtien += value;
            }
        } catch (Exception e) {
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có nhập hàng hóa này từ nhà cung cấp : " + cbbNCC.getSelectedItem() + " không?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            boolean KT = DAO.DAO_PhieuNhap.ThanhToanCTPhieuNhap(lydo, manhanvien, manhomNCC, tongtien);
            if (KT) {
                JOptionPane.showMessageDialog(this, "Nhập hàng thành công");
                RemoveCTPhieuNhaphadPay();
            }

        }

    }

    private void RemoveCTPhieuNhaphadPay() {

        boolean KT = DAO.DAO_PhieuNhap.RemoveCTPhieuNhaphadPay();
        if (KT) {
            JOptionPane.showMessageDialog(this, "Đã thêm vào phiếu nhập hàng");
        }
        tblModelCTPN.setRowCount(0);
        LoadTableCTPhieuNhap();
        tblCTPhieuNhap.updateUI();

        tblModelPN.setRowCount(0);
        LoadTablePhieuNhap();
        tblPN.updateUI();
    }

    public boolean KT_TonTaiHangHoa(String mahh) {
        try {
            String sql = "Select * from CTPhieuNhap";
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

    public boolean KT_CTNhapEmpty() {
        if (tblCTPhieuNhap.getRowCount() == 0) {
            return false;
        }
        return true;
    }
    public void Duyet() {
        int pos = tblPN.getSelectedRow();
        textPN.setText("Mã phiếu nhập: " + tblModelPN.getValueAt(pos, 0) + "\n"
                + "Ngày lập: " + tblModelPN.getValueAt(pos, 1) + "\n"
                + "Lý do: " + tblModelPN.getValueAt(pos, 2) + "\n"
                + "Nhân viên lập: " + tblModelPN.getValueAt(pos, 3) + "\n"
                + "Nhà cung cấp hàng: " + tblModelPN.getValueAt(pos, 4) + "\n"
                + "Tiền thanh toán: " + tblModelPN.getValueAt(pos, 5) + " VNĐ \n"
                + "Trạng thái: " + T + "\n"
        );
    }
     public void ChuaDuyet() {
        int pos = tblPN.getSelectedRow();
        textPN.setText("Mã phiếu nhập: " + tblModelPN.getValueAt(pos, 0) + "\n"
                + "Ngày lập: " + tblModelPN.getValueAt(pos, 1) + "\n"
                + "Lý do: " + tblModelPN.getValueAt(pos, 2) + "\n"
                + "Nhân viên lập: " + tblModelPN.getValueAt(pos, 3) + "\n"
                + "Nhà cung cấp hàng: " + tblModelPN.getValueAt(pos, 4) + "\n"
                + "Tiền thanh toán: " + tblModelPN.getValueAt(pos, 5) + " VNĐ \n"
                + "Trạng thái: " + F + "\n"
        );
    }

    private void event() {
        ((AbstractDocument) txtSoLuongNhap.getDocument()).setDocumentFilter(new NumberOnlyFilter());
        ((AbstractDocument) txtGiaNhap.getDocument()).setDocumentFilter(new NumberOnlyFilter());
    }

}
