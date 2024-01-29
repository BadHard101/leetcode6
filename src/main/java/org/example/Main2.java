package org.example;

import java.util.HashMap;
import java.util.LinkedList;

public class Main2 {
    public static String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1 || s.length() <= numRows) return s;

        StringBuilder answer = new StringBuilder();
        int step1 = numRows * 2 - 2;
        int step2 = 0;

        //1
        int cur = 0;
        while (cur < s.length()) {
            answer.append(s.charAt(cur));
            cur += step1;
        }
        step1 -= 2;
        step2 += 2;

        //2
        for (int firstRowLetter = 1; firstRowLetter < numRows - 1; firstRowLetter++) {
            cur = firstRowLetter;
            answer.append(s.charAt(cur));
            while (cur < s.length()) {
                cur += step1;
                if (cur >= s.length()) break;
                answer.append(s.charAt(cur));
                cur += step2;
                if (cur >= s.length()) break;
                answer.append(s.charAt(cur));
            }
            step1 -= 2;
            step2 += 2;
        }

        //3
        cur = numRows - 1;
        while (cur < s.length()) {
            answer.append(s.charAt(cur));
            cur += step2;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        //System.out.println(convert("ABC", 4));
    }
}