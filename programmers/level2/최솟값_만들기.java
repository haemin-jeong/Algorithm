package programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값_만들기 {
    public int solution(int []A, int []B) {
        int answer = 0;

        //reverseOrder() 를 사용하려면 래퍼 타입이어야하기 때문에 int[] -> Integer[] 변환
        Integer[] BB = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(A);
        Arrays.sort(BB, Collections.reverseOrder());

        for(int i = 0; i < A.length; i++) {
            answer += A[i]*BB[i];
        }

        return answer;
    }
}
