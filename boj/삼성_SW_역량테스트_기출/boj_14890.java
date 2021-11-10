package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14890 {

    static int n, l;
    static int[][] board;

    private static boolean isRoad(int pos, boolean isRow) {
        int[] road = new int[n];
        boolean[] check = new boolean[n]; //경사로 체크

        //road 배열에 board 배열의 검사 대상 행 또는 열 복사
        for (int i = 0; i < n; i++) {
            road[i] = isRow ?  board[pos][i] : board[i][pos];
        }

        for (int i = 0; i < n-1; i++) {

            //인접한 칸의 높이차가 1보다 크면 실패
            if (Math.abs(road[i] - road[i + 1]) > 1) {
                return false;
            }

            //내리막 경사로 검사
            if (road[i] - road[i + 1] == 1) {
                for (int j = i + 1; j < i + 1 + l; j++) {
                    if (j >= n || road[i+1] != road[j] || check[j]) {
                        return false;
                    }

                    check[j] = true;
                }
            }

            //오르막 경사로 검사
            if (road[i+1] - road[i] == 1) {
                for (int j = i; j > i - l; j--) {
                    if (j < 0 || road[i] != road[j] || check[j]) {
                        return false;
                    }

                    check[j] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (isRoad(i, true)) {
                answer++;
            }

            if (isRoad(i, false)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
