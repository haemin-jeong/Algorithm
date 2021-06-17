package programmers.level2;

public class 음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int length = absolutes.length;

        for(int i = 0; i < length; i++) {
            if(signs[i])
                answer += absolutes[i];
            else
                answer += (absolutes[i]*-1);
        }

        return answer;
    }
}
