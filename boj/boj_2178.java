package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int bfs(char[][] board, int n, int m) {
        Queue<Pos> q = new LinkedList<>();

        //dis[i][j] : (i,j) 칸까지 오는데 지나온 칸수,
        //dis[i][j] > 0은 이미 지나온 길이라는 뜻이므로 (i,j) 칸은 탐색을 진행하지 않는다.
        int[][] dis = new int[n+1][m+1];

        q.offer(new Pos(1, 1));
        dis[1][1] = 1;

        while(!q.isEmpty()) {
            Pos temp = q.poll();

            /*
            i == 0 : 위쪽으로 이동하는 경우
            i == 1 : 오른쪽으로 이동하는 경우
            i == 2 : 아래쪽으로 이동하는 경우
            i == 3 : 왼쪽쪽으로 이동하는 경우
             */
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx == n && ny == m) {
                    return dis[temp.x][temp.y] + 1;
                }

                //좌표 값이 배열의 범위안이고, 이동할 수 있는 칸이고, 지나온 칸이 아닌 경우
                if (nx > 0 && nx <= n && ny > 0 && ny <= m && board[nx][ny] == '1' && dis[nx][ny] == 0) {
                    q.offer(new Pos(nx, ny));
                    dis[nx][ny] = dis[temp.x][temp.y] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int j = 1; j <= m; j++) {
                board[i][j] = chars[j-1];
            }
        }

        System.out.println(bfs(board, n, m));
    }
}
