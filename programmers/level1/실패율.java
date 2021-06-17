package Programmers;

import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int pCount = stages.length;
        int[] curStage = new int[N+1];
        Stage[] stage = new Stage[N];
        
        for(int i = 0; i < pCount ; i++) {
            curStage[stages[i]-1]++;
        }
        
        for(int i =0; i < N; i++) {
            stage[i] = new Stage(i+1, (double)curStage[i]/pCount);
            pCount -= curStage[i];
        }
        
        return Arrays.stream(stage).sorted().mapToInt((s) -> s.num).toArray();
    }
}

class Stage implements Comparable<Stage>{
    int num;
    double failure;
    
    public Stage(int num, double failure) {
        this.num = num;
        this.failure = failure;
    }
    
    @Override
    public int compareTo(Stage s) {
        if(s.failure > this.failure) {
            return 1;
        } else if( s.failure < this.failure) {
            return -1;
        } else {
            return 0;
        }
    }
}