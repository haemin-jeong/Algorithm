package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15684 {

    private static final int LEFT = 1, RIGHT = 2;
    private static int n, m, h;
    private static int[][] board;
    private static int answer = Integer.MAX_VALUE;

    /**
     * i번 세로 줄의 결과가 i인지 체크한다.
     */
    private static boolean check() {
        for (int i = 1; i <= n; i++) {
            int line = i;
            for (int j = 1; j <= h; j++) {
                if (board[j][line] == LEFT) {
                    line--;
                } else if (board[j][line] == RIGHT) {
                    line++;
                }
            }

            if (line != i) {
                return false;
            }
        }

        return true;
    }

    //level : 현재 선의 개수
    private static void dfs(int level, int start) {
        //현재 최소값보다 작거나 3보다 크면 리턴
        if (level >= answer || level > 3) {
            return;
        }

        // i번 세로 줄의 결과가 i번 인지 체크하여 참이면
        if (check()) {
            // 현재 추가한 선의 개수가 최소 값인지 확인
            answer = Math.min(answer, level);
        }

        for (int i = start; i < n; i++) {
            for (int j = 1; j <= h; j++) {
                if (board[j][i] == 0 && board[j][i+1] == 0) {
                    board[j][i] = RIGHT;
                    board[j][i+1] = LEFT;

                    dfs(level+1, i);

                    board[j][i] = 0;
                    board[j][i+1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //b번쨰 세로 줄 기준으로 a번째 우측 가로줄이 있다.
            board[a][b] = RIGHT;

            //b+1번째 세로 줄 기준으로 a번째 좌측 가로줄이 있다.
            board[a][b + 1] = LEFT;
        }

        dfs(0, 1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
