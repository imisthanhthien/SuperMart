/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class PasswordRenderer extends DefaultTableCellRenderer {

  public PasswordRenderer() {
    super();
  }

  public void setValue(Object value) {
    if (value == null) {
      setText("");
    } else {
      setText("******");
    }
  }
}