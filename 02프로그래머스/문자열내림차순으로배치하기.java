import java.util.*;
class Solution {
    public String solution(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        StringBuilder result = new StringBuilder();
        for(int i= temp.length-1; i>=0; i--){
            result.append(temp[i]);
        }
        return result.toString();
    }
}