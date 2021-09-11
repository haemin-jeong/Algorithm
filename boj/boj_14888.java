package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {

    static int n;
    static int[] operator, arr;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void dfs(int level, int sum) {
        if (level == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        } else {

            //+
            if (operator[0] > 0) {
                operator[0]-=1;
                dfs(level + 1, sum + arr[level]);
                operator[0]+=1;
            }

            //-
            if (operator[1] > 0) {
                operator[1]-=1;
                dfs(level+1, sum - arr[level]);
                operator[1]+=1;
            }

            //*
            if (operator[2] > 0) {
                operator[2]-=1;
                dfs(level+1, sum  * arr[level]);
                operator[2]+=1;
            }

            // /
            if (operator[3] > 0) {
                operator[3] -= 1;
                dfs(level+1, sum / arr[level]);
                operator[3] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        operator = new int[4];
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
}
