package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        list.stream().distinct()
                .sorted((s1, s2) -> {
                    if (s1.length() == s2.length()) {
                        return s1.compareTo(s2);
                    } else {
                        return s1.length() - s2.length();
                    }
                })
                .forEach(s -> sb.append(s).append("\n"));

        System.out.println(sb);
    }
}
