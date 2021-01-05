//풀이 날짜 : 2021-1-4
//문제 출처 : https://www.acmicpc.net/problem/1436

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1436_영화감독_숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;

        while (count < n) {

            String s = Integer.toString(++num);
            int sixCount = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '6') {
                    sixCount++;
                } else {
                    sixCount = 0;
                }

                if (sixCount >= 3) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(num);
    }
}
