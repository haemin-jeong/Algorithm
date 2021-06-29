package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//원더랜드(최소 스패닝 트리) - 프림 알고리즘
public class Main9_7_2 {

    static class Edge implements Comparable<Edge>{
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //도시의 개수
        int e = Integer.parseInt(st.nextToken()); //도로의 개수

        List<List<Edge>> graph =new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //무방향 그래프기 때문에 양방향 모두 연결
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int sum = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] checked = new int[v+1]; //연결된 정점인지 확인하는 용도
        pq.offer(new Edge(1, 0)); //시작점 큐에 추가

        while (!pq.isEmpty()) {
            Edge findV = pq.poll();

            if (checked[findV.vertex] == 0) {
                checked[findV.vertex] = 1;
                sum += findV.cost;

                for (Edge edge : graph.get(findV.vertex)) {
                    if (checked[edge.vertex] == 0)
                        pq.offer(edge);
                }
            }
        }

        System.out.println(sum);

        br.close();
    }
}
