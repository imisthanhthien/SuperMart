/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class NumberOnlyFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
      // Chỉ cho phép nhập số.
      for (int i = 0; i < string.length(); i++) {
        if (!Character.isDigit(string.charAt(i))) {
          return;
        }
      }

      super.insertString(fb, offset, string, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
      // Chỉ cho phép nhập số.
      for (int i = 0; i < string.length(); i++) {
        if (!Character.isDigit(string.charAt(i))) {
          return;
        }
      }

      super.replace(fb, offset, length, string, attr);
    }
  }
