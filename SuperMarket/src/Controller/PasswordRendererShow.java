/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import POJO.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class PasswordRendererShow extends DefaultTableCellRenderer {

  public PasswordRendererShow() {
    super();
  }

  public void setValue(Object value) {
    if (value == null) {
      setText("");
    } else {
      setText(value.toString());
    }
  }
}