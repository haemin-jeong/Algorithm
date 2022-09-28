package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (n1, n2) -> Math.abs(n1) == Math.abs(n2) ? n1 - n2 : Math.abs(n1) - Math.abs(n2));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                if (pq.isEmpty()) {
                    sb.append("0");
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                pq.offer(command);
            }
        }

        System.out.println(sb);
    }
}
