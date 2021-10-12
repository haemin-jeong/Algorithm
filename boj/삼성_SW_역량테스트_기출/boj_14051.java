package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];
        int[] dy = new int[n+1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            //상담을 완료한 날짜가 n일을 넘으면 안된다.
            if (i + t[i] <= n) {
                dy[i + t[i]] = Math.max(dy[i + t[i]], dy[i] + p[i]);
            }

            //다음 날의 수입이 전날의 수입에 이어져 같을 수 있다.
            dy[i+1] = Math.max(dy[i], dy[i+1]);
        }

        //dy[n] : n번째 날까지의 최대 수입
        System.out.println(dy[n]);
    }
}
