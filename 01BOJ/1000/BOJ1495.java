import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1495 {
    static int N,S,M;
    static int[][] dp;
    static int[] volumes;
    static boolean isPossible = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[2]);
        String[] v = br.readLine().split(" ");
        dp = new int[N + 1][M + 1];
        volumes = new int[N + 1];
        dp[0][S] = 1;
        for (int i = 1; i <= N; i++) {
            volumes[i] = Integer.parseInt(v[i-1]);
        }
        getVolume(1);
        if(!isPossible) System.out.println(-1);
        int max = -1;
        for (int i = 0; i <= M; i++) {
            if(dp[N][i] == 1){
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }
    public static void getVolume(int index){
        if(index == N + 1) return;
        for (int i = 0; i <= M; i++) {
            if(dp[index-1][i] != 1) continue;
            int nextDownVolume = i - volumes[index];
            int nextUpVolume = i + volumes[index];
            if(nextUpVolume < 0 && nextUpVolume > M){
                isPossible = false;
                return;
            }
            if(nextDownVolume >= 0) dp[index][nextDownVolume] = 1;
            if(nextUpVolume <= M) dp[index][nextUpVolume] = 1;
        }
        getVolume(index + 1);

    }
}
