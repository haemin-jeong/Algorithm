package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1389 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            graph.get(f1).add(f2);
            graph.get(f2).add(f1);
        }

        int answer = 0;
        int minCount = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int count = getKevinBaconNum(i);

            if (count < minCount) {
                answer = i;
                minCount = count;
            }
        }

        System.out.println(answer);
    }

    static int getKevinBaconNum(int target) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);
        dis[target] = 0;

        while (!q.isEmpty()) {
            Integer num = q.poll();

            for (int i : graph.get(num)) {
                if (dis[i] == -1) {
                    dis[i] = dis[num] + 1;
                    q.offer(i);
                }
            }
        }

        return Arrays.stream(dis).sum();
    }
}
