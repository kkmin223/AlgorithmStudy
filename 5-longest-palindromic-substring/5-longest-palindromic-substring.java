class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        for(int i = 0; i<s.length(); i++){
            String temp = getPalindrome(s,i,i);
            String temp2 = getPalindrome(s,i,i+1);
            System.out.println(temp+ " temp2 = "+temp2);
            temp = (temp.length() < temp2.length())? temp2 : temp;
            answer = (answer.length() < temp.length())? temp : answer;
        }
        return answer;
    }
    
    public String getPalindrome(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
    
}