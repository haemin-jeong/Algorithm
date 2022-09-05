package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class boj_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger num = BigInteger.ONE;
        for (int i = n; i >= 1; i--) {
            num = num.multiply(BigInteger.valueOf(i));
        }

        String numString = num.toString();
        int len = numString.length();
        for (int i = len - 1; i >= 0; i--) {
            if (numString.charAt(i) != '0') {
                System.out.println(len - i - 1);
                return;
            }
        }
    }
}
