package boj;

import java.io.*;
import java.util.*;

public class boj_2583_영역_구하기 {
    static int width = 0;
    static int m, n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int x, int y, int[][] board) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 0) {
                board[nx][ny] = 1;
                width++;
                dfs(nx, ny, board);
            }
        }
    }

    //(lx, ly) ~ (rx, ry) 영역을 1로 채우는 메서드
    public static void fillSection(int lx, int ly, int rx, int ry, int[][] board) {
        for (int i = lx; i < rx; i++) {
            for (int j = ly; j < ry; j++) {
                board[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> widths = new ArrayList<>();
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ly = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());

            int ry = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());

            fillSection(lx, ly, rx, ry, board);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    count++; width++;

                    dfs(i, j, board);

                    widths.add(width);

                    width = 0;
                }
            }
        }

        System.out.println(count);
        widths.stream().sorted().forEach(i -> System.out.print(i + " "));

        br.close();
    }
}
