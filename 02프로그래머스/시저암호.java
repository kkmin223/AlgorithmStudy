class Solution {
    public String solution(String s, int n) {
        System.out.println((int)' ');
        char[] input = s.toCharArray();
        for(int i = 0; i<input.length; i++){
            char cur = input[i];
            int after;
            if(cur>='a' && cur<='z'){
                after = (cur + n > 'z')? cur+n-26: cur+n;
            } 
            else if(cur >= 'A' && cur<='Z'){
                after = (cur + n > 'Z') ? cur+n-26: cur+n;
            } else {
                continue;
            }
            input[i] = (char)after;
        }
         String answer = new String(input);
        return answer;
    }
}
