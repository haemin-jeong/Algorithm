package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//등수 구하기
public class Main2_8 {

    /**
     * @param n : 학생 수
     * @param arr : 점수
     * @return 등수
     */
    public static int[] solution(int n, int[] arr) {
        int[] retArr = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    count++;
                }
            }

            retArr[i] = count;
        }

        return retArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
