package inflearn.array;

import java.util.Scanner;

//https://developer-hm.tistory.com/60
public class Main2_2 {

    public static int solution(int[] arr) {
        int count = 1; //첫번째 사람은 무조건 보이기 때문에 1
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) { //첫번째 사람보다 키가 크다면
                max = arr[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }
}
