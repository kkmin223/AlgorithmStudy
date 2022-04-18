import java.util.Scanner;

public class BOJ1309 {
    public static void main(String[] args) {
        int[] dp;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i = 2; i<=n; i++){
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
        }
        System.out.println(dp[n]);
    }
}
