package programmers.level2;

public class 다음_큰_숫자 {
    public int solution(int n) {
        int nCount = getBinaryOneCount(n);
        int answer = n+1;

        while(getBinaryOneCount(answer) != nCount) {
            answer++;
        }

        return answer;
    }

    private int getBinaryOneCount(int num) {
        int count = 0;

        while(num >= 1) {
            if(num%2 == 1) {
                count++;
            }

            num /= 2;
        }

        return count;
    }
}
