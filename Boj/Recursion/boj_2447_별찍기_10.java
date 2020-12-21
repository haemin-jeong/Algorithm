package Boj.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2447_별찍기_10 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        drawStar(0,0, n);

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    static void drawStar(int x, int y, int n) {

        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int blankIndex = 0;
        for (int i = x;i < x+n; i += n/3) {
            for (int j = y; j < y+n; j += n/3) {
                if (++blankIndex == 5)
                    drawBlank(i, j, n/3);
                else
                    drawStar(i, j, n/3);
            }
        }

    }

    static void drawBlank(int x, int y, int n) {
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}
