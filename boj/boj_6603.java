package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603 {

    static StringBuilder sb = new StringBuilder();
    static int[] combi;
    static int k;
    static int[] arr;

    public static void dfs(int level, int start) {
        if (level == 6) {
            for (int i : combi) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i < k; i++) {
                combi[level] = i;
                dfs(level+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            String s = br.readLine();

            if (s.equals("0")) {
                break;
            }

            st = new StringTokenizer(s);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            combi = new int[6];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
