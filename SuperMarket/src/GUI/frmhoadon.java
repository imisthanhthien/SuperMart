/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_HangHoa;
import POJO.CTHoaDon;
import POJO.HangHoa;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class frmhoadon extends javax.swing.JFrame {
private ArrayList<CTHoaDon> listCTHoaDon = null;
    private int tongTien;
    String KhachHang;
    String nhanVien;
    /**
     * Creates new form frmhoadon
     * @param KhachHang
     * @param nhanVien
     * @param listCTHoaDon
     */
    public frmhoadon(String KhachHang, String nhanVien, ArrayList<CTHoaDon> listCTHoaDon) {
        this.KhachHang = KhachHang;
        this.nhanVien = nhanVien;
        this.listCTHoaDon = listCTHoaDon;
        initComponents();
         setLocationRelativeTo(null);
         for (CTHoaDon cthd : this.listCTHoaDon) {
            this.tongTien += cthd.getThanhtien();
        }
           setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
     public frmhoadon() {
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnInPhieu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChiTiet = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(60, 45, 81));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("THÔNG TIN CHI TIẾT HÓA ĐƠN");
        jPanel1.add(jLabel1);

        jPanel2.setBackground(new java.awt.Color(60, 45, 81));

        btnXacNhan.setBackground(new java.awt.Color(255, 255, 102));
        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-paid-bill-35.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.setPreferredSize(new java.awt.Dimension(160, 40));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        jPanel2.add(btnXacNhan);

        btnInPhieu.setBackground(new java.awt.Color(255, 255, 102));
        btnInPhieu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInPhieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconButtom/icons8-printer-35.png"))); // NOI18N
        btnInPhieu.setText("In hóa đơn");
        btnInPhieu.setPreferredSize(new java.awt.Dimension(170, 40));
        btnInPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieuActionPerformed(evt);
            }
        });
        jPanel2.add(btnInPhieu);

        txtChiTiet.setEditable(false);
        jScrollPane1.setViewportView(txtChiTiet);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed

        btnXacNhan.setEnabled(false);
        btnInPhieu.setEnabled(true);

        BUS_HangHoa hhbus = new BUS_HangHoa();
        ArrayList<HangHoa> dssp = hhbus.getListSanPham();

        txtChiTiet.setContentType("text/html");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        DecimalFormat dcf = new DecimalFormat("###,### VNĐ");
        DecimalFormat dcfx = new DecimalFormat("#,###");

        String hd = "<style> "
        + "table {"
        + "border: 1px solid;"
        + "border-bottom: none"
        + "}"
        + "tr {"
        + "border-bottom: 1px solid;"
        + "}"
        + "td {"
        + "padding: 8px;"
        + "} "
        + "th {"
        + "font-size:16pt"
        + "}"
        + "</style>";
        hd +="<div style=\"text-align: right;\">";
        hd +=" <span style='font-size:10px;'>Nhóm 9 - Công nghệ java </span>";
        hd +="</div>";
        hd += "<h1 style='text-align:center;font-size:20px;'>HÓA ĐƠN THANH TOÁN</h1>";
        
        hd += " <div style=\"text-align: left;\">";
        hd += "  <span>Nhân viên nhập: </span>" + nhanVien+ "<br/>";
        hd += " <span>Ngày lập: </span>" + dtf.format(now) + "<br/>";
        hd += "<span>Lập cho khách hàng: </span>"+ KhachHang + "<br/>";
        hd += "  </div>";
        
        hd += "<div style='text-align:center;'>§========================================§</div><br/>";
        hd += "<div style='text-align:center'>";
        hd += "<table style='max-width:100%'>";
        hd += "<tr>"
        + "<th>Mã hàng</th>"
        + "<th>Tên hàng</th>"
        + "<th>Số lượng</th>"
        + "<th>Đơn giá</th>"
        + "<th>Thành tiền</th>"
        + "</tr>";
        for (CTHoaDon cthd : listCTHoaDon) {
            hd += "<tr>";
            hd += "<td style='text-align:center;'>" + cthd.getMaHH() + "</td>";
            for (HangHoa sp : dssp) {
                if (sp.getMaHH() == cthd.getMaHH()) {
                    hd += "<td style='text-align:left;'>" + sp.getTenHH() + "</td>";
                    break;
                }
            }
            hd += "<td style='text-align:left;'>" + cthd.getSoluong() + "</td>";
            hd += "<td style='text-align:left;'>" + dcfx.format(cthd.getGiaBan()) + "</td>";
            hd += "<td style='text-align:left;'>" + dcfx.format(cthd.getThanhtien()) + "</td>";
            hd += "</tr>";

        }

        hd += "<tr>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:left;'>" + "</td>";
        hd += "<td style='text-align:center;'>" + "</td>";
        hd += "<td style='text-align:center;font-weight:bold;'>Tổng tiền:</td>";
        hd += "<td style='text-align:center;font-size: 8px;'>" + dcf.format(tongTien) + "</td>";
        hd += "</tr>";
        hd += "</table>";
        hd += "</div>";
        hd += "<div style='text-align:center;'>§===============✶===============§</div><br/>";

        txtChiTiet.setText(hd);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnInPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieuActionPerformed
        try {
            txtChiTiet.print();
        } catch (PrinterException e) {
        }
        this.dispose();
    }//GEN-LAST:event_btnInPhieuActionPerformed

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
            java.util.logging.Logger.getLogger(frmhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmhoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInPhieu;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane txtChiTiet;
    // End of variables declaration//GEN-END:variables
}
