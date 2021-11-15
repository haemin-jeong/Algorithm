package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236 {

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board, dist;
    static Pos shark = null;
    static int numOfFish = 0, n, sharkSize = 2, seconds = 0, eatFish = 0;
    static int minX, minY, minDist;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs() {
        Queue<Pos> q = new LinkedList<>();

        q.offer(shark);

        while (!q.isEmpty()) {
            Pos poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] <= sharkSize && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[poll.x][poll.y] + 1;

                    if (board[nx][ny] > 0 && board[nx][ny] < sharkSize) {
                        if (minDist > dist[nx][ny]) {
                            minDist = dist[nx][ny];
                            minX = nx;
                            minY = ny;
                        } else if (minDist == dist[nx][ny]) {
                            if (minX > nx) {
                                minX = nx;
                                minY = ny;
                            } else if (minX == nx) {
                                if (minY > ny) {
                                    minX = nx;
                                    minY = ny;
                                }
                            }
                        }
                    }

                    q.offer(new Pos(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        shark = null;

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 9) {
                    shark = new Pos(i, j);
                } else if (num > 0) {
                    board[i][j] = num;
                    numOfFish++;
                }
            }
        }

        while (true) {
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;
            dist = new int[n][n];

            bfs();

            if (minX == Integer.MAX_VALUE) {
                break;
            }

            eatFish++;
            board[minX][minY] = 0;
            shark.x = minX;
            shark.y = minY;
            seconds += dist[minX][minY];

            if (eatFish == sharkSize) {
                sharkSize++;
                eatFish = 0;
            }
        }

        System.out.println(seconds);
    }
}
