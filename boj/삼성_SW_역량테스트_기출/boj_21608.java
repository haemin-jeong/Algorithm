package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_21608 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] board, friends;

    /**
     * student 번 학생의 자리를 찾는 메서드
     */
    public static void solution(int student) {
        int maxEmpty = 0;
        int maxLike = 0;
        int x = 0;
        int y = 0;

        /*
        3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        - 3번 조건을 만족 시키기위해 i,j가 0부터 탐색하는 것이 아닌 역순으로 탐색을 진행하여 앉을 자리 위치를 찾는다.
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board[i][j] != 0) { //이미 누군가 앉은 자리면 넘어간다.
                    continue;
                }

                //student를 (i,j)에 배치했을 때 빈칸 개수, 좋아하는 학생 수
                int empty = 0;
                int like = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (board[nx][ny] == 0) {
                            empty++;
                        } else {
                            for (int l = 0; l < 4; l++) {
                                if (board[nx][ny] == friends[student][l]) {
                                    like++;
                                }
                            }
                        }
                    }
                }

                /*
                1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
                2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
                 */
                if (maxLike < like || (maxLike == like && maxEmpty <= empty)) {
                    maxLike = like;
                    maxEmpty = empty;
                    x = i; y = j;
                }
            }
        }

        //student 번 학생의 자리는 (x,y)
        board[x][y] = student;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        //행: 학생번호, 열: 행번호 학생이 좋아하는 학생 번호
        friends = new int[n*n+1][4];

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                friends[student][j] = Integer.parseInt(st.nextToken());
            }

            solution(student);
        }

        //만족도 계산
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int student = board[i][j];
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    for (int l = 0; l < 4; l++) {
                        if (board[nx][ny] == friends[student][l]) {
                            count++;
                        }
                    }
                }

                if (count == 1) {
                    answer++;
                } else if (count == 2) {
                    answer += 10;
                } else if (count == 3) {
                    answer += 100;
                } else if (count == 4) {
                    answer += 1000;
                }
            }
        }

        System.out.println(answer);
    }
}
