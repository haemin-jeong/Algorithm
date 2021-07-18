package boj;

import java.io.*;
import java.util.*;

public class boj_2667_단지번호붙이기 {
    static int width = 0;
    static int n;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0; //총 단지수
        List<Integer> list = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    count++; width++;
                    board[i][j] = 0;
                    dfs(i, j);
                    list.add(width);
                    width = 0;
                }
            }
        }

        System.out.println(count);
        list.stream().sorted().forEach(System.out::println);

        br.close();
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dfs(nx, ny);
                width++;
            }
        }
    }
}
