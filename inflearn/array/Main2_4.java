package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2_4 {

    public static int[] solution(int n) {
        int[] fibo = new int[n];
        fibo[0] = 1; fibo[1] = 1;

        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] fibo = solution(n);

        for (int num : fibo) {
            System.out.print(num + " ");
        }
    }
}
