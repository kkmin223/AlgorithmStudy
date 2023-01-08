class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int length = 0;
        while(!s.equals("1")){
            answer[0]++;
            answer[1] += s.length(); 
            length = s.replace("0", "").length();
            answer[1] -= length;
            s = Integer.toBinaryString(length);
        }
        return answer;
    }
    
}
