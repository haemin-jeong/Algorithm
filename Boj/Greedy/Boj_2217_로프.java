// Date : 2020-10-13
//Link : https://www.acmicpc.net/problem/2217

package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2217_로프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ropes = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        Arrays.sort(ropes);

        for (int i = 0; i < n; i++) {
            int value = ropes[i] * (n - i);

            if (max < value) {
                max = value;
            }
        }

        System.out.println(max);
    }
}
