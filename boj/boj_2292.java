package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int end = 2;
        int count = 1;

        while (end <= n) {
            end = end + 6 * count;
            count++;
        }

        System.out.println(count);
    }
}
