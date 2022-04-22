import java.util.Scanner;

public class BOJ11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[1001][1001];
        for(int i =1; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(i==j || j==0){
                    dp[i][j] = 1;
                } else{
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
                }
            }
        }
        System.out.println(dp[n][k]%10007);
    }
}
