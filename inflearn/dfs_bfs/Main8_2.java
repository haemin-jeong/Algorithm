package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//바둑이 승차(DFS)
public class Main8_2 {

    static int c, n;
    static int max = 0;

    public static void dfs(int level, int sum, int[] arr) {
        if (sum > c)
            return;

        if (level == n)
            max = Math.max(max, sum);
         else {
            dfs(level + 1, sum + arr[level], arr);
            dfs(level + 1, sum, arr);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0, arr);

        System.out.println(max);

        br.close();
    }
}
