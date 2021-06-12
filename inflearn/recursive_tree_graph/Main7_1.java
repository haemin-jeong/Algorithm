package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//재귀 함수 : n이 입력되면 1~n까지 출력하는 문
public class Main7_1 {

    public static void recursive(int n) {
        
        if(n == 0)
            return;

        recursive(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        recursive(n);

        br.close();
    }
}
