package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//원더랜드(최소 스패닝 트리) - 크루스칼 알고리즘
public class Main9_7_1 {

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    //집합을 표현. 배열의 인덱스는 정점 번호, 값은 집합의 번호
    static int[] unf;

    //정점의 집합 번호 반환
    public static int find(int v) {
        if (unf[v] == v)
            return v;
        else
            return unf[v] = find(unf[v]);
    }

    //두 정점을 같은 집합으로
    public static void union(int v1, int v2) {
        int findV1 = find(v1);
        int findV2 = find(v2);

        if (findV1 != findV2)
            unf[findV1] = findV2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //도시의 개수
        int e = Integer.parseInt(st.nextToken()); //도로의 개수
        int sum = 0;

        List<Edge> list = new ArrayList<>(e);
        unf = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a, b, c));
        }

        Collections.sort(list);

        for (int i = 0; i < e; i++) {
            Edge findEdge = list.get(i);

            //두 정점을 연결했을 때 회로를 형성하지 않으면(같은 집합이 아니라면)
            if (find(findEdge.v1) != find(findEdge.v2)) {
                union(findEdge.v1, findEdge.v2);
                sum += findEdge.cost;
            }

        }

        System.out.println(sum);

        br.close();
    }
}
