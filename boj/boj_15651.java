package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15651 {
    static int[] combi;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        combi = new int[M];
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        System.out.println(sb);
    }

    static void dfs(int l, StringBuilder sb) {
        if(l == M) {
            for (int i = 0; i < M; i++) {
                sb.append(combi[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                combi[l] = i;
                dfs(l+1, sb);
            }
        }
    }
}
