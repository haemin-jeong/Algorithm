package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2-7 점수 계산
public class Main2_7 {

    /**
     * @param n : 문제 갯수
     * @param arr : 각 문제 채점 결과
     * @return : 총점
     */
    public static int solution(int n, int[] arr) {
        int sum = 0;
        int score = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                sum+=score;
                score++;
            } else { //오답일 경우 연속 정답이 끊기는 것이기 떄문에 얻을 점수를 1로 초기화
                score = 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, arr));
    }
}
