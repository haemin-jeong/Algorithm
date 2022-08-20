package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2234 {
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static boolean[][] check;
    private static int[][] map;
    private static int numOfRooms = 0;
    private static int maxWidth = Integer.MIN_VALUE;
    private static int maxRemoveWidth = Integer.MIN_VALUE;
    private static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        check = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();

        System.out.println(numOfRooms);
        System.out.println(maxWidth);
        System.out.println(maxRemoveWidth);
    }

    private static void solution() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    maxWidth = Math.max(maxWidth, calculateWidth(i, j));
                    numOfRooms++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k <= 8; k <<= 1) {
                    if ((k & map[i][j]) > 0) {
                        clearChecks();
                        map[i][j] -= k;
                        maxRemoveWidth = Math.max(maxRemoveWidth, calculateWidth(i, j));
                        map[i][j] += k;
                    }
                }
            }
        }
    }

    private static int calculateWidth(int startX, int startY) {
        int width = 1;
        check[startX][startY] = true;

        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(startX, startY));

        while (!q.isEmpty()) {
            Pos curPos = q.poll();

            int dir = 0;
            for (int i = 1; i <= 8; i <<= 1) {
                int nx = curPos.x + dx[dir];
                int ny = curPos.y + dy[dir];

                if ((i & map[curPos.x][curPos.y]) == 0 &&
                        nx >= 0 && nx < m &&
                        ny >= 0 && ny < n &&
                        !check[nx][ny]
                ) {
                    check[nx][ny] = true;
                    q.offer(new Pos(nx, ny));
                    width++;
                }

                dir++;
            }
        }

        return width;
    }

    private static void clearChecks() {
        for (int i = 0; i < m; i++) {
            Arrays.fill(check[i], false);
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
