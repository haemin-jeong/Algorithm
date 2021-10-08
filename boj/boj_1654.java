package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lanCables = new int[k];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            lanCables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanCables[i]);
        }

        long left = 1; //랜선의 길이는 자연수이기 때문에 1
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;
            int count = 0;

            for (int cable : lanCables) {
                count += (cable / mid);
            }

            if (count >= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //left 값은 n과 같거나 많은 랜 케이블을 만든 제일 큰 값에 +1 한 값
        System.out.println(left-1);
    }
}
