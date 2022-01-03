import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<Integer>();
        for(int i =0; i<arr.length; i++){
            if(i==arr.length-1){
                answer.add(arr[i]);
                break;
            }
            if(arr[i]!= arr[i+1]){
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}
