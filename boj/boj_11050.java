package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- n C r = n-1 C r-1 + n C r-1
- n C n = n C 0 = 1
 */
public class boj_11050 {

    //메모이제이션
    static int[][] dy;

    public static int recursive(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }

        if (dy[n][r] > 0) {
            return dy[n][r];
        }

        return dy[n][r] = recursive(n - 1, r - 1) + recursive(n - 1, r);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dy = new int[n+1][k+1];

        System.out.println(recursive(n, k));
    }
}
