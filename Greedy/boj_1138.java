// 날짜 : 2020-10-29
// 출처 : https://www.acmicpc.net/problem/1138

package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] src = new int[n];
        ArrayList<Integer> result = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i > 0; i--) {
            result.add(src[i - 1], i);
        }

        for (int i : result) {
            System.out.printf("%d ", i);
        }
    }
}
