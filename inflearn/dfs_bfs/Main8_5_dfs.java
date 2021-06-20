package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//동전 교환 - DFS로 풀이
public class Main8_5_dfs {
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int level, int sum, Integer[] coins) {
        if (sum > m)
            return;

        if (level >= answer)
            return;

        if (sum == m) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(level + 1, sum + coins[i], coins);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Integer[] coins = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; st.hasMoreTokens(); i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        //큰금액부터 탐색하여 시간을 줄이기위해 내림차순 정렬
        //주의 : Collections.reverseOrder()를 사용하려면 기본타입을 래퍼타입으로 바꿔서 사용해야한다.
        Arrays.sort(coins, Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());

        dfs(0, 0, coins);

        System.out.println(answer);


        br.close();
    }
}
