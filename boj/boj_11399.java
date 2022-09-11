package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line);

        int answer = 0;
        int cur = 0;
        for (int m : line) {
            cur += m;
            answer += cur;
        }

        System.out.println(answer);
    }
}
