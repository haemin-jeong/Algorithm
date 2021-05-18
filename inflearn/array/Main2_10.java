package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//봉우리
public class Main2_10 {

    public static int solution(int n, int[][] arr) {
        int count = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if ((arr[i][j+1] < arr[i][j]) && (arr[i][j-1] < arr[i][j]) && (arr[i+1][j] < arr[i][j]) && (arr[i-1][j] < arr[i][j])) {
                    count++;
                }
            }
        }

        return count;
    }


    public static int solution2(int n, int[][] arr) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x >= 0 && x < n && y >= 0 && y < n && arr[x][y] >= arr[i][j]) { //테두리일때를 제외하고 봉우리가 아닐경우
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+2][n+2]; //가장자리가 0으로 초기화되어야 하기때문에 +2

        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; st.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        int[][] arr = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; st.hasMoreTokens(); j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }

        System.out.println(solution2(n, arr));
    }
}
