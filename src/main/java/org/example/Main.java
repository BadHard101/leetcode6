package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1 || s.length() <= numRows) return s;

        HashMap<Integer, LinkedList<Character>> lines = new HashMap<>();
        int letter = 0;

        LinkedList<Character> temp = new LinkedList<>();
        temp.add(s.charAt(letter++));
        lines.put(1, temp);

        while (letter < s.length()) {
            for (int i = 2; i <= numRows; i++) {
                temp = lines.getOrDefault(i, new LinkedList<>());
                temp.add(s.charAt(letter++));
                lines.put(i, temp);

                if (letter == s.length()) break;
            }
            if (letter == s.length()) break;
            for (int i = numRows - 1; i >= 1; i--) {
                temp = lines.getOrDefault(i, new LinkedList<>());
                temp.add(s.charAt(letter++));
                lines.put(i, temp);

                if (letter == s.length()) break;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int num_of_line = 1; num_of_line <= numRows; num_of_line++) {
            LinkedList<Character> line = lines.get(num_of_line);
            while (!line.isEmpty()) {
                builder.append(line.pop());
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        //System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("ABC", 4));
    }
}