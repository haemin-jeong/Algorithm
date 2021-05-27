package inflearn.hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//학급회장
public class Main4_1 {

    public static char solution(int n, char[] arr) {
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            count[arr[i]-65]++;
        }

        int maxIdx = 0, maxCnt = count[0];

        for (int i = 1; i < n; i++) {
            if (maxCnt < count[i]) {
                maxIdx = i;
                maxCnt = count[maxIdx];
            }
        }

        return (char)(maxIdx+65);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i);
        }

        System.out.println(solution(n, arr));

        br.close();
    }
}
