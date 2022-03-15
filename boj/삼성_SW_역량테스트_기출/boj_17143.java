package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
처음에 놓친 부분 : 상어를 이동하자마자 중복 검사를 하였는데, 상어를 이동하자마자 중복 검사를 하면 해당 위치에 있는 상어가 아직 이동하지 않은 상어일 수도 있다.
 */
public class boj_17143 {
    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        void changeDirection() {
            if (d == 1) d = 2;
            else if (d == 2) d = 1;
            else if (d == 3) d = 4;
            else d = 3;
        }
    }

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static int[][] map;
    static Shark[] sharks;
    static int r, c, m, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[r+1][c+1];
        sharks = new Shark[m + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            //2 * (r-1) 만큼 이동하면 같은 방향 같은 위치로 돌아온다.
            if (s > 0) {
                if(d == 1 || d == 2) s = s % (2 * (r - 1));
                else s = s % (2 * (c - 1));
            }

            sharks[i] = new Shark(r1, c1, s, d, z);
            map[r1][c1] = i;
        }

        for (int i = 1; i <= c; i++) {
            fishing(i); moveSharks();
        }

        System.out.println(answer);
    }

    static void moveSharks() {
        int[][] temp = new int[r + 1][c + 1];

        for (int i = 1; i <= m; i++) {
            if (sharks[i] == null) continue;

            Shark s = sharks[i];

            int nx = s.r; int ny = s.c;

            for (int j = 0; j < s.s; j++) {
                if (nx + dx[s.d] < 1 || nx + dx[s.d] > r || ny + dy[s.d] < 1 || ny + dy[s.d] > c) {
                    s.changeDirection();
                }

                nx += dx[s.d]; ny += dy[s.d];
            }

            if (temp[nx][ny] > 0) {
                if(sharks[temp[nx][ny]].z > s.z) {
                    sharks[i] = null; continue;
                } else {
                    sharks[temp[nx][ny]] = null;
                }
            }

            s.r = nx; s.c = ny;
            temp[nx][ny] = i;
        }

        map = temp;
    }

    static void fishing(int line) {
        for (int i = 1; i <= r; i++) {
            if (map[i][line] > 0) {
                int sNum = map[i][line];
                answer += sharks[sNum].z;
                map[i][line] = 0;
                sharks[sNum] = null;
                return;
            }
        }
    }
}
