package inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//마구간 정하기(결정 알고리즘)
public class Main6_10 {

    private static int count(int distance, int[] arr) {
        int count = 1;
        int pos = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - pos) >= distance) {
                count++;
                pos = arr[i];
            }
        }

        return count;
    }

    private static int solution(int n, int c, int[] arr) {
        Arrays.sort(arr);

        int answer = 0;
        int left = 1; //최소 거리
        int right = arr[n - 1]; //최대 거리

        while (left <= right) {
            int mid = (left + right) / 2;

            if (count(mid, arr) >= c) {
                answer = mid;
                left = mid+1;
            } else
                right = mid-1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, c, arr));
    }

}
