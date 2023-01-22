import java.util.Stack;

class Solution {
    public int solution(int[] ingredients) {
        int answer = 0;
        Stack<Integer> buger = new Stack<>();
        int size = 0;
        
        for (int ingredient : ingredients){
            buger.push(ingredient);
            size = buger.size();
            if (4 <= size
                && buger.get(size-1) == 1
                && buger.get(size-2) == 3
                && buger.get(size-3) == 2
                && buger.get(size-4) == 1){
                buger.pop();
                buger.pop();
                buger.pop();
                buger.pop();
                answer++;
            }
        }
        
        return answer;
    }
}
