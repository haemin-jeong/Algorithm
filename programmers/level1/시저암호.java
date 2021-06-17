package programmers.level1;

public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            //공백일때 
            if(s.charAt(i) == ' ') {
                sb.append(" ");
                continue;
            }
            
            //소문자일때
            if(Character.isLowerCase(s.charAt(i))) {
                if(s.charAt(i)+n > 122) {
                    sb.append((char)(s.charAt(i) + n - 122 + 96));
                } else {
                    sb.append((char)(s.charAt(i) + n));    
                }
                continue;
            }
            
            //대문자일때
            if(s.charAt(i) + n > 90) {
                sb.append((char)(s.charAt(i) + n - 90 + 64));
            } else {
                sb.append((char)(s.charAt(i) + n));
            }
        }
        
        return sb.toString();
    }
}
