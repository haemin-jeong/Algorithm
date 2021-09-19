package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[26];
        Arrays.fill(answer, -1);

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (answer[s.charAt(i) - 97] == -1) {
                answer[s.charAt(i) - 97] = i;
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
