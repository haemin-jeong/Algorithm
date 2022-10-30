package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3085 {
    static char[][] board;
    static int n;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();

            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                searchRow(i);
                searchCol(j);
                searchCol(j+1);
                swap(i, j, i, j + 1);

                swap(j, i, j + 1, i);
                searchRow(j);
                searchRow(j+1);
                searchCol(i);
                swap(j, i, j + 1, i);
            }
        }

        System.out.println(result);
    }

    static void searchCol(int col) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (board[i][col] == board[i - 1][col]) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);
    }

    static void searchRow(int row) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (board[row][i] == board[row][i - 1]) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
