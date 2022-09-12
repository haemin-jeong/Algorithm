package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2579 {
    static int[] stair, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        stair = new int[n+1];
        dy = new int[n+1];

        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dy[1] = stair[1];

        if (n >= 2) {
            dy[2] = stair[1] + stair[2];
        }

        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i-2], dy[i-3] + stair[i-1]) + stair[i];
        }

        System.out.println(dy[n]);
    }
}
