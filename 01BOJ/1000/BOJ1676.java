import java.util.Scanner;

public class BOJ1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int twoCnt = 0;
        int fiveCnt = 0;
        for(int i = 2; i<=num; i++){
            int n = i;
            while(n % 2 == 0){
               twoCnt++;
               n /= 2;
            }
            while(n % 5 == 0){
                fiveCnt++;
                n /= 5;
            }
        }
        int cnt = Math.min(twoCnt,fiveCnt);
        System.out.println(cnt);
    }
}
