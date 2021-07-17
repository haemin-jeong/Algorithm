package boj;//풀이 날짜 : 2020-12-27
//문제 출처 : https://www.acmicpc.net/problem/7568

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        List<Person> list = new ArrayList<>();
        int n  = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new Person(weight, height));
        }

        for (int i = 0; i < n; i++) {
            int order = 1;
            for (int j = 0; j < n; j++) {

                if ((list.get(i).weight < list.get(j).weight) && (list.get(i).height < list.get(j).height))
                    order++;

            }

            sb.append(order + " ");
        }

        System.out.println(sb.toString());
    }
}

class Person{
    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}
