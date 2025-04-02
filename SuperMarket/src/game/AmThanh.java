package game;

import java.awt.Frame;
import javax.swing.JOptionPane;

public class AmThanh {

    static Thread chaynhac;

    public void playSound() {
        chaynhac = new Thread(new Runnable() {
            @Override
            public void run() {
// TODO Auto-generated method stub
                try {
                } catch (Exception e) {
                    System.out.println(e);
                }
// còn đây là code phát nhạc
            }
        });

    }

    public static void main(String[] args) {

        Frame frame = new Frame();
        Object[] options = {"OK, Tiếp Tục, please",
            "No, Thoát Game", "Cancel"};
        int n = JOptionPane.showOptionDialog(frame,
                "TRÒ CHƠI KẾT THÚC BẠN THẮNG, BẠN CÓ MUỐN TIẾP TỤC ", "A Silly Question",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

    }
}
