package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(n);
            return;
        }

        int[] dy = new int[n+1];
        dy[1] = 1;
        dy[2] = 3;

        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2] * 2) % 10007;
        }

        System.out.println(dy[n]);
    }
}
