package programmers.level2;

//https://programmers.co.kr/learn/courses/30/lessons/12977
public class 소수_만들기 {
    static int answer = 0;

    public boolean isPrime(int n) {
        if(n == 1)
            return false;

        for(int i = 2; i < n; i++) {
            if(n%i == 0)
                return false;
        }

        return true;
    }

    public void dfs(int level, int start, int sum, int[] nums) {
        if(level == 3 ) {
            if(isPrime(sum)) {
                answer++;
            }
        } else {
            for(int i = start; i < nums.length; i++) {
                dfs(level + 1, i + 1, sum + nums[i], nums);
            }
        }
    }

    public int solution(int[] nums) {
        dfs(0, 0, 0, nums);

        return answer;
    }
}
