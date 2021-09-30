package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            //층수
            int h = Integer.parseInt(st.nextToken());

            //각 층당 방수, 입력으로 주어졌지만 사용되지 않는 값
            int w = Integer.parseInt(st.nextToken());

            //n번째 손님
            int n = Integer.parseInt(st.nextToken());

            /*
            보통의 경우 n%h의 값이 층수를 나타내지만, n%h가 0인 경우 실제로는 꼭대기 층이지만 0층이 되버린다.
            그렇기 떄문에 n%h가 0이라면 꼭대기층으로하는 조건을 추가.
            YXX, YYXX 형태이기 떄문에 * 100
             */
            int y = n%h == 0 ? h*100 : n%h*100; //층

            /*
            보통의 경우 n/h+1 로 호수를 계산할 수 있지만, n/h가 딱 나누어 떨어지는 경우 실제 n/h 호이다.
            그렇기 때문에 n%h == 0 인 경우 n/h호로 하는 조건을 추가.
             */
            int x = n%h == 0 ? n/h : n/h + 1; //호수

            sb.append(y + x).append("\n");
        }

        System.out.println(sb);
    }
}
