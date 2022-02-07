class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n>0){
            int a = n % 3;
            n = n /3;   
            if(a==0){
                answer.append(4);
                n--;
            } else answer.append(a);    
        }
        return answer.reverse().toString();
    }
}
