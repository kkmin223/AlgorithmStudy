class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i<= number; i++){
            int count = getCount(i);
            if (limit < count) {
                count = power;
            }
            answer += count;
        }
        
        return answer;
    }
    
    public int getCount(int target){
        int count = 0;
        for(int i = 1; i * i <= target; i++){
            if (i * i == target) {
                count++;
            }
            else if (target % i == 0) {
                count += 2;
            }  
        }
        return count;
    }
}
