import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<n; i++){
            dp[i] = num[i];
            for(int j = 0; j<i; j++){
                if(num[j]<num[i]) dp[i] = Math.max(dp[i], dp[j] + num[i]);
            }
        }
        int answer = dp[0];
        for(int i=1; i<n; i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
