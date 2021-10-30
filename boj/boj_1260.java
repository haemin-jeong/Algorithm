package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    
    static boolean[] check;
    static int[][] board;
    static int n;

    public static void dfs(int num) {

        System.out.print(num + " ");

        for (int i = 1; i <= n; i++) {
            if (board[num][i] == 1 && !check[i]) {
                check[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        check[num] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            System.out.print(poll + " ");

            for (int i = 1; i <= n; i++) {
                if (board[poll][i] == 1 && !check[i]) {
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        check = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 1;
            board[b][a] = 1;
        }

        check[v] = true;
        dfs(v);
        System.out.println();

        Arrays.fill(check, false);

        bfs(v);
    }
}
