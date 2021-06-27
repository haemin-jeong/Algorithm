package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int vertex;
    int distance;

    public Edge(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}

//다익스트라 알고리즘
public class Main9_5 {

    static List<List<Edge>> graph = new ArrayList<>();
    static int distance[];

    public static void solution(int v) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        distance[v] = 0;

        while (!pq.isEmpty()) {
            Edge temp = pq.poll();
            int curVertex = temp.vertex;
            int curDistance = temp.distance;

            if (curDistance > distance[curVertex])
                continue;

            for (Edge e : graph.get(curVertex)) {
                if (distance[e.vertex] > e.distance + curDistance) {
                    distance[e.vertex] = e.distance + curDistance;
                    pq.offer(new Edge(e.vertex, e.distance + curDistance));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //정점의 수
        int m = Integer.parseInt(st.nextToken()); //간선의 수

        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(to, distance));
        }

        solution(1);

        for (int i = 2; i <= n; i++) {
            if (distance[i] != Integer.MAX_VALUE)
                System.out.println(i + " : " + distance[i]);
            else
                System.out.println(i + " : impossible");
        }

        br.close();
    }
}
