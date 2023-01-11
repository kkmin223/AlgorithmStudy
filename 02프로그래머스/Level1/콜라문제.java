class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        answer = getCoke(a, b, n, 0);
        return answer;
    }
    
    public int getCoke(int a, int b, int n, int count){
        int reward = 0;
        
        if(n < a){
            return count;
        }
        
        reward = (n / a) * b;
        return getCoke(a, b, n % a + reward, count + reward);
    }
}
