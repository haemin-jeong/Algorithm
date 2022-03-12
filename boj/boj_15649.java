package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15649 {

    static boolean[] checked;
    static int[] pm;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        checked = new boolean[n+1];
        pm = new int[m];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int level) {
        if (level == m) {
            for (int num : pm) sb.append(num).append(" ");
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    pm[level] = i;
                    dfs(level+1);
                    checked[i] = false;
                }
            }
        }
    }
}

