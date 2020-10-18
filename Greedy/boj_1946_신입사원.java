// Date: 2020-10-18
// Link: https://www.acmicpc.net/problem/1946

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Employee> list = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                list.add(new Employee(paper, interview));
            }

            Collections.sort(list, (e1, e2) -> e1.paper - e2.paper);

            int count = 1;
            int high = list.get(0).interview;
            for (int k = 1; k < n; k++) {
                if (list.get(k).interview < high) {
                    count++;
                    high = list.get(k).interview;
                }
            }
            list.clear();
            System.out.println(count);
        }
    }
}

class Employee {
    int paper;
    int interview;

    public Employee(int paper, int interview) {
        this.paper = paper;
        this.interview = interview;
    }
}
