package inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//삽입 정렬
public class Main6_3 {

    public static void solution(int n, int[] arr) {

        //i를 기준으로 앞쪽은 정렬이 된 곳
        for (int i = 1; i < n; i++) {
            int temp = arr[i];

            int j = 0;
            //정렬 대상보다 큰 수들을 한칸씩 뒤로 밀며 대상의 자리를 찾는다.
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(n, arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
