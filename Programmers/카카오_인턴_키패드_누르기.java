// 풀이 날짜 : 2020-11-19
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/67256

package Programmers;

public class 카카오_인턴_키패드_누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 키패드 0~9숫자의 (y,x)좌표를 저장한 배열
        int[][] keypadPos = {
            {4,2}, {1,1}, {1,2}, {1,3}, {2,1}, {2,2}, {2,3}, {3,1}, {3,2}, {3,3}
        };
        int[] leftPos = {4,1};
        int[] rightPos = {4,3};
        
        for(int i = 0; i < numbers.length; i++) {
            
             if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                 sb.append('L');
                 leftPos[0] = keypadPos[numbers[i]][0];
                 leftPos[1] = keypadPos[numbers[i]][1];
                 continue;
             } 
             
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                 sb.append('R');
                 rightPos[0] = keypadPos[numbers[i]][0];
                 rightPos[1] = keypadPos[numbers[i]][1];
                 continue;
            }
            
        
            int rightDistance = Math.abs(rightPos[0] - keypadPos[numbers[i]][0]) + Math.abs(rightPos[1] - keypadPos[numbers[i]][1]);
            int leftDistance = Math.abs(leftPos[0] - keypadPos[numbers[i]][0]) + Math.abs(leftPos[1] - keypadPos[numbers[i]][1]);
            
            // 왼손 엄지가 더 가까울 경우
            if(rightDistance > leftDistance) {
                sb.append('L');
                leftPos[0] = keypadPos[numbers[i]][0];
                leftPos[1] = keypadPos[numbers[i]][1];
                continue;
            }
            
            // 오른손 엄지가 더 가까울 경우
            if(rightDistance < leftDistance) {
                sb.append('R');
                rightPos[0] = keypadPos[numbers[i]][0];
                rightPos[1] = keypadPos[numbers[i]][1];
                continue;
            } 
            
            // 왼손 엄지, 오른손 엄지 거리가 같을 경우
            if(hand.equals("right")) {
                sb.append('R');
                rightPos[0] = keypadPos[numbers[i]][0];
                rightPos[1] = keypadPos[numbers[i]][1];
            } else {
                sb.append('L');
                leftPos[0] = keypadPos[numbers[i]][0];
                leftPos[1] = keypadPos[numbers[i]][1];
            }
        }
        
        return sb.toString();
    }
}
