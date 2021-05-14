package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//격자판 최대합
public class Main2_9 {

    //예습 풀이
    public static int solution(int n, int[][] arr) {
        int max = -1;
        int sum = 0;

        //가로 합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }

            if (sum > max) {
                max = sum;
            }

            sum = 0;
        }

        //세로 합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[j][i];
            }

            if (sum > max) {
                max = sum;
            }

            sum = 0;
        }



        //좌상-우하 대각선 합
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
        }

        if (sum > max) {
            max = sum;
        }

        sum = 0;


        //우상-좌 대각선 합
        for (int i = 0; i < n; i++) {
            int j = n;
            sum += arr[i][--j];
        }

        if (sum > max) {
            max = sum;
        }

        return max;
    }

    //강의에서 풀이 방식
    //가로,세로를 묶어서, 두 대각선을 묶어서 각각 한번에 처리함으로써 내풀이 비해 반복 횟수가 반으로 줄음
    //최대값 판단시 Math.max 메서드 사용
    public static int solution2(int n, int[][] arr) {
        int max = -1;
        int sum1=0, sum2=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j]; //가로 합
                sum2 += arr[j][i]; //세로 합
            }

            max = Math.max(Math.max(max, sum1), sum2);
            sum1=sum2=0;
        }

        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i]; //좌상-우하 대각선 합
            sum2 += arr[i][n-1-i]; //우상-좌하 대각선 합
        }

        max = Math.max(Math.max(max, sum1), sum2);

        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; st.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        System.out.println(solution(n, arr));
    }
}
