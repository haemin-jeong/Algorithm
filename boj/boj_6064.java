package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(findYear(m ,n ,x, y)).append("\n");
        }

        System.out.println(sb);
    }

    static int findYear(int m, int n, int x, int y) {
        int limit = lcm(m, n);
        int i;
        for (i = x; i <= limit; i += m) {
            int remain = i % n == 0 ? n : i % n;
            if (remain == y) {
                break;
            }
        }
        return i > limit ? -1 : i;
    }

    static int lcm(int n1, int  n2) {
        return n1 * n2 / gcd(n1, n2);
    }

    static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}
