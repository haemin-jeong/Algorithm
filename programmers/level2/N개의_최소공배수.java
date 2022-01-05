package programmers.level2;

public class N개의_최소공배수 {
    public int gcd(int p, int r) {
        if(r == 0) {
            return p;
        }

        return gcd(r, p%r);
    }

    public int lcm(int n1, int n2) {
        return n1*n2/gcd(n1, n2);
    }

    public int solution(int[] arr) {
        int lastLcm = arr[0];

        for(int i = 1; i < arr.length; i++) {
            lastLcm = lcm(lastLcm, arr[i]);
        }

        return lastLcm;
    }
}
