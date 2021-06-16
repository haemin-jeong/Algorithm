package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//경로 탐색(인접행렬)
public class Main7_12 {

    static int[][] graph;
    static int[] checked; //방문 노드를 체크하는 용도
    static int n;
    static int answer;

    public static void dfs(int from) {

        if (from == 5)
            answer++;
        else {
            for (int i = 1; i <= n; i++) {
                if (graph[from][i] == 1 && checked[i] == 0) {
                    checked[i] = 1;
                    dfs(i);
                    checked[i] = 0; //i번 노드 방문이 끝났기 때문에 0으로
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        checked = new int[n + 1];
        answer = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = 1;
        }

        checked[1] = 1;
        dfs(1);

        System.out.println(answer);

        br.close();
    }
}
