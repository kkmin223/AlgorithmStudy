import java.util.*;

public class BOJ2577 {
    public int[] solution(int num){
       int[] cnt = new int[10];
       while(num>0){
           int temp = num % 10;
           cnt[temp]++;
           num /= 10;
       }
       return cnt;
    }

    public static void main(String[] args){
        BOJ2577 T = new BOJ2577();
        int num = 1;
        Scanner input = new Scanner(System.in);
        for(int i = 0; i<3; i++){
            num *= input.nextInt();
        }
        int[] result = T.solution(num);
        for(int n : result){
            System.out.println(n);
        }
    }
}
