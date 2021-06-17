package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//그래프 최단거리(BFS) - 트리의 레벨을 이용한 풀이
public class Main7_14 {

    static int[][] graph;
    static int n;
    static int[] checked;

    public static int bfs(int to) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        checked[1] = 1;
        int level = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int v = q.poll();
                checked[v] = 0;

                for (int j = 1; j <= n; j++) {
                    if (graph[v][j] == 1 && checked[j] == 0) {

                        if (j == to)
                            return level+1;

                        checked[j] = 1;
                        q.offer(j);
                    }
                }
            }

            level++;
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        checked = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = 1;
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + bfs(i));
        }

        br.close();
     }

}

/*
입력 예
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
*/
