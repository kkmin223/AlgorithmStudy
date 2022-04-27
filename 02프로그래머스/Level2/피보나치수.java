class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n<=1) return n;
        int temp1 = 0;
        int temp2 = 1;
        for(int i = 2; i<=n; i++){
            answer = (temp1+temp2)%1234567;
            temp1 = temp2;
            temp2 = answer;
        }
        return answer;
    }
}
