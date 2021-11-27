package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_17140 {

    private static int columnLength = 3, rowLength = 3;
    private static final int[][] board = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int seconds = 0;

        while(seconds <= 100) {

            if (board[r][c] == k) {
                System.out.println(seconds);
                return;
            }

            if (rowLength >= columnLength) { // R연산
                calculateR();
            } else { // C연산
                calculateC();
            }

            seconds++;
        }

        System.out.println(-1);
    }

    static class Count implements Comparable<Count>{
        int num;
        int count;

        public Count(int num, int count) {
            this.num = num;
            this.count = count;
        }


        @Override
        public int compareTo(Count o) {
            if (o.count == this.count) {
                return this.num - o.num;
            }
            return this.count - o.count;
        }

    }

    private static void calculateR() {
        int[] count = null;
        PriorityQueue<Count> pq = new PriorityQueue<>();

        for (int i = 1; i <= rowLength; i++) {
            count = new int[101];

            for (int j = 1 ; j <= columnLength; j++) {
                count[board[i][j]]++;
            }

            for (int  j = 1; j <= 100; j++) {
                if (count[j] > 0) {
                    pq.offer(new Count(j, count[j]));
                }
            }

            Arrays.fill(board[i], 1, columnLength+1, 0);

            int index = 1;
            while(!pq.isEmpty()) {
                Count poll = pq.poll();
                board[i][index++] = poll.num;
                board[i][index++] = poll.count;

                if (index >= 100) break;
            }

            columnLength = Math.max(columnLength, index-1);
        }
    }

    private static void calculateC() {
        int[] count = null;
        PriorityQueue<Count> pq = new PriorityQueue<>();

        for (int i = 1; i <=columnLength; i++) {
            count = new int[101];

            for (int j = 1; j <= rowLength; j++) {
                count[board[j][i]]++;
            }

            for (int j = 1; j <= 100; j++) {
                if (count[j] > 0) {
                    pq.offer(new Count(j, count[j]));
                }
            }

            for (int j = 1; j <= rowLength; j++) {
                board[j][i] = 0;
            }

            int index = 1;
            while(!pq.isEmpty()) {
                Count poll = pq.poll();
                board[index++][i] = poll.num;
                board[index++][i] = poll.count;

                if (index >= 100) break;
            }

            rowLength = Math.max(rowLength, index-1);
        }
    }
}
