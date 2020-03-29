package com.lysy.morse;

import java.util.Arrays;
import java.util.List;

public class MorseConverter extends ConstValues implements MorseStatement {

    public MorseConverter() {
    }

    private String morseToString(String msg) {
        String spaceBetweenWord = findSpace(msg, "");
        String spaceBetweenSign = findSpace(msg, spaceBetweenWord);

        String result = new String();
        List<String> wordLst = Arrays.asList(msg.split(spaceBetweenWord));

        for (String word : wordLst) {
            List<String> signLst = Arrays.asList(word.split(spaceBetweenSign));
            for (String sign : signLst) {
                String val = morseKey.get(sign);
                result += (val != null)? val : "?";
            }
            result += " ";
        }
        return result;


    }


    private String findSpace(String msg, String longestSpace) {
        int max = 0;
        int size = 0;
        int theLongestSpace = longestSpace.length();
        for (int i = 0; i < msg.length(); i++) {
            if (" ".equals(String.valueOf(msg.charAt(i)))) {
                size++;
            } else {
                if (size > max && size != theLongestSpace) {
                    max = size;
                }
                size = 0;
            }
        }

        String result = new String();
        for (int i = 0; i < max; i++) {
            result += " ";
        }
        return result;
    }

    private static String stringToMorse(String msg) {
        String result = new String();
        msg = msg.toLowerCase();
        for (int i = 0; i < msg.length(); i++) {
            char sign = msg.charAt(i);
            String val = alphabetKey.get(String.valueOf(sign));
            result += (val == null) ? "?" : val;
            result += spaceMark;
        }
        return result;
    }

    @Override
    public String convertMessage(String msg) {
        if (msg.startsWith("•") || msg.startsWith("—")) {
            return morseToString(msg);
        } else {
            return stringToMorse(msg);
        }
    }
}
