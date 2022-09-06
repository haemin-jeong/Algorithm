package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m  = Integer.parseInt(br.readLine());
        int set = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            switch (command) {
                case "add":
                    set |= (1 << num-1);
                    break;
                case "remove":
                    set &= ~(1 << num-1);
                    break;
                case "check":
                    sb.append((set & (1 << num - 1)) > 0 ? "1" : "0").append("\n");
                    break;
                case "toggle":
                    set ^= (1 << num-1);
                    break;
                case "all":
                    set = (1 << 20) - 1;
                    break;
                case "empty":
                    set = 0;
            }
        }

        System.out.println(sb);
    }
}
