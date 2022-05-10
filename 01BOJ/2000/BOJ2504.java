import java.util.Scanner;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stack<String> st = new Stack<>();
        int sum = 0;
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == '('){
                st.push("(");
            } else if(input.charAt(i) == '['){
                st.push("[");
            } else if(input.charAt(i)== ')'){
                int temp = 0;
                if(st.isEmpty()){
                    sum = -1;
                    break;
                }
                while(!st.isEmpty() && !st.peek().equals("(")){
                    String num = st.pop();
                    if(!Character.isDigit(num.charAt(0))){
                        sum = -1;
                        break;
                    }
                    temp += Integer.parseInt(num);
                }
                if(sum == -1|| st.isEmpty()) {
                    sum = -1;
                    break;
                }
                if(temp == 0) temp = 2;
                else temp = temp * 2;
                st.pop();
                st.push(String.valueOf(temp));
            } else if(input.charAt(i) == ']'){
                int temp = 0;
                if(st.isEmpty()){
                    sum = -1;
                    break;
                }
                while(!st.isEmpty() && !st.peek().equals("[")){
                    String num = st.pop();
                    if(!Character.isDigit(num.charAt(0))){
                        sum = -1;
                        break;
                    }
                    temp += Integer.parseInt(num);
                }
                if(sum == -1|| st.isEmpty()){
                    sum = -1;
                    break;
                }
                if(temp == 0) temp = 3;
                else temp = temp * 3;
                st.pop();
                st.push(String.valueOf(temp));
            }
        }
        if(sum == -1){
            sum = 0;
        } else {
            while(!st.isEmpty()){
                String num = st.pop();
                if(!Character.isDigit(num.charAt(0))){
                    sum = 0;
                    break;
                }
                sum += Integer.parseInt(num);
            }
        }
        System.out.print(sum);
    }
}
