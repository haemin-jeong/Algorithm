package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14502 {

    static boolean[][] check;
    static int[][] board;
    static int n, m;
    static List<Pos> virus;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int[][] board) {
        Queue<Pos> queue = new LinkedList<>();

        for (Pos pos : virus) {
            queue.offer(pos);
        }

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            board[pos.x][pos.y] = 2;

            for (int i = 0 ; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    queue.offer(new Pos(nx, ny));
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    static int max = Integer.MIN_VALUE;

    public static void dfs(int level) {
        if (level == 3) {
            int[][] copyBoard = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (check[i][j]) {
                        copyBoard[i][j] = 1;
                    } else {
                        copyBoard[i][j] = board[i][j];
                    }
                }
            }

            max = Math.max(max, bfs(copyBoard));

        } else {
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!check[i][j] && board[i][j]  == 0) {
                        check[i][j] = true;
                        dfs(level+1);
                        check[i][j] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        virus = new ArrayList<>(); //바이러스의 위치를 저장해놓는다.

        check = new boolean[n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) {
                    virus.add(new Pos(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(max);
    }

}
