package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17822 {

    static int N, M;
    static int sum = 0, count = 0;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];
        count = N*M;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
                board[i][j] = num;
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
            work();
        }

        System.out.println(sum);
    }

    static void rotate(int x, int d, int k) {
        int[] temp = new int[k];
        int idx;

        for (int i = x; i <= N; i += x) {
            if (d == 0) {
                idx = k-1;

                for (int j = M; j > M - k; j--) temp[idx--] = board[i][j];

                for (int j = M - k; j >= 1; j--) board[i][j+k] = board[i][j];

                idx = 0;
                for (int j = 1; j <= k; j++) board[i][j] = temp[idx++];
            } else {
                idx = 0;

                for (int j = 1; j <= k; j++) temp[idx++] = board[i][j];

                for (int j = k + 1; j <= M; j++) board[i][j-k] = board[i][j];

                idx = 0;
                for (int j = M - k + 1; j <= M; j++) board[i][j] = temp[idx++];
            }
        }
    }

    static void work() {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                int num = board[x][y];

                if (num >= 1) find(x, y, num);
            }
        }

        boolean isChange = false;

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                if (check[x][y]) {
                    if (!isChange) isChange = true;
                    sum -= board[x][y];
                    count--;
                    board[x][y] = -1;
                    check[x][y] = false;
                }
            }
        }

        if (!isChange) {
            double avg = (double)sum / count;

            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= M; y++) {
                    if (board[x][y] == -1) continue;

                    if (board[x][y] > avg){
                        if (board[x][y] > 0) {
                            board[x][y]--;
                            sum--;
                        }
                    } else if (board[x][y] < avg) {
                        board[x][y]++;
                        sum++;
                    }
                }
            }
        }
    }

    private static void find(int x, int y, int num) {
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > N) continue;
            if (ny < 1) ny = M;
            if (ny > M) ny = 1;

            if (board[nx][ny] == -1) continue;

            if (num == board[nx][ny]) {
                if (board[nx][ny] > 0) {
                    check[nx][ny] = true;
                    flag = true;
                }
            }
        }

        if (flag) {
            if (board[x][y] > 0) {
                check[x][y] = true;
            }
        }
    }
}
