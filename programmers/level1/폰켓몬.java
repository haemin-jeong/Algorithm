package programmers.level1;

import java.util.*;

public class 폰켓몬 {

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        int answer = 0;

        for(int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        return Math.min(len/2, set.size());
    }
}
