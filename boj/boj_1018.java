package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //세로
        int m = Integer.parseInt(st.nextToken()); //가로
        board = new char[n][m];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            board[i] = s.toCharArray();
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                //검은 칸부터 시작하는 경우
                min = Math.min(min, count(i, j, true));

                //흰색 칸부터 시작하는 경우
                min = Math.min(min, count(i, j, false));
            }
        }

        System.out.println(min);
    }

    public static int count(int x, int y, boolean startIsBlack) {
        int count = 0;
        boolean isBlack = startIsBlack;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (isBlack && board[i][j] == 'W') {
                    count++;
                }

                if (!isBlack && board[i][j] == 'B') {
                    count++;
                }

                isBlack = !isBlack;
            }

            isBlack = !isBlack;
        }

        return count;
    }
}
