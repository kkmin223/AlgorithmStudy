class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i = 1; i<=s.length()/2; i++){
            answer = Math.min(answer, compressString(s,i));
        }
        return answer;
    }
    /**
    * 문자열 s를 len길이만큼 잘라서 압축한 뒤, 압축한 문자열의 길이를 반환한다.
    */
    public int compressString(String s, int len){
        StringBuilder sb = new StringBuilder();
        String prev = s.substring(0,len);
        int cnt = 1;
        int i;
        for(i = len; i<s.length(); i+=len){
            String cur;
            if(i+len>s.length()){
                cur = s.substring(i,s.length());
            } else {
                cur = s.substring(i,i+len);
            }
            
            if(prev.equals(cur)){
                cnt++;
            }
            else{
                if(cnt == 1){
                    sb.append(prev);
                } else {
                    sb.append(cnt).append(prev);
                    cnt = 1;
                }
            }
            prev = cur;
        }
        if(cnt != 1){
            sb.append(cnt).append(prev);
        } else {
            sb.append(prev);
        }
        
        return sb.toString().length();
    }
}
