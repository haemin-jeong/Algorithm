package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {
    
    static int[][] board;
    static int n, m, r, c, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution() {
        int answer = 0;

        while (true) {
            //아직 청소가 안된 칸이라면 청소한다.
            if (board[r][c] == 0) {
                board[r][c] = 2;
                answer++;
            }

            //true이면 회전중 청소 안된 칸 발견
            boolean flag = false;

            for (int i = 0; i < 4; i++) {
                //왼쪽으로 회전
                if (d == 0) {
                    d = 3;
                } else {
                    d--;
                }

                int nx = r + dx[d];
                int ny = c + dy[d];

                //회전중 청소가 안된 칸을 발견하면 해당 칸으로 이동
                if (board[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    flag = true;
                    break;
                }
            }

            //네방향 모두 청소가 되어있거나 벽이면,
            if (!flag) {
                int nx = 0;
                int ny = 0;

                //후진 좌표 구하기
                if (d == 0 || d == 1) {
                    nx = r + dx[d+2];
                    ny = c + dy[d+2];
                } else {
                    nx = r + dx[d-2];
                    ny = c + dy[d-2];
                }

                //후진할 칸이 벽이라면 작동 정지
                if (board[nx][ny] == 1) {
                    return answer;
                }

                //후진할 칸이 벽이 아니라면 해당 칸으로 이동
                r = nx;
                c = ny;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }
}
