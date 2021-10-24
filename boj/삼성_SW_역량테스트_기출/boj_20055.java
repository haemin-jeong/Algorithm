package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belt = new int[n*2 + 1];
        boolean[] robots = new boolean[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n*2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;

        while(true) {
            int temp = belt[n*2];

            for(int i = n*2; i > 1; i--) {
                belt[i] = belt[i-1];
            }

            belt[1] = temp;

            for (int i = n; i > 1; i--) {
                robots[i] = robots[i-1];
            }

            robots[1] = false;

            if(robots[n]) {
                robots[n] = false;
            }

            for (int i = n-1; i > 0; i--) {
                if (robots[i] && !robots[i+1] && belt[i+1] >= 1) {
                    belt[i+1]--;
                    robots[i] = false;
                    robots[i+1] = true;
                }
            }

            if(robots[n]) {
                robots[n] = false;
            }

            if(belt[1] > 0) {
                robots[1] = true;
                belt[1]--;
            }

            int zeroCount = 0;
            for (int i = 1; i <= n * 2; i++) {
                if (belt[i] == 0) {
                    zeroCount++;
                }

                if (zeroCount >= k) {
                    System.out.println(answer);
                    return;
                }
            }

            answer++;
        }
    }
}
