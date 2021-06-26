package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Speech implements Comparable<Speech> {
    int money;
    int day;

    public Speech(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Speech o) {
        return o.day - this.day;
    }
}

//최대 수입 스케줄(PriorityQueue 응용문제)
public class Main9_4 {

    static int max; //가장 긴 날짜

    public static int solution(int n, List<Speech> list) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);

        int cur = 0;
        for (int i = max; i >= 1; i--) {

            for (; cur < n; cur++) {
                if (list.get(cur).day < i)
                    break;

                pq.offer(list.get(cur).money);
            }

            if (!pq.isEmpty())
                answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        max = 0;
        List<Speech> list = new ArrayList<>();

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            max = Math.max(max, d);

            list.add(new Speech(m, d));
        }

        System.out.println(solution(n, list));

        br.close();
    }
}
