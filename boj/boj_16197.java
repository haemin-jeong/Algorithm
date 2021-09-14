package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16197 {

    static int n, m;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int level, int x1, int y1, int x2, int y2) {
        if (level >= answer || level == 10) {
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx1 = x1 + dx[i];
                int ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i];
                int ny2 = y2 + dy[i];

                //떨어진 동전 개수
                int count = 0;

                if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= m) {
                    count++;
                }

                if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= m) {
                    count++;
                }

                //동전이 한개만 떨어진 경우
                if (count == 1) {
                    answer = Math.min(answer, level + 1);
                    return;
                }

                //동전이 두개 다 떨어진 경우
                if (count == 2) {
                    continue;
                }

                if (board[nx1][ny1] == '#') {
                    nx1 = x1;
                    ny1 = y1;
                }

                if (board[nx2][ny2] == '#') {
                    nx2 = x2;
                    ny2 = y2;
                }

                dfs(level + 1, nx1, ny1, nx2, ny2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //세로
        m = Integer.parseInt(st.nextToken()); //가로
        board = new char[n][m];

        int[] x = new int[2];
        int[] y = new int[2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();

            if (count < 2) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'o') {
                        x[count] = i;
                        y[count] = j;
                        count++;
                    }
                }
            }
        }

        dfs(0, x[0], y[0], x[1], y[1]);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
