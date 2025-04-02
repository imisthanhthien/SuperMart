/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import POJO.*;
import java.util.Random;

/**
 *
 * @author NGUYEN THANH THIEN
 */
public class RandomStringGenerator {
    
    private static final String CHARACTERS = "0123456789";
    private static final Random RANDOM = new Random();

    public static String generateRandomDigits(int length) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            result.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }

        return result.toString();
    }
}