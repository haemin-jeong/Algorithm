package programmers.level1;

public class 신규_아이디_추천 {
    public String solution(String new_id) {

        //1단계
        String temp = new_id.toLowerCase();

        //2단계
        StringBuilder sb = new StringBuilder();

        for(char c : temp.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
                sb.append(c);
        }

        //3단계
        temp = sb.toString().replace("..", ".");

        while(temp.contains("..")) {
            temp = temp.replace("..", ".");
        }

        //4단계
        if(temp.length() > 0 && temp.charAt(0) == '.')
            temp = temp.substring(1, temp.length());

        if(temp.length() > 0 && temp.charAt(temp.length() - 1) == '.')
            temp = temp.substring(0, temp.length()-1);

        //5단계
        if(temp.length() == 0)
            temp = "a";

        //6단계
        if(temp.length() >= 16) {
            temp = temp.substring(0, 15);

            if(temp.charAt(temp.length() - 1) == '.')
                temp = temp.substring(0, 14);
        }

        //7단계
        if(temp.length() <= 2) {
            sb = new StringBuilder(temp);

            char last = sb.charAt(sb.length() - 1);

            while(sb.length() < 3) {
                sb.append(last);
            }

            temp = sb.toString();
        }

        return temp;
    }

    //정규표현식 사용 풀이
    public String solution2(String new_id) {
        //1단계
        String answer = new_id.toLowerCase();

        //2단계
        answer = answer.replaceAll("[^-_.a-z0-9]", "");

        //3단계
        answer = answer.replaceAll("[.]{2,}", ".");

        //4단계
        answer = answer.replaceAll("^[.]|[.]$", "");

        //5단계
        if(answer.length() == 0)
            answer = "a";

        //6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15).replaceAll("[.]$", "");
        }

        //7단계
        if(answer.length() <= 2) {
            while(answer.length() < 3)
                answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }

}
