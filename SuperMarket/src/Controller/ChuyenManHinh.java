/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import JPN.jpnHangHoa;
import JPN.jpnHoaDon;
import JPN.jpnKhachHang;
import JPN.jpnNhaCungCap;
import JPN.jpnNhanVien;
import JPN.jpnThongKe;
import JPN.jpnTrangChu;
import ListProduct.DanhMucHangHoa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author NGUYEN THANH THIEN
 */
public final class ChuyenManHinh {

    
    
    private JPanel root;
    private String loaiChon = "";
    String tennv;
    int manhanvien;
    int vaitro;
    
   
    private List<DanhMucHangHoa> listItem = null;

    
    public ChuyenManHinh(JPanel root, String tennv, int manhanvien) {
        this.root = root;
        this.tennv = tennv;
        this.manhanvien = manhanvien;
    }

    public ChuyenManHinh(String tennv, int manhanvien, int vaitro) {
        this.tennv = tennv;
        this.manhanvien = manhanvien;
        this.vaitro = vaitro;
    }
    


    

    public ChuyenManHinh() {
    }
   
    String driver  = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_BanHang";
    String user = "sa";
    String pass = "123";
    Statement st ;
    ResultSet rs;

    public void setView(JPanel jpnItem, JLabel jlbItem) throws IOException {
        loaiChon = "Trangchu";
        jpnItem.setBackground(new Color(255,255,0));
        jlbItem.setBackground(new Color(255,255,0));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new jpnTrangChu());
        root.validate();
        root.repaint();
        
    }
    
    


    public void setEvent(List<DanhMucHangHoa> listItem) {
        this.listItem = listItem;

        for (DanhMucHangHoa item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getLoai(), item.getJpn(), item.getJlb()));

        }

    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String loai;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String loai, JPanel jpnItem, JLabel jlbItem) {
            this.loai = loai;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (loai) {
                case "Trangchu":
                {
                    try {
                        node = new jpnTrangChu();
                    } catch (IOException ex) {
                        Logger.getLogger(ChuyenManHinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "Hanghoa":
                    node = new jpnHangHoa();
                    break;
                case "Nhanvien":
                    node = new jpnNhanVien();
                    break;
                case "Thongke":
                    node = new jpnThongKe();
                    break;                  
                case "Nhacungcap":
                    node = new jpnNhaCungCap(tennv, manhanvien,vaitro);
                    break;
                case "Hoadon":
                    node = new jpnHoaDon(tennv, manhanvien);
                    break;
                case "Khachhang":
                    node = new jpnKhachHang();
                    break;
                
                default:
                    throw new AssertionError();
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackGround(loai);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            loaiChon = loai;
            jpnItem.setBackground(new Color(255,255,0));
            jlbItem.setBackground(new Color(255,255,0));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(255,255,0));
            jlbItem.setBackground(new Color(255,255,0));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!loaiChon.equalsIgnoreCase(loai)) {
                jpnItem.setBackground(new Color(213,234,255));
                jlbItem.setBackground(new Color(213,234,255));
            }
        }

        private void setChangeBackGround(String loai) {
            for (DanhMucHangHoa item : listItem) {
                if (item.getLoai().equalsIgnoreCase(loai)) {
                    item.getJlb().setBackground(new Color(255,255,0));
                    item.getJpn().setBackground(new Color(255,255,0));
                } else {
                    item.getJlb().setBackground(new Color(213,234,255));
                    item.getJpn().setBackground(new Color(213,234,255));
                }
            }
        }
        

    }

}
