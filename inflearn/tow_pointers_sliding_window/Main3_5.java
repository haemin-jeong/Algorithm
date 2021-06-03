package inflearn.tow_pointers_sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//연속된 자연수의 합
public class Main3_5 {

    //예습 풀이
    public static int solution(int n) {
        int left = 1, sum = 1, answer = 0;

        for (int right = 2; right < n; right++) {
            sum += right;

            if (sum == n) {
                answer++;
            }

            if ((right-left) == 1 && sum >= n) {
                break;
            }

            while (sum > n) {
                sum -= (left++);
                if (sum == n) {
                    answer ++;
                }
            }
        }

        return answer;
    }

    //강의 풀이 방식
    public static int solution2(int n) {
        int left = 0, sum = 0, answer = 0;
        int m = n/2 + 1; //n을 2로나눈 몫에 + 1한 값 까지만 연속된 자연수가 있으면된다.
        int[] arr = new int[m];

        //배열 초기화
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int right = 0; right < m; right++) {
            sum += arr[right];

            if (sum == n) {
                answer++;
            }

            while (sum > n) {
                sum -= arr[left++];

                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    //강의 풀이 방식2 - 수학
    public static int solution3(int n){
        int answer=0, count=1;
        n--;
        while(n>0){
            count++;
            n=n-count;
            if(n%count==0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution2(n));
    }
}
