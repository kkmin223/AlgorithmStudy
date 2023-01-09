class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = n/2+1; i > 0 && i<n; i--){
            if(isExpress(i, n)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isExpress(int num, int target){
        int sum = 0;
        for(int i = num; i > 0; i--){
            sum += i;
            if(sum == target){
                return true;
            }
            if (sum > target){
                break;
            }
        }
        return false;
    }
}
