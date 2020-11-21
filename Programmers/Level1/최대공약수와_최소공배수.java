// 풀이 날짜 : 2020-11-21
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12940

package Programmers.Level1;

public class 최대공약수와_최소공배수 {
    public int[] solution(int n, int m) {
        
        return new int[]{getGCD(n,m), getLCM(n,m)};
    }
    
    public static int getGCD(int n1, int n2) {
        
        if(n1%n2 == 0) {
            return n2;
        }
        
        return getGCD(n2, n1%n2);
    }
    
    public static int getLCM(int n1, int n2) {
        return (n1*n2)/getGCD(n1,n2);
    }
}
