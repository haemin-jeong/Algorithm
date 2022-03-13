package programmers.level3.디스크_컨트롤러;

import java.util.*;

class Solution {
    static class Job implements Comparable<Job>{
        int start;
        int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Job j) {
            return this.time - j.time;
        }
    }

    public int solution(int[][] jobs) {
        Job[] jobArr = new Job[jobs.length];

        for(int i = 0; i < jobs.length; i++) jobArr[i] = new Job(jobs[i][0], jobs[i][1]);

        Arrays.sort(jobArr, (j1, j2) -> {
            if(j1.start == j2.start) return j1.time - j2.time;
            return j1.start - j2.start;
        });

        PriorityQueue<Job> pq = new PriorityQueue<>();
        pq.offer(jobArr[0]);

        int cTime = jobArr[0].start;
        int idx = 1;
        int answer = 0;

        while(!pq.isEmpty()) {
            Job job = pq.poll();

            cTime += job.time;
            answer += cTime - job.start;

            while(idx < jobs.length && jobArr[idx].start <= cTime) {
                pq.offer(jobArr[idx++]);
            }

            if(idx < jobs.length && pq.isEmpty()) {
                cTime = jobArr[idx].start;
                pq.offer(jobArr[idx++]);
            }
        }

        return answer/jobs.length;
    }
}

