package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_21610 {
    private static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    private static List<Pos> cloudList = new ArrayList<>();
    private static int n, m;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];

        cloudList.add(new Pos(n, 1));
        cloudList.add(new Pos(n, 2));
        cloudList.add(new Pos(n - 1, 1));
        cloudList.add(new Pos(n - 1, 2));

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            moveClouds(direction, distance);
            rain();
            waterCopyMagic();
            createClouds();
        }

        System.out.println(getSumOfWater());
    }

    private static int getSumOfWater() {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += board[i][j];
            }
        }

        return sum;
    }

    private static void createClouds() {
        boolean[][] check = new boolean[n+1][n+1];

        for (Pos pos : cloudList) {
            check[pos.x][pos.y] = true;
        }

        removeAllClouds();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (check[i][j]) {
                    continue;
                }

                if (board[i][j] >= 2) {
                    board[i][j] -= 2;
                    cloudList.add(new Pos(i, j));
                }
            }
        }
    }

    private static void moveClouds(int direction, int distance) {
        for (Pos pos : cloudList) {
            pos.x = calculateLocation(pos.x + dx[direction] * distance);
            pos.y = calculateLocation(pos.y + dy[direction] * distance);
        }
    }

    private static void rain() {
        for (Pos pos : cloudList) {
            board[pos.x][pos.y]++;
        }
    }

    private static void waterCopyMagic() {
        for (Pos pos : cloudList) {
            int count = 0;

            for (int i = 2; i <= 8; i += 2) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= n && board[nx][ny] > 0) {
                    count++;
                }
            }

            board[pos.x][pos.y] += count;
        }
    }

    private static void removeAllClouds() {
        cloudList.clear();
    }

    /**
     * 1번 행과 n번행, 1번 열과 n번 열이 연결된 것을 고려한 행 또는 열의 위치 반환
     */
    private static int calculateLocation(int num) {
        int temp = num;
        while(temp > n || temp < 1) {
            if (temp > n) {
                temp -=  n;
            }

            if (temp < 1) {
                temp += n;
            }
        }
        return temp;
    }
}
