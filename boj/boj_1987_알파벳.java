package boj;

import java.io.*;
import java.util.*;

public class boj_1987_알파벳 {
    static int max = 0;
    static int r, c;
    static char[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] check = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        String s = "";
        for (int i = 0; i < r; i++) {
            s = br.readLine();

            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        check[arr[0][0] - 'A'] = true;
        dfs(1, 0, 0);

        System.out.println(max);

        br.close();
    }

    public static void dfs(int level, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (!check[arr[nx][ny] - 'A']) {
                    check[arr[nx][ny] - 'A'] = true;
                    dfs(level + 1, nx, ny);
                    check[arr[nx][ny] - 'A'] = false;
                }
            }
        }

        max = Math.max(max, level);
    }
}
