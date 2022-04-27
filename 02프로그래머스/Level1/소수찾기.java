class Solution {
    public boolean isPrime(int num){
        int sqrt_num = (int)Math.sqrt(num);
        for(int j=2; j<=sqrt_num; j++){
            if(num%j == 0){
                return false;
            }
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++){
            if(isPrime(i))
                answer++;
        }
        return answer;
    }
}
