package programmers.level2;//풀이 날짜 : 2020-1-5
//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

public class 다리를_지나는_트럭 {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int[] truck_time = new int[truck_weights.length];
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0; 
        int curPos = 0;
        
        while(true) {
           if(!bridge.isEmpty() && truck_time[bridge.peek()] == time)  {
               weight += truck_weights[bridge.poll()];
           }
            
            if(curPos < truck_weights.length && truck_weights[curPos] <= weight) {
                bridge.offer(curPos);
                truck_time[curPos] = time + bridge_length;
                weight -= truck_weights[curPos];
                curPos++;
            }
            
            time++;
            
            if(bridge.isEmpty()) {
                break;
            }
        }
        
        return time;
    }
}