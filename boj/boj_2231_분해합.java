package boj;//풀이 날짜 : 2020-12-24
//문제 출처 : https://www.acmicpc.net/problem/2231


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = n; i > 0; i--) {
            int sum = i;
            int temp = i;
            while(temp > 0) {
                sum += temp%10;
                temp /= 10;
            }

            if(sum == n)
                result = i;
        }

        System.out.println(result);
    }
}
