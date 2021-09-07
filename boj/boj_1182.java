package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182 {
    static int n, s;
    static int[] arr;
    static int count = 0;

    public static void dfs(int level, int sum) {
        if (level == n) {
            if (sum == s) {
                count++;
            }
        } else {
            dfs(level+1, sum+arr[level]);
            dfs(level+1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        //s가 0이면 공집합인 경우에도 count++이 되기 때문에
        if (s == 0) {
            count--;
        }

        System.out.println(count);
    }
}
