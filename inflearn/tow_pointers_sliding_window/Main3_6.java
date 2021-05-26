package inflearn.tow_pointers_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최대 길이 연속부분수열
public class Main3_6 {

    public static int solution(int n, int k, int[] arr) {
        int answer = 0, left = 0, count = 0;

        for (int right = 0; right < n; right++) {

            if (arr[right] == 0) {
                count++;
            }

            while (count > k) {

                if (arr[left] == 0) {
                    count--;
                }

                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }
}
