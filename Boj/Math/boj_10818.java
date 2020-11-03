//Date : 2020-10-26
//Link : https://www.acmicpc.net/problem/10818

package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(arr[i]);
            if (max < num) {
                max = num;
                continue;
            }

            if (min > num)
                min = num;
        }

        System.out.printf("%d %d\n", min, max);
    }
}
