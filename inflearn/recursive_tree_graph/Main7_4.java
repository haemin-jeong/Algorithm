package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//피보나치 수열 : 재귀 + 메모이제이션
public class Main7_4 {

    //이전에 계산한 값을 저장해놓을 배열
    static int[] arr;

    public static int fibonacci(int n) {
       //n번째 피보나치 수가 저장되어 있다면 재사용
        if (arr[n] > 0) {
            return arr[n];
        }

        //arr[n]에 n번째 피보나치 수열 값을 저장해둔다.
        if (n == 1 || n == 2) {
            arr[n] = 1;
            return arr[n];
        } else {
            arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return arr[n];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        fibonacci(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
