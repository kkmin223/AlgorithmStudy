class Solution {
    public long solution(int a, int b) {
        long answer = sumAtoB(Math.min(a,b), Math.max(a,b));
        return answer;
    }
    public long sumAtoB(long a, long b){
        long result = 0;
        for(long i = a; i<= b; i++){
            result += i;
        }
        return result;
    }
}
