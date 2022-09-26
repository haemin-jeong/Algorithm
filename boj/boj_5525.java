package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 0;

        for (int i = 0; i < m - 1; i++) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O') {
                int count = 0;
                for (; i < m - 2; i += 2) {
                    if (s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                        count++;
                    } else {
                        break;
                    }

                    if (count == n) {
                        count--;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
