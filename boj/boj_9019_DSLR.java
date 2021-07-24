package boj;

import java.util.*;
import java.io.*;

public class boj_9019_DSLR {
    static boolean[] visited;

    public static String bfs(int from, int to) {
        Queue<Result> q = new LinkedList<>();
        q.offer(new Result(from, ""));
        visited[from] = true;

        while (!q.isEmpty()) {
            Result result = q.poll();

            if (result.register == to) {
                return result.command;
            }

            int D = result.register * 2 > 9999 ? result.register * 2 % 10000 : result.register * 2;
            if (!visited[D]) {
                visited[D] = true;
                q.offer(new Result(D, result.command + "D"));
            }

            int S = result.register == 0 ? 9999 : result.register - 1;
            if (!visited[S]) {
                visited[S] = true;
                q.offer(new Result(S, result.command + "S"));
            }

            int L = result.register % 1000 * 10 + result.register / 1000;
            if (!visited[L]) {
                visited[L] = true;
                q.offer(new Result(L, result.command + "L"));
            }

            int R = result.register / 10 + result.register % 10 * 1000;
            if (!visited[R]) {
                visited[R] = true;
                q.offer(new Result(R, result.command + "R"));
            }

        }

        return "";
    }

    static class Result {
        int register;
        String command;

        public Result(int value, String command) {
            this.register = value;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answer = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            answer.add(bfs(from, to));
        }

        answer.forEach(System.out::println);

        br.close();
    }
}
