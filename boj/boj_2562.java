package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE; //최대값
        int idx = Integer.MIN_VALUE; //최대값 위치

        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > max) {
                idx = i;
                max = n;
            }
        }

        System.out.println(max);
        System.out.println(idx+1);
    }
}
