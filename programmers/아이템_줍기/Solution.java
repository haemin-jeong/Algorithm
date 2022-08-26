package programmers.아이템_줍기;

import java.util.*;

class Solution {
    int[][] map, dis;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        dis = new int[101][101];

        characterX *= 2; characterY *= 2;
        itemX *= 2; itemY *= 2;

        initMap(rectangle);
        bfs(characterX, characterY, itemX, itemY);

        return dis[itemY][itemX] / 2;
    }

    void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(characterX, characterY));
        dis[characterY][characterX] = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx == itemX && ny == itemY) {
                    dis[ny][nx] = dis[p.y][p.x];
                    return;
                }

                if(nx > 0 && nx <= 100 && ny > 0 && ny <= 100
                        && map[ny][nx] == 1 && dis[ny][nx] == 0) {
                    q.offer(new Point(nx, ny));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
            }
        }
    }

    void initMap(int [][] rectangle) {
        for(int[] r : rectangle) {
            int lx = r[0] * 2; int ly = r[1] * 2;
            int rx = r[2] * 2; int ry = r[3] * 2;

            for(int i = lx; i <= rx; i++) {
                if(map[ry][i] == 0) map[ry][i] = 1;
                if(map[ly][i] == 0) map[ly][i] = 1;
            }

            for(int i = ly; i <= ry; i++) {
                if(map[i][rx] == 0) map[i][rx] = 1;
                if(map[i][lx] == 0) map[i][lx] = 1;
            }

            for(int i = ly + 1; i < ry; i++) {
                for(int j = lx + 1; j < rx; j++) {
                    map[i][j] = 2;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
