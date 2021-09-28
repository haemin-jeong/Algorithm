package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        //i는 5kg 봉지 개수
        for (int i = 0; i <= n / 5; i++) {
            int temp = n;

            temp -= i * 5;

            //5kg 봉지 i개일 때 3kg 봉지 개수가 몇개이든 n kg로 딱 나누어 떨어지지않는다면
            if (temp % 3 != 0) {
                continue;
            }

            //총 봉지 개수 : i개의 5kg 봉지 + (n - i*5)/3 개의 3kg 봉지

            min = Math.min(min, i + temp/3);
        }

        //정확하게 n kg을 만들 수 없는 경우 min 값은 초기값 그대로
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
