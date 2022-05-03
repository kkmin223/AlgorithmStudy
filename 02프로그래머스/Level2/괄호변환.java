import java.util.Stack;
class Solution {
    public static String solution(String p) {
        String answer = "";
        if(isCorrected(p)) return p;
        for(int i = 2; i<=p.length(); i +=2){
            String u = p.substring(0,i);
            String v = p.substring(i, p.length());
            if(isBalanced(u)){
                answer = convertBracket(u,v);
                break;
            }
        }
        return answer;
    }
    /*
    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
    3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
    4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
    4-3. ')'를 다시 붙입니다.
    4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    4-5. 생성된 문자열을 반환합니다.
     */
    public static String convertBracket(String u, String v){
        if(isCorrected(u)){
            if(v.length() == 0) return u;
            for(int i = 2; i<=v.length(); i +=2){
                String bracket1 = v.substring(0,i);
                String bracket2 = v.substring(i, v.length());
                if(isBalanced(bracket1)){
                    return u + convertBracket(bracket1, bracket2);

                }
            }
        }
        StringBuilder temp = new StringBuilder();
        temp.append("(");
        for(int i = 2; i<=v.length(); i +=2){
            String bracket1 = v.substring(0,i);
            String bracket2 = v.substring(i, v.length());
            if(isBalanced(bracket1)){
                String bracket3 = convertBracket(bracket1, bracket2);
                temp.append(bracket3);
                break;
            }
        }
        temp.append(")");
        for(int i = 1; i<u.length()-1; i++){
            if(u.charAt(i) == '(') temp.append(")");
            else if(u.charAt(i) == ')') temp.append("(");
        }
        return temp.toString();

    }
    // 균형잡힌 괄호인지 검사
    public static boolean isBalanced(String s){
        int open = 0;
        int close = 0;
        for(char c : s.toCharArray()){
            if(c== '(') open++;
            else if(c== ')') close++;
        }
        if(open == close) return true;
        else return false;
    }
    // 올바른 괄호인지 검사
    public static boolean isCorrected(String s){
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') st.push('(');
            else if(c == ')'){
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
}
