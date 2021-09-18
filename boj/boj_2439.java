package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                sb.append(" ");
            }

            for (int k = 0; k < i; k++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
