package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long[] sequence = new long[max+1];
        sequence[1] = sequence[2] = sequence[3] = 1L;
        for (int i = 4; i <= max; i++) {
            sequence[i] = sequence[i - 2] + sequence[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for(int n : arr) {
            sb.append(sequence[n]).append("\n");
        }

        System.out.println(sb);
    }

}
