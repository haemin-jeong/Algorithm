package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_22251 {
    static int[][] nums = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1},
    };

    static int[][] diffCount = new int[10][10];
    static int[] targetLed;
    static int n, k, p, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        targetLed = convertToLedArr(x);
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }

            if (isConvertable(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean isConvertable(int num) {
        int[] tempLed = convertToLedArr(num);

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (diffCount[targetLed[i]][tempLed[i]] == 0 && x != num) {
                diffCount[targetLed[i]][tempLed[i]] = diffCount[targetLed[i]][tempLed[i]] = getDiffCount(
                        targetLed[i], tempLed[i]);
            }

            count += diffCount[targetLed[i]][tempLed[i]];

            if (count > p) {
                return false;
            }
        }
        return true;
    }

    static int getDiffCount(int n1, int n2) {
        int count = 0;
        for (int l = 0; l < 7; l++) {
            if (nums[n1][l] != nums[n2][l]) {
                count++;
            }
        }

        return count;
    }

    static int[] convertToLedArr(int num) {
        int[] arr = new int[k];

        for (int i = k - 1; i >= 0 &&  num > 0; i--) {
            arr[i] = num % 10;
            num /= 10;
        }

        return arr;
    }
}
