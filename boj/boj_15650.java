package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15650 {
    static int[] combi;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combi = new int[M];
        dfs(0, 1);
    }

    static void dfs(int l, int s) {
        if(l == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(combi[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= N; i++) {
                combi[l] = i;
                dfs(l+1, i+1);
            }
        }
    }
}
