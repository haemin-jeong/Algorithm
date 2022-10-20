package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1753 {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dis;
    static int v, e, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        init(br);
        dijkstra();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void init(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, w));
        }

        dis = new int[v + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        dis[k] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.value > dis[now.num]) {
                continue;
            }

            for (Node node : graph.get(now.num)) {
                if (dis[node.num] > (now.value + node.value)) {
                    dis[node.num] = now.value + node.value;
                    pq.offer(new Node(node.num, dis[node.num]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
