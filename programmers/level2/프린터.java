// 풀이 날짜 : 2020-12-1
// 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42587

package programmers.level2;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Document> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new Document(priorities[i], i));
        }
        
        while(!q.isEmpty()) {
            // 만약 대기목록에 우선 순위가 더 높은게 있다면
            if(Collections.max(q).priority > q.peek().priority) {
                q.offer(q.poll());
                continue;
            }
            
            answer++;
            
            // 만약 프린트 할 문서가 location 위치의 문서라면
            if(q.poll().location == location) {
                break;
            }  
        }
        
        return answer;
    }
}

class Document implements Comparable<Document> {
    int priority;
    int location;
    
    public Document(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
    
     @Override
    public int compareTo(Document o) {
        return this.priority - o.priority;
    }
}
