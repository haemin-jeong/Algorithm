package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2606_바이러스 {
    static List<List<Integer>> graph;
    static int numOfComputer, numOfLine;
    static boolean[] checked;

    public static void dfs(int computer) {
        for (int i = 0; i < graph.get(computer).size(); i++) {
            int current = graph.get(computer).get(i);
            if (!checked[current]) {
                checked[current] = true;
                dfs(current);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numOfComputer = Integer.parseInt(br.readLine());
        numOfLine = Integer.parseInt(br.readLine());
        checked = new boolean[numOfComputer+1];
        graph = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i <= numOfComputer; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = null;
        for (int i = 0; i < numOfLine; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        checked[1] = true;
        dfs(1);

        //1번을 제외한 컴퓨터 개수이기때문에 2부터
        for (int i = 2; i < checked.length; i++) {
            if (checked[i]) answer++;
        }

        System.out.println(answer);

        br.close();
    }
}
