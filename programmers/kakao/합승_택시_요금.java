package programmers.kakao;

import java.util.*;

public class 합승_택시_요금 {
    List<List<Edge>> graph = new ArrayList<>();
    int n;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        for(int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] fare : fares) {
            graph.get(fare[0]).add(new Edge(fare[1], fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }

        int[] fromA = dijkstra(a);
        int[] fromB = dijkstra(b);
        int[] fromS = dijkstra(s);

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, fromA[i] + fromB[i] + fromS[i]);
        }

        return answer;
    }

    int[] dijkstra(int s) {
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));
        dis[s] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(dis[now.node] < now.cost) {
                continue;
            }

            for(Edge e : graph.get(now.node)) {
                if(dis[e.node] > dis[now.node] + e.cost) {
                    dis[e.node] = dis[now.node] + e.cost;
                    pq.offer(new Edge(e.node, dis[e.node]));
                }
            }
        }

        return dis;
    }

    class Edge implements Comparable<Edge>{
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
}
