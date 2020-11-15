// 풀이 날짜 : 2020-11-15
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12948

package Programmers;

public class 핸드폰_번호_가리기 {

    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        String number = phone_number.substring(phone_number.length()-4);
        
        for(int i = 0 ; i < phone_number.length()-4; i++) {
            sb.append("*");
        }
        sb.append(number);
        
        return sb.toString();
    }

}
