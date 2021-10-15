package programmers.level2;

public class 문자열_압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        //문자열 길이가 1인 경우
        if(s.length() == 1) {
            return 1;
        }

        for(int i = 1; i <= s.length()/2; i++) {
            StringBuilder sb = new StringBuilder();

            int count = 0; //반복 횟수
            String target = s.substring(0, i); //반복 대상 문자열

            for(int j = 0; j <= s.length(); j+=i) {
                int start = j;
                int end = Math.min(i + j, s.length());

                String temp  = s.substring(start, end);

                if(temp.equals(target)) {
                    count++;
                } else {
                    //반복 횟수가 1이면 압축 문자열에 숫자를 넣지 않는다.
                    if(count > 1) {
                        sb.append(count);
                    }

                    sb.append(target);

                    target = temp;
                    count = 1;
                }
            }

            //반복 횟수가 1이면 압축 문자열에 숫자를 넣지 않는다.
            if(count > 1) {
                sb.append(count);
            }

            sb.append(target);

            answer = Math.min(answer, sb.length());

        }

        return answer;
    }
}
