package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] weights = new int[n];
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < n; j++) {

                if (weights[j] > weights[i] && heights[j] > heights[i]) {
                    count++;
                }
            }

            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}
