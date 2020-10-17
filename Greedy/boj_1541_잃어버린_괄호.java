package Greedy;

import java.util.Scanner;

public class boj_1541_잃어버린_괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] exp = input.split("-");
        int sum = 0;

        sum += sum(exp[0].split("[+]"));

        for (int i = 1; i < exp.length; i++) {
            sum -= sum(exp[i].split("[+]"));
        }

        System.out.println(sum);
    }

    static int sum(String[] arr) {
        int sum = 0;
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
