import java.util.*;
public class day1_p2 {
    // BOJ 18406번 럭키스트레이트
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int left=0, right = 0;
        for(int i=0; i<input.length(); i++){
            int num = input.charAt(i) -'0';
            if(i<input.length()/2){
                left += num;
            } else {
                right += num;
            }
        }
        if(left==right)
            System.out.println("LUCKY");
        else
            System.out.println("READY");
    }
}
