package inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대 부분 증가수열
public class Main10_3 {

    public static int solution(int n, int[] arr) {
        int[] dy = new int[n];
        int answer = 0;
        dy[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max)
                    max = dy[j];
            }

            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, arr));

        br.close();
    }
}
