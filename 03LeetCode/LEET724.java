class Solution {
    public int pivotIndex(int[] nums) {
        int answer = -1;
        int left = 0;
        int right = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++){
            right -= nums[i];
            if (left == right){
                answer = i;
                break;
            }
            left += nums[i];
        }

        return answer;
    }
}
