package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//미로의 최단거리 통로(BFS)
public class Main8_11 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    //예습 풀이
    public static int bfs(int[][] board) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(1, 1));
        board[1][1] = 1;
        int level = 0;

        while(!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Position pos = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = pos.x + dx[j];
                    int ny = pos.y + dy[j];

                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                        if (nx == 7 && ny == 7) {
                            return level+1;
                        }

                        board[nx][ny] = 1;
                        q.offer(new Position(nx, ny));
                    }
                }
            }

            level++;
        }

        return -1;
    }


    //강의 풀이
    public static void bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));
        board[x][y] = 1;

        while (!q.isEmpty()) {
            Position pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Position(nx, ny));
                    dis[nx][ny] = dis[pos.x][pos.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        board  = new int[8][8];
        dis = new int[8][8];

        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(br.readLine());


            for (int j = 1; st.hasMoreTokens(); j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(bfs(board));

        bfs(1,1);

        if (dis[7][7] == 0)
            System.out.println(-1);
        else
            System.out.println(dis[7][7]);

        br.close();
    }
}
