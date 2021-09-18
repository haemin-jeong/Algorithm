package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String upperCase = s.toUpperCase();
        int[] count = new int[26]; //알파벳당 사용된 개수를 저장

        for (int i = 0; i < upperCase.length(); i++) {
            count[upperCase.charAt(i) - 65]++;
        }

        boolean duplication = false; //최대값이 중복인지 판별
        int max = Integer.MIN_VALUE; //최대값
        int answer = Integer.MIN_VALUE; //최대값의 배열 인덱스

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                duplication = false;
                max = count[i];
                answer = i;
            } else if (count[i] == max) {
                duplication = true;
            }
        }

        if (duplication) {
            System.out.println("?");
        } else {
            System.out.println((char)(answer+65));
        }
    }
}
