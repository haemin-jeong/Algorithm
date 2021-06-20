package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복순열 구하기
public class Main8_4 {

    static int[] permutation;
    static int n, m;

    public static void dfs(int level) {
        if (level == m) { //m번을 뽑았을때,
            for (int i : permutation) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                permutation[level] = i;
                dfs(level + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        permutation = new int[m];

        dfs(0);

        br.close();
    }
}
