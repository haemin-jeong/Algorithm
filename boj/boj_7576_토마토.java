package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576_토마토 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int m, n;
    static int[][] board;
    static int[][] days;

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        Queue<Position> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    q.offer(new Position(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Position cur = q.poll();

            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + cur.x;
                int ny = dy[j] + cur.y;

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    days[nx][ny] = days[cur.x][cur.y] + 1;
                    q.offer(new Position(nx, ny));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //가로
        m = Integer.parseInt(st.nextToken()); //세로
        board = new int[m][n];
        days = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        boolean flag = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    answer = Math.max(answer, days[i][j]);
                }
            }

            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}
