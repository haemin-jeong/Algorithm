package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            /*
            - dy[i][0] : 자연수 i의 0 출력 횟수
            - dy[i][1] : 자연수 i의 1 출력 횟수
            - 자연수의 범위가 0~40이기 때문에 dy 배열 행의 길이를 41로 설정
             */
            int[][] dy = new int[41][2];

            //0과 1의 0,1 출력 횟수 저장
            dy[0][0] = 1; dy[0][1] = 0;
            dy[1][0] = 0; dy[1][1] = 1;

            for (int j = 2; j <= n; j++) {
                dy[j][0] = dy[j - 1][0] + dy[j - 2][0];
                dy[j][1] = dy[j - 1][1] + dy[j - 2][1];
            }

            sb.append(dy[n][0]).append(" ").append(dy[n][1]).append("\n");
        }

        System.out.println(sb);
    }
}
