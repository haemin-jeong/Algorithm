package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//동전 교환 - BFS로 풀이
public class Main8_5_bfs {

    public static int bfs(int n, int m, int[] coins) {
        Queue<Integer> q = new LinkedList<>();
        int level = 1;

        for (int i = 0; i < n; i++) {
            q.offer(coins[i]);
        }

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int poll = q.poll();

                if (poll < m) {
                    for (int j = 0; j < n; j++) {
                        int next = poll + coins[j];

                        if (next == m)
                            return level+1;

                        q.offer(next);
                    }
                }
            }

            level++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; st.hasMoreTokens(); i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        System.out.println(bfs(n, m, coins));

        br.close();
    }
}
