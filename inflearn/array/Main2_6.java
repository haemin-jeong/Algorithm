package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2_6 {

    public static boolean isPrime(int num) {
        if (num == 1) { //1은 소수가 아니기 때문
            return false;
        }

        for (int j = 2; j < num; j++) {
            if (num%j == 0) {
                return false;
            }
        }

        return true;
    }

    //뒤집는 방법으로 문자열로 변환하여 문자열을 뒤집는 방법을 사용
    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> retList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(new StringBuilder(String.valueOf(arr[i])).reverse().toString());

            if (isPrime(arr[i])) {
                retList.add(arr[i]);
            }
        }

        return retList;
    }


    //뒤집는 방법으로 사칙연산을 사용
    public static List<Integer> solution2(int n, int[] arr) {
        List<Integer> retList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;

            while (tmp > 0) {
                int t = tmp%10;
                res = res*10 + t;
                tmp = tmp/10;
            }

            if (isPrime(res)) {
                retList.add(res);
            }
        }

        return retList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        List<Integer> list = solution2(n, arr);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
