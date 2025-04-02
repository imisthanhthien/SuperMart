/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DieuKhienLuotDanh_ver_end {

    int SONGUOICHOI;
    int nguoiDanhOViTriHienTai;
    boolean[] khoaLuotPlayer;
    ArrayList dayluottiep = new ArrayList();
    String chieucualuot;

    public DieuKhienLuotDanh_ver_end(int soNguoiChoi,
            int nguoiDanhOViTriHienTai, boolean[] khoaLuotPlayer, String chieucualuot) {
        this.chieucualuot = chieucualuot;
        Scanner sc = new Scanner(System.in);
        this.khoaLuotPlayer = khoaLuotPlayer;
        this.SONGUOICHOI = soNguoiChoi;
        this.nguoiDanhOViTriHienTai = nguoiDanhOViTriHienTai;

        if (chieucualuot.equals("cungchieu")) {
            for (int i = nguoiDanhOViTriHienTai + 1; i <= nguoiDanhOViTriHienTai + soNguoiChoi; i++) {
                tinhDayLuot(i);
            }
        } else {
            for (int i = nguoiDanhOViTriHienTai + soNguoiChoi - 1; i >= nguoiDanhOViTriHienTai + 1; i--) {
                tinhDayLuot(i);
            }
        }
        //////System.out.println("\n");
        /*  for(int i=0;i<dayluottiep.size();i++)
        {
     System.out.println("Dãy lượt khả dụng sau người có index "+nguoiDanhOViTriHienTai+" là "+dayluottiep.get(i));
        }*/

    }

    public void tinhDayLuot(int i) {
        if (i % SONGUOICHOI == 0) {
            dayluottiep.add(String.valueOf(SONGUOICHOI));

        } else if (i > SONGUOICHOI) {
            dayluottiep.add(String.valueOf(i % SONGUOICHOI));
        } else {
            dayluottiep.add(String.valueOf(i));
        }
    }

    public int nguoiDanhTiepTheoOViTri() {
        int i = nguoiDanhOViTriHienTai;
        for (int j = 0; j < dayluottiep.size(); j++) {
            if (khoaLuotPlayer[Integer.parseInt(dayluottiep.get(j).toString())] == false) {
                return Integer.parseInt(dayluottiep.get(j).toString());
            }
        }
        return i;
    }

}
