package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_14225 {
    
    static int n;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    public static void dfs(int level, int sum) {
        if (level == n) {
            set.add(sum);
        } else {
            dfs(level + 1, sum + arr[level]);
            dfs(level + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        int answer = 1;
        while (true) {
            if (set.contains(answer)) {
                answer++;
            } else {
                System.out.println(answer);
                return;
            }
        }
    }
}
