package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14500 {

    static int n, m;
    static int[][] board;
    static boolean[][] check;
    static int answer = Integer.MIN_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] oDx = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    static int[][] oDy = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    public static void dfs(int level, int x, int y, int sum) {
        if (level == 4) {
            answer = Math.max(answer, sum);

        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !check[nx][ny]) {
                    check[nx][ny] = true;
                    dfs(level + 1, nx, ny, sum + board[nx][ny]);
                    check[nx][ny] = false;
                }
            }
        }
    }

    /**
     * ㅗ 모양은 dfs로 구할수 없기 때문에 추가적으로 구한다.
     */
    public static void checkOShape(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int sum = 0;
            boolean flag = true;

            for (int j = 0; j < 4; j++) {
                int nx = x + oDx[i][j];
                int ny = y + oDy[i][j];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    flag = false;
                    break;
                }

                sum += board[nx][ny];
            }

            if (flag) {
                answer = Math.max(answer, sum);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check[i][j] = true;
                dfs(0, i, j, 0);
                check[i][j] = false;
                checkOShape(i, j);
            }
        }

        System.out.println(answer);
    }
}
