package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//에라토스테네스 체
public class Main2_5 {

    public static int solution(int n) {
        int[] arr = new int[n+1]; //숫자와 배열 인덱스를 맞추기 위해 +1
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                count++;
                for (int j = i*2; j <= n; j+=i) { //i의 배수를 제거하는 과정
                    arr[j] = 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
