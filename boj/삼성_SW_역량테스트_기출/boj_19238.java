package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_19238 {

    static class Pos {
        int x; int y;

        public Pos(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    static int[][] map;
    static Pos[] guestEnd;
    static Pos taxiPos;
    static int N, M, fuel;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        guestEnd = new Pos[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("1")) map[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        taxiPos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()); int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken()); int ey = Integer.parseInt(st.nextToken());
            map[sx][sy] = i; guestEnd[i] = new Pos(ex, ey);
        }

        for (int i = 0; i < M; i++) {
            int guest = findGuest();
            if (guest == -1) {
                System.out.println(-1);
                return;
            }

            if(!takeGuest(guest)) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(fuel);
    }

    static boolean takeGuest(int guest) {
        Queue<Pos> q = new LinkedList<>();
        int[][] dis = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N+1][N+1];
        Pos end = guestEnd[guest];

        q.offer(taxiPos);
        visited[taxiPos.x][taxiPos.y] = true;

        while (!q.isEmpty()) {
            Pos poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i]; int ny = poll.y + dy[i];

                if (nx == end.x && ny == end.y) {
                    int minDis = dis[poll.x][poll.y] + 1;

                    if (fuel < minDis) return false;

                    fuel += minDis;
                    taxiPos = end;
                    return true;
                }

                if (nx > 0 && nx <= N && ny > 0 && ny <= N && map[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny));
                    dis[nx][ny] = dis[poll.x][poll.y] + 1;
                }
            }
        }

        return false;
    }

    static int findGuest() {
        //택시의 현재 위치에 손님이 있는 경우
        if (map[taxiPos.x][taxiPos.y] > 0) {
            int guest = map[taxiPos.x][taxiPos.y];
            map[taxiPos.x][taxiPos.y] = 0;
            return guest;
        }

        Queue<Pos> q = new LinkedList<>();
        int[][] dis = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N+1][N+1];

        q.offer(taxiPos);
        visited[taxiPos.x][taxiPos.y] = true;

        int minDis = Integer.MAX_VALUE; int lastX = 0; int lastY = 0;
        boolean flag = true;

        while (!q.isEmpty()) {
            if (!flag) break;

            Pos poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i]; int ny = poll.y + dy[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= N && map[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dis[nx][ny] = dis[poll.x][poll.y] + 1;

                    if (dis[nx][ny] > minDis) {
                        flag = false;
                        break;
                    }

                    if (map[nx][ny] > 0) {
                        if (dis[nx][ny] < minDis) {
                            minDis = dis[nx][ny]; lastX = nx; lastY = ny;
                        }

                        if (dis[nx][ny] == minDis ) {
                            if (nx == lastX) {
                              if (ny < lastY) {
                                  minDis = dis[nx][ny]; lastX = nx; lastY = ny;
                              }
                            } else if (nx < lastX){
                                minDis = dis[nx][ny]; lastX = nx; lastY = ny;
                            }

                        }
                    } else {
                        q.offer(new Pos(nx, ny));
                    }
                }
            }
        }

        if (minDis == Integer.MAX_VALUE) return -1;

        if (fuel < minDis) return -1;

        int guest = map[lastX][lastY];
        fuel -= minDis;
        taxiPos.x = lastX; taxiPos.y = lastY;
        map[taxiPos.x][taxiPos.y] = 0;
        return guest;
    }
}
