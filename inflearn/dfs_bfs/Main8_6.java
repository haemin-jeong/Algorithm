package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순열 구하기
public class Main8_6 {

    static int n, m;
    static int[] permutation;
    static boolean[] checked; //순열안의 숫자 중복을 방지

    public static void dfs(int level, int[] arr) {
        if (level == m) {
            for (int i : permutation) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {

            for (int i = 0; i < n; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    permutation[level] = arr[i];
                    dfs(level + 1, arr);
                    checked[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        permutation = new int[m];
        checked = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, arr);

        br.close();
    }
}
