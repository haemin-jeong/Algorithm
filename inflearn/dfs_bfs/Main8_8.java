package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수열 추측하기
public class Main8_8 {

    static int[][] memo = new int[11][11];
    static boolean[] checked;
    static int[] answer, arr;
    static int n, f;
    static boolean flag = false;

    //조합수 구하기
    public static int combination(int n, int r) {
        if (memo[n][r] > 0)
            return memo[n][r];

        if (n == r || r == 0)
            return 1;
        else {
            memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
            return memo[n][r];
        }
    }

    public static void dfs(int level, int sum) {
        if (flag)
            return;

        if (level == n && sum == f) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            flag = true;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    answer[level] = i;
                    dfs(level+1, sum + arr[level]*answer[level]);
                    checked[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        arr = new int[n];
        answer = new int[n];
        checked = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            arr[i] = combination(n-1, i);
        }

        dfs(0, 0);

        br.close();
    }
}
