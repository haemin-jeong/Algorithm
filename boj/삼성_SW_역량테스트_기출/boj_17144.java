package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17144 {
    static class Pos {
        int x;
        int y;
        int dust;

        public Pos(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] board = new int[r][c];

        //하단 공기청정기의 행 좌표
        int lastCleanerX = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == -1) {
                    lastCleanerX = i;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spreadDust(board, r, c);
            runCleaner(board, lastCleanerX, r, c);
        }

        int remainDust = getRemainDust(r, c, board);

        System.out.println(remainDust);
    }

    private static int getRemainDust(int r, int c, int[][] board) {
        int remainDust = 2; //공기청정기 2칸이 각 -1이기 때문에 2를 더해놓는다.

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                remainDust += board[i][j];
            }
        }

        return remainDust;
    }

    public static void runCleaner(int[][] board, int lastCleanerX, int r, int c) {
        int topCleanerX = lastCleanerX - 1;
        int bottomCleanerX = lastCleanerX;

        //상단 공기청정기 작동

        //위쪽 공기청정기 좌측 먼지 이동
        for (int i = topCleanerX-1; i > 0; i--) {
            board[i][0] = board[i-1][0];
        }

        //위쪽 공기청정기 위쪽 먼지 이동
        for (int i = 0; i < c-1; i++) {
            board[0][i] = board[0][i+1];
        }

        //위쪽 공기청정기 우측 먼지 이동
        for (int i = 0; i < topCleanerX; i++) {
            board[i][c-1] = board[i+1][c-1];
        }

        //위쪽 공기청정기 하단 먼지 이동
        for (int i = c-1; i > 1; i--) {
            board[topCleanerX][i] = board[topCleanerX][i-1];
        }

        board[topCleanerX][1] = 0;

        //하단 공기청정기 작동

        //아래쪽 공기청정기 좌측 먼지 이동
        for (int i = bottomCleanerX + 1; i < r-1; i++) {
            board[i][0] = board[i + 1][0];
        }

        //아래쪽 공기청정기 하단 먼지 이동
        for (int i = 0; i < c - 1; i++) {
            board[r-1][i] = board[r-1][i+1];
        }

        //아래쪽 공기청정기 우측 먼지 이동
        for (int i = r-1; i > bottomCleanerX; i--) {
            board[i][c-1] = board[i-1][c-1];
        }

        //아래쪽 공기청정기 상단 먼지 이동
        for (int i = c - 1; i > 1; i--) {
            board[bottomCleanerX][i] = board[bottomCleanerX][i-1];
        }

        board[bottomCleanerX][1] = 0;
    }

    private static void spreadDust(int[][] board, int r, int c) {
        // 먼지의 확산이 모든 칸에서 동시에 일어나야하는데, 배열을 순차적으로 돌며 먼지를 확산시키면
        // 아직 확산을 일으키지않은 다른 칸의 초기 먼지량에 영향을 주어 동시에 확산이 일어나는 것이 아닌 순차적으로 확산이 일어나는 코드가 된다.
        // 그래서 리스트에 먼지가 있는 칸의 위치와 초기 먼지량을 저장하여 사용한다.
        List<Pos> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] > 0) {
                    list.add(new Pos(i, j, board[i][j]));
                }
            }
        }

        for (Pos pos : list) {
            int count = 0;

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] > -1) {
                    board[nx][ny] += pos.dust/5;
                    count++;
                }
            }

            board[pos.x][pos.y] -= (pos.dust/5 * count);
        }
    }
}
