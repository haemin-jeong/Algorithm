package inflearn.tow_pointers_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연속 부분수열
public class Main3_4 {

    //예습 풀이
    public static int solution(int n, int m, int[] arr) {
        int start = 0, end = 0;
        int answer = 0, sum = 0;
        int count = 0;

        while (start < n) {

            count++;

            if (end >= n) {
                start++;
                end = start;
                sum = 0;
                continue;
            }

            sum += arr[end];

            if (sum == m) {
                answer++;
                start++;
                end = start;
                sum = 0;
            } else if (sum > m) {
                start++;
                end = start;
                sum = 0;
            } else {
                end++;
            }
        }

        System.out.println("solution = " + count);
        return answer;
    }

    //복습 풀이
    public static int solution2(int n, int m, int[] arr) {

        int count = 0;
        int answer = 0, sum = 0, left = 0;

        for (int right = 0; right < n; right++) {
            count++;
            sum += arr[right];

            if (sum == m) {
                answer++;
            }

            while (sum >= m) {
                count++;
                sum -= arr[left++];
                if (sum == m) {
                    answer++;
                }
            }
        }

        System.out.println("solution2 = " + count);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));

        br.close();
    }
}
