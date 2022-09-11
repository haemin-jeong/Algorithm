package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> numFromName = new HashMap<>();
        String[] nameFromNum = new String[n+1];

        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            numFromName.put(name, i);
            nameFromNum[i] = name;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String question = br.readLine();

            if (Character.isDigit(question.charAt(0))) {
                sb.append(nameFromNum[Integer.parseInt(question)]);
            } else {
                sb.append(numFromName.get(question));
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
