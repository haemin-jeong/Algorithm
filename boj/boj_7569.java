package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {
    static int m, n, h;
    static int[][][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][n][m];

        int zeroCount = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                    if (board[i][j][k] == 0) {
                        zeroCount++;
                    }
                }
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
    }

    static int bfs() {
        Queue<Pos> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 1) {
                        q.offer(new Pos(j, k, i));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            if (pos.z > 0 && board[pos.z-1][pos.x][pos.y] == 0) {
                board[pos.z - 1][pos.x][pos.y] = board[pos.z][pos.x][pos.y] + 1;
                q.offer(new Pos(pos.x, pos.y, pos.z - 1));
            }

            if (pos.z < h - 1 && board[pos.z + 1][pos.x][pos.y] == 0) {
                board[pos.z + 1][pos.x][pos.y] = board[pos.z][pos.x][pos.y] + 1;
                q.offer(new Pos(pos.x, pos.y, pos.z + 1));
            }

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[pos.z][nx][ny] == 0) {
                    board[pos.z][nx][ny] = board[pos.z][pos.x][pos.y] + 1;
                    q.offer(new Pos(nx, ny, pos.z));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, board[i][j][k]);
                }
            }
        }

        return max - 1;
    }

    static class Pos {
        int x;
        int y;
        int z;

        public Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
