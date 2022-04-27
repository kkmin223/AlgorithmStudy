import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        dp[0] = max;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[j] > arr[i]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}
