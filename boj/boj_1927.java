package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                pq.offer(num);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
