package inflearn.array;

import java.io.IOException;
import java.util.Scanner;

public class Main2_1 {

    public static String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();

        sb.append(arr[0]).append(" ");

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                sb.append(arr[i]).append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }
}
