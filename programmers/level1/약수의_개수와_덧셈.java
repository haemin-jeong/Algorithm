package programmers.level1;

public class 약수의_개수와_덧셈 {

    public int getDivisor(int n) {
        int divisor = 1;
        
        for(int i = 1; i < n; i++) {
            if(n%i == 0) divisor++;
        }

        return divisor;
    }

    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            int divisor = getDivisor(i);

            if(divisor%2 == 0)
                answer += i;
            else
                answer -= i;
        }

        return answer;
    }
}
