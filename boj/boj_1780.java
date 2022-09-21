package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {
    static int[][] board;
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, n);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    static void cutPaper(int r, int c, int len) {
        if(validate(r, c, len)) {
            count[board[r][c] + 1]++;
            return;
        }

        int newLen = len / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cutPaper(r + newLen * i, c + newLen * j, newLen);
            }
        }
    }

    static boolean validate(int r, int c, int len) {
        int num = board[r][c];
        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (board[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
