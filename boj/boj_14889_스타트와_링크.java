package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889_스타트와_링크 {
    static int[][] board;
    static boolean[] check;
    static int n, min=Integer.MAX_VALUE;
    static boolean flag = false;

    public static void dfs(int level, int s) {
        if (flag) return;

        if (level == n/2) {
            int start = 0; //스타트팀 능력
            int link = 0; //링크팀 능력

            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if (check[i] && check[j]) {
                        start += (board[i][j] + board[j][i]);
                    } else if(!check[i] && !check[j]) {
                        link += (board[i][j] + board[j][i]);
                    }
                }
            }

            min = Math.min(min, Math.abs(start - link));

            if (min == 0) {
                flag = true;
            }
        } else {
            for (int i = s; i < n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    dfs(level + 1, i+1);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        check = new boolean[n];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);

        br.close();
    }
}
