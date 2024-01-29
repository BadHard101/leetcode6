package org.example;

public class Solution {
    public static String convert(String s, int numRows) {
        char[] word = s.toCharArray();
        int len = word.length;
        StringBuffer[] rows = new StringBuffer[numRows];

        for (int i = 0; i < rows.length; i++)
            rows[i] = new StringBuffer();

        int cur = 0;
        while (cur < len) {
            for (int row = 0; row < numRows && cur < len; row++) // vertically down
                rows[row].append(word[cur++]);
            for (int row = numRows - 2; row >= 1 && cur < len; row--) // obliquely up
                rows[row].append(word[cur++]);
        }

        for (int idx = 1; idx < rows.length; idx++)
            rows[0].append(rows[idx]);

        return rows[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        //System.out.println(convert("ABC", 4));
    }
}