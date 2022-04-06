class Solution {
    int answer;
    int[] nums;
    public int solution(int[] numbers, int target) {
        answer = 0;
        nums = numbers;
        dfs(0, 0, target);
        return answer;
    }
    
    public void dfs(int num, int cnt, int target){
        if(cnt == nums.length){
            if(num == target){
              answer++;  
            }
            return;
        }
        else {
            dfs(num + nums[cnt], cnt+1, target);
            dfs(num - nums[cnt], cnt+1, target);
        }
    }
}
