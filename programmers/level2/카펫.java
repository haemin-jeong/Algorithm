package programmers.level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        //column, row : 노란 구역 컬럼, 행 길이
        for(int column = 1; column <= yellow; column++) {
            int row = yellow/column;

            /*
            노란 구역 행 길이*2 + 노란 구역 열 길이*2 + 4 = 갈색 구역 개수
            -> yellow/column*2 + column*2 + 4 = (yellow/column + column)*2 + 4 = brown
            */
            if(yellow%column == 0 && ((row+column)*2 + 4) == brown) {
                return new int[] {row+2, column+2};
            }
        }

        return null;
    }
}
