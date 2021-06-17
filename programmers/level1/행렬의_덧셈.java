// 풀이 날짜 : 2020-11-15
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12950

package programmers.level1;

public class 행렬의_덧셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[0].length; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        
        return arr1;
    }
    
}
