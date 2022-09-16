package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int count = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();

            for (int j = 0; j < count; j++) {
                String key = br.readLine().split(" ")[1];
                clothes.put(key, clothes.getOrDefault(key, 0) + 1);
            }

            int answer = 1;
            for (int n : clothes.values()) {
                answer *= (n + 1);
            }
            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }
}
