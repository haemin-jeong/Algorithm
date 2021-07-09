package programmers.level2;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while(pq.peek() < K) {
            if(pq.size() == 1) return -1;

            int n1 = pq.poll();
            int n2 = pq.poll();

            int sum = n1 + (n2*2);

            pq.offer(sum);

            count++;
        }

        return count;
    }
}
