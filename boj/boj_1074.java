package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074 {
    static int n, r, c;
    static int answer = 0;
    static boolean isStop = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recur(0, 0, (int)Math.pow(2, n));

        System.out.println(answer);
    }

    static void recur(int x, int y, int len) {
        if (isStop) {
            return;
        }

        if(x == r && y == c) {
            isStop = true;
            return;
        }

        if (r < x + len && r >= x && c < y + len && c >= y) {
            recur(x, y, len / 2);
            recur(x, y + len / 2, len / 2);
            recur(x + len / 2, y, len / 2);
            recur(x + len / 2, y + len / 2, len / 2);
        } else {
            answer += len * len;
        }
    }
}
