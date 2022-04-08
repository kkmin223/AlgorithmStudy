import java.util.Scanner;
import java.util.Stack;

public class BOJ1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(toPostfix(input));
    }
    public static String toPostfix(String infix){
        Stack<Character> op = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(char c: infix.toCharArray()){
            if(c >= 'A' && c<= 'Z'){
                postfix.append(c);
            }
            else {
                // 연산자일 때
                if(c=='('){
                    op.push(c);
                }
                else if(c==')'){
                    while (!op.isEmpty() && op.peek() != '(') {
                        postfix.append(op.pop());
                    }
                    if(!op.isEmpty()) op.pop();

                } else {
                    // 스택에 연산자가 저장되어있을때, 현재 연산자보다 우선순위가 높은 연산자는 추가해준다.
                    while(!op.isEmpty()&&getPrecedence(op.peek()) >= getPrecedence(c)){
                        postfix.append(op.pop());
                    }
                    op.push(c);
                }
            }
        }
        while(!op.isEmpty()){
            postfix.append(op.pop());
        }
        return postfix.toString();
    }
    // 연산자의 우선순위를 반환한다.
    static public int getPrecedence(char op){
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
}
