package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //시험장 개수
        int[] a = new int[n]; //각 시험장 응시자 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken()); //총감독관 감시 인원
        int c = Integer.parseInt(st.nextToken()); //부감독관 감시 인원

        //필요한 감독관 수, 총 감독관 수를 미리 더해놓았다, long형 주의!
        long answer = n;

        //i번째 강의실의 부감독관 수 구하기
        for (int i = 0; i < n; i++) {

            //총 감독관 한명으로 감시가 가능하면 부감독관 필요X.
            if (a[i] <= b) {
                continue;
            }

            int temp = (a[i] - b)/c;

            /*
            총 감독관이 감시하는 응시생 수를 제외한 나머지 응시생 수를
            1명의 부감독관이 감시할 수 있는 응시생 수로 나눴는데
            나머지가 생기면 부감독관을 한명 더 추가해야한다.
            예: 응시생 수가 8명이고 부감독관이 감시 가능한 인원이 7명이면 부감독관은 8/7=1명이 아니라 2명이된다.
            */
            if ((a[i] - b) % c != 0) {
                temp++;
            }

            answer += temp;
        }

        System.out.println(answer);
    }
}
