package inflearn.recursive_tree_graph;

import java.util.Scanner;

//팩토리얼
public class Main7_3 {

    public static int factorial(int n) {
        if (n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(factorial(n));

        sc.close();
    }
}
