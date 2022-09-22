package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int order = 0;
        Map<Integer, Integer> orderMap = new HashMap<>();

        for (int i : sorted) {
            if (!orderMap.containsKey(i)) {
                orderMap.put(i, order++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(orderMap.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
