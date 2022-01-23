class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0]; // 최대값 저장
        int sum = nums[0];
        for(int i = 1; i<nums.length; i++){
            sum = Math.max(sum+nums[i] , nums[i]);
            max = Math.max(sum,max);
        }
        return max;
    }
}