package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        //이진 탐색은 정렬이 되어있어야 히기때문에 오름차순 정렬
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            /*
            Arrays.binarySearch 메서드는 값을 찾으면 그 값의 위치를 반환하고,
            값을 찾지 못하면 만약 그 값이 있었다면 정렬 순서상 있어야되는 위치에 -1을 곱하고 1을 뺀 값을 반환한다.
            */
            if (Arrays.binarySearch(nArr, num) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
