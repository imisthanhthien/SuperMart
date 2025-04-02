package splashscreen;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NGUYEN THANH THIEN
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicLabelUI;

public class ShadowLabelUI extends BasicLabelUI {
    
    private Color shadowColor;
    private int shadowOffsetX;
    private int shadowOffsetY;
    
    public ShadowLabelUI(Color shadowColor, int shadowOffsetX, int shadowOffsetY) {
        super();
        this.shadowColor = shadowColor;
        this.shadowOffsetX = shadowOffsetX;
        this.shadowOffsetY = shadowOffsetY;
    }
    
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        JLabel label = (JLabel) c;
        String text = label.getText();
        int x = label.getInsets().left;
        int y = label.getInsets().top + label.getFontMetrics(label.getFont()).getAscent();
        
        g2d.setColor(shadowColor);
        g2d.drawString(text, x + shadowOffsetX, y + shadowOffsetY);
        
        g2d.setColor(label.getForeground());
        g2d.drawString(text, x, y);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("ShadowLabelUI Example");
        JPanel panel = new JPanel();
        
        ShadowLabelUI labelUI = new ShadowLabelUI(Color.GRAY, 2, 2);
        JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);
        label.setUI(labelUI);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 24));
        panel.add(label);
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
