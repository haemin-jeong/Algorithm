package programmers.level2;

import java.util.*;

public class 소수_찾기 {

    //탐색을 진행하면서 이미 사용된 숫자는 사용하지 않기위해 확인하는 용도
    boolean[] visit;

    char[] arr;

    // "011", "11" 과 같이 다른 문자열이지만 숫자로 변환시 같은 숫자인 경우가 있기 때문에 중복을 걸러내기 위해  set자료구조 사용
    Set<Integer> set = new HashSet<>();

    public boolean isPrime(int n) {
        if(n == 1 || n == 0) return false;

        for(int i = 2; i < n; i++) {
            if(n%i == 0) return false;
        }

        return true;
    }

    //char형 배열의 앞에서부터 length 길이 만큼 잘라서 int형으로 변환해서 반환
    public int charsToInt(char[] arr, int length) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }

        return Integer.parseInt(sb.toString());
    }

    public void dfs(int level, int length, String numbers) {
        if(level == length) {
            int num = charsToInt(arr, length);
            if(isPrime(num)) set.add(num);
        } else {
            for(int i = 0; i < numbers.length(); i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    arr[level] = numbers.charAt(i);
                    dfs(level+1, length, numbers);
                    visit[i] = false;
                }
            }

        }
    }

    public int solution(String numbers) {
        visit = new boolean[numbers.length()];
        arr = new char[numbers.length()];

        for(int i = 1; i <= numbers.length(); i++) {
            dfs(0, i, numbers);
        }

        return set.size();
    }
}
