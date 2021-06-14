package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//부분집합 구하기(DFS)
public class Main7_6 {

    static int n;
    static boolean[] checked;

    public static void dfs(int L) {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (checked[i]) sb.append(i + " ");
            }

            if (sb.length() > 0)
                System.out.println(sb.toString());
        } else {
            checked[L] = true;
            dfs(L + 1);
            checked[L] = false;
            dfs(L+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        checked = new boolean[n+1]; //숫자 그대로를 인덱스로 사용하기위해 +1

        dfs(1);

        br.close();
    }
}
