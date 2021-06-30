package inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//돌다리 건너기
public class Main10_2 {

    public static int solution(int n) {
        int dy[] = new int[n + 2];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n+1; i++) {
            dy[i] = dy[i-1] + dy[i-2];
        }

        return dy[n+1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));

        br.close();
    }
}
