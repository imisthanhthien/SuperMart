/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DAO_HangHoa;
import POJO.HangHoa;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public final class BUS_HangHoa {
    private ArrayList<HangHoa> listSanPham = null;
    private DAO_HangHoa spDAO = new DAO_HangHoa();

    public BUS_HangHoa() {
        docListSanPham();
    }

    public void docListSanPham() {
        listSanPham = spDAO.DS_HangHoax();
    }

    public ArrayList<HangHoa> getListSanPham() {
        if (listSanPham == null) {
            docListSanPham();
        }
        return listSanPham;
    }

    public HangHoa getSanPham(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maSP = Integer.parseInt(ma);
                for (HangHoa sp : listSanPham) {
                    if (sp.getMaHH() == maSP) {
                        return sp;
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }


}
