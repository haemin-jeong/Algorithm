package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_3190 {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1]; //사과 위치
        char[] directions = new char[10001]; //인덱스 : 초, 값 : 방향

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            directions[x] = c;
        }

        Deque<Pos> deque = new LinkedList<>();
        deque.offerFirst(new Pos(1, 1));

        //0 : 위쪽, 1: 오른쪽, 2: 아래쪽, 3: 왼쪽
        int direction = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int second = 0;

        while (true) {
            second++;

            Pos pos = deque.peekFirst();

            int nx = pos.x + dx[direction];
            int ny = pos.y + dy[direction];

            if (nx <= 0 || nx > n || ny <= 0 || ny > n|| deque.contains(new Pos(nx, ny))) {
                System.out.println(second);
                return;
            }

            deque.offerFirst(new Pos(nx, ny));

            //사과이면 사과를 먹는다(1은 사과 칸, 0은 사과 없는 칸)
            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
            } else { //사과가 아니라면 꼬리를 한칸줄인다.
                deque.pollLast();
            }

            if (directions[second] != '\u0000') {
                if (directions[second] == 'L') {
                    if (direction == 0) {
                        direction = 3;
                    } else {
                        direction--;
                    }
                } else { //D
                    if (direction == 3) {
                        direction = 0;
                    } else {
                        direction++;
                    }
                }
            }
        }
    }
}
