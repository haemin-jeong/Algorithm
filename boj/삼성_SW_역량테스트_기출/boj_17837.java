package boj.삼성_SW_역량테스트_기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17837 {
    static class Piece {
        int x; int y; int dir;

        public Piece(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static int N, K;
    static int[] dx = {-1, 0, 0, -1, 1};
    static int[] dy = {-1, 1, -1, 0, 0};
    static Piece[] pieces;
    static int[][] boardColors;
    static List<Integer>[][] board;
    static final int WHITE = 0, RED=1, BLUE = 2;
    static final int RIGHT = 1, LEFT = 2, UP = 3, DOWN=4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pieces = new Piece[K + 1];
        boardColors = new int[N + 1][N + 1];
        board = new List[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                boardColors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pieces[i] = new Piece(x, y, d);
            board[x][y].add(i);
        }

        System.out.println(move());
    }

    static int move() {
        int turn = 1;
        while (turn <= 1000) {

            for (int i = 1; i <= K; i++) {
                Piece piece = pieces[i];

                List<Integer> list = board[piece.x][piece.y];
                int idx = list.indexOf(i);

                int nx = piece.x + dx[piece.dir]; int ny = piece.y + dy[piece.dir];

                //이동할 칸이 보드의 범위를 벗어나거나 파란색 칸인 경우 방향을 반대로 바꾼다.
                if (nx < 1 || nx > N || ny < 1 || ny > N
                        || boardColors[nx][ny] == BLUE) {
                    piece.dir = getReverseDir(piece.dir);
                    nx = piece.x + dx[piece.dir]; ny = piece.y + dy[piece.dir];
                }

                //방향을 바꿨음에도 불구하고 이동할 칸이 범위를 벗어나거나 파란색 칸인 경우 아무것도 하지 않는다.
                if (nx <1 || nx > N || ny < 1 || ny > N || boardColors[nx][ny] == BLUE) {
                    continue;
                }

                if (boardColors[nx][ny] == WHITE) {
                    for (int j = idx; j < list.size(); j++) {
                        int num = list.get(j);
                        movePiece(num, nx, ny);
                    }
                } else if (boardColors[nx][ny] == RED) {
                    for (int j = list.size()-1; j >= idx; j--) {
                        int num = list.get(j);
                        movePiece(num, nx, ny);
                    }
                }

                if (board[nx][ny].size() >= 4) return turn;

                for (int j = list.size()-1; j >= idx; j--) list.remove(j);
            }

            turn++;
        }

        return -1;
    }

    /**
     * num 번 말을 (nx,ny)로 이동
     */
    private static void movePiece(int num, int nx, int ny) {
        pieces[num].x = nx;
        pieces[num].y = ny;
        board[nx][ny].add(num);
    }

    static int getReverseDir(int dir) {
        if (dir == LEFT) return RIGHT;
        else if (dir == RIGHT) return LEFT;
        else if (dir == UP) return DOWN;
        else return UP;
    }
}
