class Solution {
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long)Math.sqrt(n);
        answer = ((long)Math.pow(sqrt,2)!=n) ? -1L: (long)Math.pow((sqrt+1),2);
        return answer;
    }
}
