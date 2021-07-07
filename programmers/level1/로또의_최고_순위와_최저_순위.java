package programmers.level1;

public class 로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int winCount = 0;

        for(int i : lottos)  {
            if(i == 0) zeroCount++;
            else {
                for(int j : win_nums)
                    if(i == j) winCount++;
            }
        }

        //Math.min 사용 이유 : 0의 개수보다 남은 당첨 숫자 번호가 더 적을수 있기 때문에
        int maxCount = winCount + Math.min(lottos.length - winCount, zeroCount);
        int minCount = winCount;

        return new int[]{getRank(maxCount), getRank(minCount)};
    }

    /**
     * @param winCount : 당첨된 번호 개수
     * @return : 등수
     */
    public int getRank(int winCount) {
        if(winCount == 6) return 1;
        else if(winCount == 5) return 2;
        else if(winCount == 4) return 3;
        else if(winCount == 3) return 4;
        else if(winCount == 2) return 5;
        else return 6;
    }
}
