import java.util.Scanner;

public class BOJ1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        for(int i =0; i<=n; i++){
            // 모든 수는 제곱수 1의 합으로 나타낼 수 있고, 그 때가 가장 큰 경우의 수이다.
            dp[i] = i;
        }
        for(int i=4; i<=n; i++){
            for(int j = 2; j*j <=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] +1);
            }
        }
        System.out.print(dp[n]);
    }
}
