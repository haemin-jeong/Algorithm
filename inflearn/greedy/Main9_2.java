package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end)
            return this.start - o.start;
        else
            return this.end - o.end;
    }
}

//회의실 배정
public class Main9_2 {

    public static int solution(int n, List<Meeting> list) {
        int count = 0;
        int endTime = 0;

        Collections.sort(list);

        for (Meeting m : list) {
            if (m.start >= endTime) {
                endTime = m.end;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>();

        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Meeting(start, end));
        }

        System.out.println(solution(n, list));

        br.close();
    }
}
