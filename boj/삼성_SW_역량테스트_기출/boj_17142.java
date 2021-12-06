package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17142 {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int n, m;
    private static int[][] board;
    private static Pos[] activeVirusLocations;
    private static List<Pos> virusLocations = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        activeVirusLocations = new Pos[m];
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) {
                    virusLocations.add(new Pos(i, j));
                }
            }
        }

        //초기 값이 이미 빈칸이 없는 경우
        if (isCompleteSpreadVirus(board)) {
            System.out.println(0);
            return;
        }

        dfs(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    /**
     * 어떤 위치에 활성 바이러스를 놓을지 결정
     */
    public static void dfs(int start, int level) {
        if (level == m) {
            bfs();
        } else {
            for (int i = start; i < virusLocations.size(); i++) {
                activeVirusLocations[level] = virusLocations.get(i);
                dfs(i+1, level+1);
            }
        }
    }

    /**
     * 어떤 위치에 활성 바이러스를 놓았을 때 바이러스가 퍼지는데 몇초가 걸리는지
     */
    public static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        int seconds = 1;
        int[][] copyBoard = copyBoard();

        for (Pos pos : activeVirusLocations) {
            copyBoard[pos.x][pos.y] = 4;
            q.offer(pos);
        }

        while (!q.isEmpty()) {
            if (seconds >= answer) {
                return;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pos temp = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = temp.x + dx[j];
                    int ny = temp.y + dy[j];

                    if (isBoardRange(nx, ny) && canBeActiveVirus(nx,ny, copyBoard)) {
                        copyBoard[nx][ny] = 4;
                        q.offer(new Pos(nx, ny));
                    }
                }
            }

            if (isCompleteSpreadVirus(copyBoard)) {

                answer = Math.min(answer, seconds);
                return;
            }

            seconds++;
        }
    }

    private static boolean canBeActiveVirus(int x, int y, int[][] board) {
        return board[x][y] == 0 || board[x][y] == 2;
    }

    private static int[][] copyBoard() {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, n);
        }

        return copy;
    }

    private static boolean isBoardRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static boolean isCompleteSpreadVirus(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
