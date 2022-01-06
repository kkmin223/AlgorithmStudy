import java.util.Scanner;
public class BOJ8958 {

    public int solution(String str){
        int score = 0;
        int result = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='O'){
                score++;
                result+= score;
            } else {
                score=0;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        BOJ8958 T = new BOJ8958();
        int num;
        num = input.nextInt();
        while(num--!=0){
            String str = input.next();
            System.out.println(T.solution(str));
        }
    }
}
