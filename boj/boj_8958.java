package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int sum = 0;
            int score = 1;

            for (char c : s.toCharArray()) {
                if (c == 'O') {
                    sum += score;
                    score++;
                } else {
                    score = 1;
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
