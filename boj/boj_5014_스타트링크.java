package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014_스타트링크 {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static int bfs() {
        int level = 0;
        Queue<Integer> q = new LinkedList<>();

        q.offer(S);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int current = q.poll();

                if (current == G) {
                    return level;
                }

                if ((current + U) <= F && !visited[current + U]) {
                    visited[current + U] = true;
                    q.offer(current + U);
                }

                if ((current - D) >= 1 && !visited[current - D]) {
                    visited[current - D] = true;
                    q.offer(current - D);
                }
            }

            level++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); //가장 높은 층
        S = Integer.parseInt(st.nextToken()); //from
        G = Integer.parseInt(st.nextToken()); //to
        U = Integer.parseInt(st.nextToken()); //up
        D = Integer.parseInt(st.nextToken()); //down
        visited = new boolean[F + 1];

        int answer = bfs();
        System.out.println(answer == -1 ? "use the stairs" : answer);

        br.close();
    }
}
