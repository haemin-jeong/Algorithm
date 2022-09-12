package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dy = new int[11];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for (int j = 4; j <= 10; j++) {
            dy[j] = dy[j-1] + dy[j-2] + dy[j-3];
        }

        for (int i = 0; i < t; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(dy[target]).append("\n");
        }

        System.out.println(sb);
    }
}
