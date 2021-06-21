package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합의 경우수(메모이제이션)
public class Main8_7 {

    //이미 계산했던 값을 재사용하기위해 저장해놓는 곳
    static int[][] memo = new int[34][34];

    public static int dfs(int n, int r) {
        if (memo[n][r] > 0)
            return memo[n][r];

        if (n==r || r == 0) 
            return 1;
        else {
            memo[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
            return memo[n][r];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(dfs(n, r));

        br.close();
    }
}
