package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int reverseA = Integer.parseInt(new StringBuilder(String.valueOf(a)).reverse().toString());
        int reverseB = Integer.parseInt(new StringBuilder(String.valueOf(b)).reverse().toString());

        System.out.println(Math.max(reverseA, reverseB));
    }
}
