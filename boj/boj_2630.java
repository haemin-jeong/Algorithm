package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630 {
    static int[][] board;
    static int[] answer = new int[2];

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

        divide(0, 0, n);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static void divide(int row, int col, int len) {
        if (validate(row, col, len)) {
            answer[board[row][col]]++;
            return;
        }

        int nextLen = len / 2;
        divide(row, col, nextLen);
        divide(row, col + nextLen, nextLen);
        divide(row + nextLen, col, nextLen);
        divide(row + nextLen, col + nextLen, nextLen);
    }

    static boolean validate(int row, int col, int len) {
        int target = board[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (board[i][j] != target)
                    return false;
            }
        }

        return true;
    }
}
