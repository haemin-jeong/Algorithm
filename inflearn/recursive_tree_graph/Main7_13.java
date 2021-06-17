package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//경로 탐색(인접리스트)
public class Main7_13 {

    static int n;
    static List<List<Integer>> graph;
    static int[] checked;
    static int answer = 0;

    public static void dfs(int v) {
        if (v == n)
            answer++;
        else {
            for (int nextV : graph.get(v)) {
                if (checked[nextV] == 0) {
                    checked[nextV] = 1;
                    dfs(nextV);
                    checked[nextV] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        checked = new int[n+1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        checked[1] = 1;
        dfs(1);

        System.out.println(answer);

        br.close();
    }
}
