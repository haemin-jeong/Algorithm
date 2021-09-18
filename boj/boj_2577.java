package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        num *= Integer.parseInt(br.readLine());
        num *= Integer.parseInt(br.readLine());

        int[] count = new int[10];

        for (char c : String.valueOf(num).toCharArray()) {
            count[Character.getNumericValue(c)]++;
        }

        for (int i : count) {
            System.out.println(i);
        }
    }
}
