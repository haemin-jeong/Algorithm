package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int mIndex = 0;
        int pIndex = n - 1;

        for (; mIndex < pIndex; mIndex += 2) {
            if (arr[mIndex] < 1 && arr[mIndex + 1] < 1) {
                sum += arr[mIndex] * arr[mIndex + 1];
            } else {
                break;
            }
        }

        for (; pIndex > 0; pIndex -= 2) {
            if (arr[pIndex] > 1 && arr[pIndex - 1] > 1) {
                sum += arr[pIndex] * arr[pIndex - 1];
            } else {
                break;
            }
        }

        for (; pIndex >= mIndex; pIndex--) {
            sum += arr[pIndex];
        }

        System.out.println(sum);
    }
}
