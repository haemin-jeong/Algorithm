package inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이분 검색
public class Main6_8 {

    public static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == m)
                return mid+1;
            else if (arr[mid] > m)
                right = mid-1;
            else
                left = mid + 1;
        }

        return -1;
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
