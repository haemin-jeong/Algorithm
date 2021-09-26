package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        //아파트는 최대 14층, 14호까지
        //배열 인덱스를 층과 맞추기위해 + 1
        int[][] arr =  new int[15][15];

        for (int i = 1; i < 15; i++) {
            //0층의 i호에는 i명
            arr[0][i] = i;

            //모든 층의 1호는 1이다.
            arr[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) { //층
            for (int j = 2; j < 15; j++) { //호
                //i층 j호는 i층의 j-1호에 i-1층의 j호를 더한 값
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(arr[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}
