import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = arr[0];
        int answer = Integer.MAX_VALUE;
        while(start<=end){
            if(sum >= t){
                answer = Math.min(answer, end - start + 1);
            }
            if(sum <= t){
                end++;
                if(end == n) break;
                sum += arr[end];
            } else {
                sum -= arr[start];
                start++;
                if(start == n) break;
            }
        }
        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}
