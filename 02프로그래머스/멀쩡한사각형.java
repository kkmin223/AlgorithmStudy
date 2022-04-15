class Solution {
    public long solution(int w, int h) {
        long x = w;
        long y = h;
        long gcd = getGcd(x,y);
        long answer = (x*y) - (x+y-gcd);
        
        return answer;
    }
    public long getGcd(long a, long b){
        long max = Math.max(a,b);
        long min = Math.min(a,b);
        while(min != 0){
            long temp = max%min;
            max = min;
            min = temp;
        }
        return max;
    }
}
