package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), null);
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                answer.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        answer.stream().sorted().forEach(s -> sb.append(s).append("\n"));
        System.out.println(sb);
    }
}
