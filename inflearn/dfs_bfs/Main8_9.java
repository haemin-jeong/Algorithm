package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 구하기
public class Main8_9 {

    static int n, m;
    static int[] conbination;

    public static void dfs(int level, int start) {
        if (level == m) {
            for (int i : conbination) {
                System.out.print(i + " ");
            }
            System.out.println();

        } else {
            for (int i = start; i <= n; i++) {
                conbination[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        conbination = new int[m];

        dfs(0, 1);

        br.close();
    }
}
