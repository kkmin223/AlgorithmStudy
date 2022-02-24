class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = nums.length;
        while(start<nums.length){
          for(int i = 0; i<end; i++){
            if(nums[i] == 0){
                if(i+1 == nums.length) break;
                if(nums[i+1] != 0){
                    int next = nums[i+1];
                    nums[i+1] = 0;
                    nums[i] = next;
                    }
                }
            }  
            start++; // 위 과정을 거치면 앞쪽에 있는 0이 뒤로 갔을 것이므로 start에 1을 더해준다.
            end--;  // 위 과정을 거치면 하나의 0이 끝으로 갔을 것이므로 end를 1 빼준다.
        }
    }
}