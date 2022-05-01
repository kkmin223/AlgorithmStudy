import java.util.Scanner;

public class BOJ11444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i<=n; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2])%1000000007;
        }
        System.out.println(fibo[n]);
    }
}