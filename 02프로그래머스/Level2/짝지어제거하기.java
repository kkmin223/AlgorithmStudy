import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        char[] str = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(!st.isEmpty() && st.peek() == str[i]) st.pop();
            else st.push(str[i]);
        }
        int answer = (st.isEmpty())? 1:0;
        return answer;
    }
}
