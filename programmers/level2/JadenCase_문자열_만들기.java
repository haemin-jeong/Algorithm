package programmers.level2;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean startWord = true;
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(startWord) {
                if(Character.isAlphabetic(c)) {
                    c = Character.toUpperCase(c);
                }

                startWord = false;
            }

            if(c == ' ') {
                startWord = true;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
