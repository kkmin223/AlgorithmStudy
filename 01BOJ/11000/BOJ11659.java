import java.io.*;
import java.util.StringTokenizer;

public class BOJ11659 {
    static int n,m;
    static int[] nums;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        prefixSum = new int[n+1];
        prefixSum[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(i == 0) {
                continue;
            }
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        prefixSum[n] = prefixSum[n - 1] + nums[n - 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start, end;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            sb.append(getSum(start, end)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getSum(int start, int end){
        return prefixSum[end] - prefixSum[start-1];
    }
}
