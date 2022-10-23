package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n + 1];
            int[][] dy = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dy[0][1] = arr[0][1];
            dy[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                dy[0][j] = Math.max(dy[1][j - 1], dy[1][j - 2]) + arr[0][j];
                dy[1][j] = Math.max(dy[0][j - 1], dy[0][j - 2]) + arr[1][j];
            }

            sb.append(Math.max(dy[0][n], dy[1][n])).append("\n");
        }

        System.out.println(sb);
    }
}
