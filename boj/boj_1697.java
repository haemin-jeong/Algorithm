package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {
    static int[] dis = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) System.out.println(0);
        else System.out.println(bfs(N, K));
    }

    static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x + 1 >= 0 && x + 1 <= 100000 && dis[x+1] == 0) {
                if (x + 1 == k) return dis[x] + 1;
                dis[x+1] = dis[x] + 1;
                q.offer(x + 1);
            }

            if (x - 1 >= 0 && x - 1 <= 100000 && dis[x-1] == 0 ) {
                if (x - 1 == k) return dis[x] + 1;
                dis[x-1] = dis[x] + 1;
                q.offer(x - 1);
            }

            if (x * 2 >= 0 && x * 2 <= 100000 && dis[x*2] == 0) {
                if (x * 2 == k) return dis[x] + 1;
                dis[x * 2] = dis[x] + 1;
                q.offer(x * 2);
            }
        }

        return -1;
    }
}
