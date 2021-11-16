package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15685 {

    private static class Pos {
        int x;
        int y;
        int d;

        public Pos(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, -0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[101][101];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            makeDragonCurve(board, x, y, d, g);
        }

        int answer = calculateSquareCount(board);

        System.out.println(answer);
    }

    private static void makeDragonCurve(boolean[][] board, int x, int y, int d, int g) {
        List<Pos> list = new ArrayList<>();

        list.add(new Pos(x + dx[d], y + dy[d], d));

        for (int i = 0; i < g; i++) {
            int size = list.size();
            Pos last = list.get(size - 1);
            int lastX = last.x;
            int lastY = last.y;

            for (int j = size-1; j >= 0; j--) {
                Pos pos = list.get(j);
                int direction = changeDirection(pos.d);
                lastX = lastX + dx[direction];
                lastY = lastY + dy[direction];
                list.add(new Pos(lastX, lastY, direction));
            }
        }

        writeDragonCurveToBoard(board, x, y, list);
    }

    private static int changeDirection(int d) {
        return d == 3 ? 0 : (d+1);
    }

    private static void writeDragonCurveToBoard(boolean[][] board, int x, int y, List<Pos> list) {
        board[x][y] = true;

        for (Pos pos : list) {
            board[pos.x][pos.y] = true;
        }
    }

    private static int calculateSquareCount(boolean[][] board) {
        int count = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isSquare(board, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSquare(boolean[][] board, int i, int j) {
        return board[i][j] && board[i +1][j] && board[i][j +1] && board[i +1][j +1];
    }
}
