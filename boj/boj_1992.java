package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992 {
    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new String[n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        recur(0, 0, n, sb);

        System.out.println(sb);
    }

    static void recur(int row, int col, int len, StringBuilder sb) {
        if (validate(row, col, len)) {
            sb.append(board[row].charAt(col));
        } else {
            sb.append("(");
            recur(row, col, len / 2, sb);
            recur(row, col + len / 2, len / 2, sb);
            recur(row + len / 2, col, len / 2, sb);
            recur(row + len / 2, col + len / 2, len / 2, sb);
            sb.append(")");
        }
    }

    static boolean validate(int row, int col, int len) {
        char target = board[row].charAt(col);
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (board[i].charAt(j) != target) {
                    return false;
                }
            }
        }
        return true;
    }
}
