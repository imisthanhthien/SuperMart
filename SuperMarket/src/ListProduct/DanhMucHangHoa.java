/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListProduct;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class DanhMucHangHoa {
    private String loai;
    private JPanel jpn;
    private JLabel jlb;

    public DanhMucHangHoa(String loai, JPanel jpn, JLabel jln) {
        this.loai = loai;
        this.jpn = jpn;
        this.jlb = jln;
    }
    public DanhMucHangHoa() {
    }
    
    public String getLoai() {
        return loai;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public void setJlb(JLabel jln) {
        this.jlb = jln;
    }
    
    
   
}
