package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20057 {
    //왼, 아래, 우, 위
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    //모래가 퍼지는 위치 : 두칸 앞, 한칸 오른쪽 위, 한칸 왼쪽 위, 두칸 오른쪽, 두칸 왼쪽, 한칸 오른쪽, 한칸 왼쪽, 오른쪽 아래 한칸 , 왼쪽 아래 한칸
    private static int[][] spreadX = {
            {0, -1, 1, -2, 2, -1, 1, -1, 1},
            {2, 1, 1, 0, 0, 0, 0, -1, -1},
            {0, 1, -1, 2, -2, 1, -1, 1, -1},
            {-2, -1, -1, 0, 0, 0, 0, 1, 1}
    };

    private static int[][] spreadY = {
            {-2, -1, -1, 0, 0, 0, 0, 1, 1},
            {0, -1, 1, -2, 2, -1, 1, -1, 1},
            {2, 1, 1, 0, 0, 0, 0, -1, -1},
            {0, 1, -1, 2, -2, 1, -1, 1, -1}
    };

    private static int[] spreadPercentage = {5, 10, 10, 2, 2, 7, 7, 1, 1};

    private static int[][] map;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int direction = 0;
        int distance = 1;
        int i =  0;
        int x = n/2, y = n/2;
        int outSend = 0;

        while (true) {
            for (int j = 0; j < distance; j++) {
                x += dx[direction];
                y += dy[direction];

                int sand = map[x][y];
                map[x][y] = 0;
                int remainSand = sand;

                for (int k = 0; k < 9; k++) {
                    int nx = x + spreadX[direction][k];
                    int ny = y + spreadY[direction][k];
                    int temp = (sand * spreadPercentage[k])/100;

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        outSend += temp;
                    }  else {
                        map[nx][ny] += temp;
                    }

                    remainSand -= temp;
                }

                int ax = x + dx[direction];
                int ay = y + dy[direction];

                if (ax < 0 || ax >= n || ay < 0 || ay >= n) {
                    outSend += remainSand;
                }  else {
                    map[ax][ay] += remainSand;
                }

                if (x == 0 && y == 0) {
                    System.out.println(outSend);
                    return;
                }
            }

            direction = changeDirection(direction);

            i++;

            if(i%2 == 0) {
                distance++;
            }
        }
    }

    private static int changeDirection(int direction) {
        return (direction == 3) ? 0 : (direction + 1);
    }
}
