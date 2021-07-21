package programmers.level2;

public class 단체사진_찍기 {

    static String[] conditions;
    static int[] check;
    static char[] arr;
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer, nLen;

    public int solution(int n, String[] data) {
        answer = 0; //solution에서 초기화를 해줘야 테스트가 통과된다.
        nLen = n;
        conditions = data;
        check = new int[friends.length];
        arr = new char[friends.length];

        dfs(0);

        return answer;
    }

    public void dfs(int level) {
        if(level == friends.length) {
            boolean flag = true;

            for(int i = 0; i < nLen; i++) {
                int f1 = getPosition(arr, conditions[i].charAt(0));
                int f2 = getPosition(arr, conditions[i].charAt(2));
                char op = conditions[i].charAt(3);
                int value = Character.getNumericValue(conditions[i].charAt(4)) + 1;

                if((op == '=' && Math.abs(f1 - f2) != value) || (op == '<' && Math.abs(f1 - f2) >= value) ||
                        (op == '>' && Math.abs(f1 - f2) <= value)) {
                    flag = false;
                    break;
                }
            }

            if(flag) answer++;
        } else {
            for(int i = 0 ; i < friends.length; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
                    arr[level] = friends[i];
                    dfs(level + 1);
                    check[i] = 0;
                }
            }
        }
    }

    public int getPosition(char[] arr, char c) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == c) {
                return i;
            }
        }

        return -1;
    }
}
