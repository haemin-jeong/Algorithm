package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {

    static int n;
    static String[] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new String[n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int rgbCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    rgbCount++;
                    bfsRGB(i, j);
                }
            }
        }

        visited = new boolean[n][n];

        int rbCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    rbCount++;
                    bfsRB(i, j);
                }
            }
        }

        System.out.println(rgbCount + " " + rbCount);
    }

    static void bfsRGB(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        char target = board[x].charAt(y);

        q.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n
                        && board[nx].charAt(ny) == target && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    Pos newPos = new Pos(nx, ny);
                    q.offer(newPos);
                }
            }
        }
    }

    static void bfsRB(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        char target = board[x].charAt(y);

        q.offer(new Pos(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if ((target == 'R' || target == 'G') && board[nx].charAt(ny) == 'B'){
                        continue;
                    }

                    if (target == 'B' && board[nx].charAt(ny) != target) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    Pos newPos = new Pos(nx, ny);
                    q.offer(newPos);
                }
            }
        }
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
