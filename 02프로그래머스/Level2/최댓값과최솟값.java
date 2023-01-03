import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = "";
        int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        answer += nums[0] + " " + nums[nums.length-1];

        return answer;
    }
}
