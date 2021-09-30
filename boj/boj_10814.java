package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10814 {

    static class Member implements Comparable<Member>{
        int num;
        int age;
        String name;

        public Member(int num, int age, String name) {
            this.num = num;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.num - o.num;
            } else {
                return this.age - o.age;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];
        StringBuilder sb = new StringBuilder();

        int num = 0; //가입 순서 저장용

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members[i] = new Member(num++, age, name);
        }

        Arrays.sort(members);

        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.println(sb);
    }
}
