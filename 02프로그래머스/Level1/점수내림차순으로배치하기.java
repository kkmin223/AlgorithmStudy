import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] num = Long.toString(n).toCharArray();
        Arrays.sort(num);
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.reverse();
        answer = Long.valueOf(sb.toString());
        return answer;
    }
}
