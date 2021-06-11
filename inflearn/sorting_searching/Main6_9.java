package inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//뮤직비디오(결정 알고리즘)
public class Main6_9 {

    //capacity 용량을 받아 dvd를 만들면 몇장으로 만들어지는지를 반환하는 메서드
    public static int count(int[] arr, int capacity) {
        int count = 1;
        int sum = 0;

        for (int i : arr) {
            if (sum + i > capacity) {
                count++;
                sum = i;
            } else {
                sum += i;
            }
        }

        return count;
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();

        //이진 검색으로 최소 용량 크기를 찾는다.
        while (left <= right) {
            int mid = (left + right) / 2;

            if (count(arr, mid) <= m) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

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

        System.out.println(solution(n, m , arr));
    }
}
