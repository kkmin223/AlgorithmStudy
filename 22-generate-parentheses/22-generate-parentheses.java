import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        makeParentheses("", n, n, n*2);
        return answer;
    }
    public void makeParentheses(String parenthes, int open, int close, int length){
        if(parenthes.length() == length){
            if(checkParentheses(parenthes)) answer.add(parenthes);
            return;
        }
        if(open > 0) makeParentheses(parenthes+"(", open-1, close, length);
        if(close > 0) makeParentheses(parenthes+")", open, close-1, length);
    }
    public boolean checkParentheses(String parenthes){
        Stack<Character> st = new Stack<>();
        for(char c : parenthes.toCharArray()){
            if(c == '('){
                st.push('(');
            } else {
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}