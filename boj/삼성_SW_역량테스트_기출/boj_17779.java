package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17779 {

    static int[][] board;
    static boolean[][] check;
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int allPopulation = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                allPopulation += board[i][j];
            }
        }

        for (int x = 1; x < N; x++) {
            for (int y = 1; y < N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    if (y - d1 < 0) continue;

                    for (int d2 = 1; d2 <= N; d2++) {
                        if (x + d1 +d2 > N || y+d2 > N) break;
                        checkBoundary(x, y, d1, d2);
                        calculate(x, y, d1, d2);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    /**
     * 경계선을 체크한다.
     */
    static void checkBoundary(int x, int y, int d1, int d2) {
        check = new boolean[N + 1][N + 1];

        int j = y;
        for (int i = x; i < x + d1; i++) {
            check[i][j--] = true;
        }

        j = y;
        for (int i = x; i < x + d2; i++) {
            check[i][j++] = true;
        }

        j = y - d1;
        for (int i = x + d1; i <= x + d1 + d2; i++) {
            check[i][j++] = true;
        }

        j = y+d2;
        for (int i = x + d2; i <= x + d1 + d2; i++) {
                check[i][j--] = true;
        }
    }

    /**
     * 각 선거구의 인구합을 구하고 최대값, 최소값 차를 구한다.
     */
    static void calculate(int x, int y, int d1, int d2) {
        int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
        int fivePopulation = allPopulation;

        //1번 선거구 인구합
        int sum = 0;
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (check[i][j]) break;
                sum += board[i][j];
            }
        }

        fivePopulation -= sum;
        min = Math.min(min, sum); max = Math.max(max, sum);

        //2번 선거구 인구합
        sum = 0;
        for (int i = 1; i <= x + d2; i++) {
            for (int j = N; j > y && !check[i][j]; j--) {
                sum += board[i][j];
            }
        }

        fivePopulation -= sum;
        min = Math.min(min, sum); max = Math.max(max, sum);

        //3번 선거구 인구합
        sum = 0;
        for (int i = x + d1; i <= N; i++) {
            for (int j = 1; j < y - d1 + d2 && !check[i][j]; j++) {
                sum += board[i][j];
            }
        }

        fivePopulation -= sum;
        min = Math.min(min, sum); max = Math.max(max, sum);

        //4번 선거구 인구합
        sum = 0;
        for (int i = x + d2 + 1; i <= N; i++) {
            for (int j = N; j >= y - d1 + d2 && !check[i][j]; j--) {
                sum += board[i][j];
            }
        }
        min = Math.min(min, sum); max = Math.max(max, sum);

        fivePopulation -= sum; //5번 선거구 인구합
        min = Math.min(min, fivePopulation); max = Math.max(max, fivePopulation);

        answer = Math.min(answer, max - min);
    }
}
