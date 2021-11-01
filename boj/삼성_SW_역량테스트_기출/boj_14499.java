package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14499 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        /*
        주사위를 2차원 배열로 표현
        0 2 0
        4 1 3
        0 5 0
        0 6 0
         */
        int[][] dice = new int[4][3];

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());

            int nx = x + dx[d];
            int ny = y + dy[d];

            //지도를 벗어나면 아무것도 하지 않는다.
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            //주사위 굴리기
            if (d == 1) { //동쪽
                diceRollEast(dice);
            } else if (d == 2) { //서쪽
                diceRollWest(dice);
            } else if (d == 3) { //북쪽
                diceRollNorth(dice);
            } else if (d == 4) { //남쪽
                diceRollSouth(dice);
            }

            //주사위 윗면: dice[1][1], 바닥면: dice[3][1]

            if (board[nx][ny] == 0) {
                //이동한 칸이 0이면 주사위 바닥의 수를 칸에 복사한다.
                board[nx][ny] = dice[3][1];
            } else {
                //이동한 칸이 0이 아니면 칸에 쓰여진 수를 주사위 바닥에 복사하고, 칸은 0으로 바꾼다.
                dice[3][1] = board[nx][ny];
                board[nx][ny] = 0;
            }

            x = nx;
            y = ny;

            //주사위 윗면 출력
            sb.append(dice[1][1]).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * 주사위를 서쪽으로 한칸 굴린다.
     */
    private static void diceRollWest(int[][] dice) {
        int temp = dice[3][1];
        dice[3][1] = dice[1][0];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = temp;
    }

    /**
     * 주사위를 동쪽으로 한칸 굴린다.
     */
    private static void diceRollEast(int[][] dice) {
        int temp = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = temp;

    }

    /**
     * 주사위를 북쪽으로 한칸 굴린다.
     */
    private static void diceRollNorth(int[][] dice) {
        int temp = dice[0][1];
        dice[0][1] = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = temp;
    }

    /**
     * 주사위를 남쪽으로 한칸 굴린다.
     */
    private static void diceRollSouth(int[][] dice) {
        int temp = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = temp;
    }
}
