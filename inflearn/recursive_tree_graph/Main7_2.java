package inflearn.recursive_tree_graph;

import java.util.Scanner;


//재귀함수를 이용한 이진수 출력
public class Main7_2 {

    public static void recursive(int n) {
        if (n == 0)
            return;

        recursive(n / 2);
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        recursive(n);

        sc.close();
    }
}
