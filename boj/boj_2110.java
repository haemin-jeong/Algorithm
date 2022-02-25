package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110 {

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int max = binarySearch();
        System.out.println(max);
    }

    static int binarySearch() {
        int s = 1; int e = arr[N-1] - arr[0];
        int maxDis = Integer.MIN_VALUE;

        while(s <= e) {
            int mid = (s + e) / 2;

            int count = 1; int last = arr[0];
            for (int i = 1; i < N; i++) {
                if ((arr[i] - last) >= mid) {
                    count++; last = arr[i];
                }
            }

            if (count >= C) {
                maxDis = Math.max(maxDis, mid);
                s = mid+1;
            }
            else e = mid-1;
        }

        return maxDis;
    }
}
