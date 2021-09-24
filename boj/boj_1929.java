package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //배열 인덱스는 숫자를 나타내고 true이면 해당 숫자는 소수
        boolean[] isPrimes = new boolean[n+1];
        Arrays.fill(isPrimes, true);
        isPrimes[1] = false; //1은 소수가 아니다.

        StringBuilder sb = new StringBuilder();

        //에라토스테네스의 체 알고리즘을 사용하여 2~n 구간의 소수 찾기
        for (int i = 2; i <= n; i++) {
            if (isPrimes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (isPrimes[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
