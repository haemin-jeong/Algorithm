package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals("0 0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a){
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }

        System.out.println(sb);
    }
}
