class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[27];
        
        for(int i = 0; i<27; i++){
            alphabet[i] = -1;
        }
        
        for(int i = 0; i<s.length(); i++){
            char target = s.charAt(i);
            int idx = target - 'a';
            if(alphabet[idx] == -1){
                answer[i] = -1;
            }
            else {
                answer[i] = i - alphabet[idx];
            }
            
            alphabet[idx] = i;
        }
        
        return answer;
    }
}
