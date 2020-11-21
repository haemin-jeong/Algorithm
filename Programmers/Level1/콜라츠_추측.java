// 풀이 날짜 : 2020-11-15
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12943

package Programmers;

public class 콜라츠_추측 {

    public int solution(int num) {
        //int 형으로 계산시 오버플로 발생
        long n = num;
        for(int i = 0; i < 500; i++) {

            if(n == 1) {
                return i;    
            }
            
            if(n%2 == 0) {
                n = n/2;
            } else {
                n = n*3 +1;
            }
        }
        
        return -1;
    }
}
