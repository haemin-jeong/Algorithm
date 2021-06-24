package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토(BFS 활용)
public class Main8_12 {
    static Queue<Point> q = new LinkedList<>();

    public static int bfs(int m, int n, int[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] dis = new int[n][m];

        //익어있는 토마토가 없어 토마토들이 익을 수 없음
        if (q.isEmpty())
            return -1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 0) {
                    dis[x][y] = dis[p.x][p.y] + 1;
                    board[x][y] = 1;
                    q.offer(new Point(x, y));
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) //안익은 토마토가 있다면,
                    return -1;
            }
        }

        //dis가 모두 0이면 새로 익은 토마토가 없다는것. 즉, 토마토가 저장될 때부터 모두 익어있는 경우
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(dis[i][j], answer);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; st.hasMoreTokens(); j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                //탐색의 출발점이 여러개이기 때문에 익은 토마토들을 미리 큐에 넣어놓는다.
                if (board[i][j] == 1)
                    q.offer(new Point(i, j));
            }
        }

        System.out.println(bfs(m, n, board));

        br.close();
    }
}
