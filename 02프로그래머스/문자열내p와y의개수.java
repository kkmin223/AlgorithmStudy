class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_cnt = 0, y_cnt = 0;
        for(char c: s.toCharArray()){
            if(c=='p'||c=='P')
                p_cnt++;
            if(c=='y'||c=='Y')
                y_cnt++;
        }
        return (p_cnt==y_cnt);
    }
}