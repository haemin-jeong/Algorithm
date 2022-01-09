package programmers.level2;

public class 숫자의_표현 {
    public int solution(int n) {
        int answer = 0;

        for(int right = 1; right <= n; right++) {
            int sum = 0;

            for(int left = right; left >= 1; left--) {
                sum += left;

                if(sum == n) {
                    answer++;
                    break;
                }

                if(sum > n) {
                    break;
                }
            }
        }

        return answer;
    }
}
