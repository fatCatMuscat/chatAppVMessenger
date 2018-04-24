package com.fatcatmuscat.VMessenger.utils;

import java.util.Random;

public class utils {


     public String generateRandomPassword(int length) {
        String base = "ABCDEFJKLMNOPQRSTUVWXYZ1234567890";

        Random rand = new Random();
        StringBuilder result = new StringBuilder();

        while (length-- > 0) {
            int index = rand.nextInt(base.length());
            result.append(base.charAt(index));
        }
        return result.toString();
    }


}
