package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13460 {

    static class State {
        int rx, ry;
        int bx, by;
        int moveCount;

        public State(int rx, int ry, int bx, int by, int moveCount) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.moveCount = moveCount;
        }
    }

    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][N][M];
        map = new char[N][M];
        int rx = 0, ry = 0; //빨간 구슬 위치
        int bx = 0, by = 0; //파란 구슬 위치

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (chars[j] == 'R') {
                    rx = i; ry = j;
                } else if (chars[j] == 'B') {
                    bx = i; by = j;
                } else {
                    map[i][j] = chars[j];
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }


    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State state = q.poll();

            if(state.moveCount >= 10) return -1;

            for (int i = 0; i < 4; i++)
                if (roll(state, q, i)) return state.moveCount+1;
        }

        return -1;
    }

    /**
     * @return true 이면 빨간 구슬만 구멍에 넣기 성공
     */
    static boolean roll(State state, Queue<State> q, int dir) {
        int rx = state.rx; int ry = state.ry;
        int bx = state.bx; int by = state.by;

        boolean frontRed = false;

        //파란 구슬 굴리기
        while (map[bx + dx[dir]][by + dy[dir]] != '#') {
            bx += dx[dir]; by += dy[dir];

            //파란 구슬이 나아가는 방향 앞에 빨간 구슬이 있는지 체크.
            if (bx == rx && by == ry) frontRed = true;

            //파란 구슬이 구멍에 빠지면 실패
            if (map[bx][by] == 'O') return false;
        }

        //빨간 구슬 굴리기
        while (map[rx + dx[dir]][ry + dy[dir]] != '#') {
            rx += dx[dir]; ry += dy[dir];

            //빨간 구슬이 구멍에 빠지면 성공
            if (map[rx][ry] == 'O') return true;
        }

        //기울였을 때 빨간 구슬과 파란 구슬이 겹치는 경우를 처리
        if (rx == bx && ry == by) {
            if (frontRed) { //파란 구슬이 굴러가는 방향에 빨간 구슬이 앞에 있엇다면,
                bx -= dx[dir]; by -= dy[dir]; //파란 구슬의 위치를 빨간 구슬 뒤로
            } else {
                rx -= dx[dir];ry -= dy[dir]; //빨간 구슬의 위치를 파란 구슬 뒤로
            }
        }

        //빨간, 파란 구슬의 위치가 이미 왔었던 위치이면 중복 실행이 일어나는 것이기 때문에 진행 X
        if(!visited[rx][ry][bx][by]) {
            visited[rx][ry][bx][by] = true;
            q.offer(new State(rx, ry, bx, by, state.moveCount + 1));
        }

        return false;
    }
}
