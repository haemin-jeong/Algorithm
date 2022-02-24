package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {

    static boolean binarySearch(int[] arr, int target) {
        int left = 0; int right = arr.length-1;

        while (left <= right) {
            int center = (left+right)/2;

            if (arr[center] == target) return true;
            else if (arr[center] < target) left = center+1;
            else right = center-1;
        }

        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr1, target) ? "1" : "0").append("\n");
        }

        System.out.println(sb);
    }
}
