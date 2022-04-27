import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(long n) {
        ArrayList<Integer> answer = new ArrayList<>();
        while(n > 0){
            int num = (int)(n % 10);
            answer.add(num);
            n /= 10;
        }
        return answer;
    }
}
