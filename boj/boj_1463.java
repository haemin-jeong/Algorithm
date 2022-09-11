package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_1463 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        System.out.println(bfs(n));
    }

    static int bfs(int n) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.num == 1) return node.count;

            if (node.num == 0)  continue;

            int num = node.num / 3;
            if(node.num % 3 == 0 && !visited[num]) {
                visited[num] = true;
                q.offer(new Node(num, node.count + 1));
            }

            num = node.num / 2;
            if (node.num % 2 == 0 && node.num / 3 > 0 && !visited[num]) {
                visited[num] = true;
                q.offer(new Node(num, node.count + 1));
            }

            if (!visited[node.num - 1]) {
                visited[node.num - 1] = true;
                q.offer(new Node(node.num - 1, node.count + 1));
            }
        }

        return -1;
    }

    static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
