package programmers;

public class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int row = board.length;
        int col = board[0].length;
        int[][] mark = new int[row+1][col+1];

        for(int[] s : skill) {
            int type = s[0];
            int degree = type == 1 ? s[5] * -1 : s[5];
            int r1 = s[1]; int c1 = s[2];
            int r2 = s[3]; int c2 = s[4];

            mark[r1][c1] += degree;
            mark[r1][c2 + 1] += degree * -1;
            mark[r2 + 1][c1] += degree * -1;
            mark[r2 + 1][c2 + 1] += degree;
        }

        // 가로 누적합
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j < col; j++) {
                mark[i][j+1] += mark[i][j];
            }
        }

        // 세로 누적합
        for(int i = 0; i <= col; i++) {
            for(int j = 0; j < row; j++) {
                mark[j+1][i] += mark[j][i];
            }
        }

        int answer = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] + mark[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
