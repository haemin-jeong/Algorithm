package Programmers;

public class 다트_게임 {
    public int solution(String dartResult) {
        char[] arr = dartResult.toCharArray();
        int[] score = new int[3];
        int scoreIndex = 0;
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(Character.isDigit(arr[i])) {
                if(arr[i+1] == '0') {
                    score[scoreIndex++] = 10;
                    i++;
                } else {
                    score[scoreIndex++] = arr[i] - '0';    
                }
                continue;
            } 
            
            if(arr[i] == 'D') {
                score[scoreIndex-1] = (int)Math.pow(score[scoreIndex-1], 2);
            } else if(arr[i] == 'T') {
                score[scoreIndex-1] = (int)Math.pow(score[scoreIndex-1], 3);
            } else if(arr[i] == '*') {
                if(scoreIndex-2 >= 0) {
                    score[scoreIndex-2] *= 2;
                }
                score[scoreIndex-1] *= 2;
            } else if(arr[i] == '#'){
                score[scoreIndex-1] *= -1;
            }
            
        }
        
        for(int i = 0; i < 3; i++) {
            sum += score[i];
        }
        
        return sum;
    }
}
