import java.io.*;

public class BOJ2775 {
    static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T;
        T = Integer.parseInt(br.readLine());
        while (0 < T--){
            int k,n;
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            sb.append(getPeopleCount(k, n) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int getPeopleCount(int floor, int room){
        for (int i = 0; i <= floor; i++) {
            for (int j = 1; j <= room; j++) {
                if(dp[i][j] != 0){
                    continue;
                }
                if (i == 0)
                {
                    dp[i][j] = j;
                }
                else
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[floor][room];
    }
}