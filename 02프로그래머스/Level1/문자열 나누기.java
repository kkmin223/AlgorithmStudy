class Solution {
    public int solution(String s) {
        int answer = 0;
        int targetCnt = 0;
        int otherCnt = 0;
        char target = '.';
        for(int i = 0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(target == '.'){
                target = temp;
                targetCnt = 1;
                answer++;
                continue;
            }
            
            if (temp == target){
                targetCnt++;
            }
            else {
                otherCnt++;
            }
            
            if(targetCnt == otherCnt){
                target = '.';
                targetCnt = 0;
                otherCnt = 0;
            }
            
        }
        
        return answer;
    }
    
    
}
