package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16928 {
    static Map<Integer, Integer> moveMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < (n + m); i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            moveMap.put(from, to);
        }

        System.out.println(play());
    }

    static int play() {
        int[] dis = new int[101];
        boolean[] visited = new boolean[101];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= 6; i++) {
                int nextPos;
                if (moveMap.containsKey(cur + i)) {
                    nextPos = moveMap.get(cur + i);
                } else {
                    nextPos = cur + i;
                }

                if (nextPos == 100) {
                    return dis[cur] + 1;
                }

                if (!visited[nextPos]) {
                    q.offer(nextPos);
                    visited[nextPos] = true;
                    dis[nextPos] = dis[cur] + 1;
                }
            }
        }

        return -1;
    }
}
