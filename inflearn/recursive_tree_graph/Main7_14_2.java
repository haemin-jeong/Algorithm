package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//그래프 최단거리(BFS) - 각 정점의 최소거리를 저장하는 배열을 만들어서 풀이(강의 풀이 방식)
//2차원 최단거리 문제가 나오면 해당 풀이와 같이 배열을 사용해서 풀이한다.
public class Main7_14_2 {

    static int n;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] distance;

    public static void bfs(int v) {
        int[] checked = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        checked[v] = 1;
        distance[v] = 0;

        while (!q.isEmpty()) {
            int curV = q.poll();

            for (int nextV : graph.get(curV)) {
                if (checked[nextV] == 0) {
                    checked[nextV] = 1;
                    q.offer(nextV);
                    distance[nextV] = distance[curV] + 1; //(1번 정점에서 현재 정점까지의 거리) + 1
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + distance[i]);
        }

        br.close();
    }
}
