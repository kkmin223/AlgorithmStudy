import java.util.Scanner;

public class problem1 {
    public int solution(String str, char target){
        int answer = 0;
        for(char c: str.toCharArray()){
            if(c==target) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        problem1 T = new problem1();
        String str = in.next().toLowerCase();
        char target = in.next().toLowerCase().charAt(0);
        System.out.print(T.solution(str,target));
    }
}
