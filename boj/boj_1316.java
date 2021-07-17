// 날짜 : 2020-10-26
// 출처 : https://www.acmicpc.net/problem/1316

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (checkWord(br.readLine())) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean checkWord(String word) {
        boolean[] check = new boolean[26];
        char c = ' ';
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                continue;
            }

            if (check[word.charAt(i) - 97]) {
                return false;
            }

            check[word.charAt(i) - 97] = true;
            c = word.charAt(i);
        }

        return true;
    }
}
