package inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//동전교환(냅색 알고리즘)
public class Main10_5 {

    public static int solution(int n, int m, int[] coins) {
        int[] dy = new int[m+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i = 0; i < n; i++) {

            for (int j = coins[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coins[i]] + 1);
            }
        }

        return dy[m];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        System.out.println(solution(n, m, coins));

        br.close();
    }
}
