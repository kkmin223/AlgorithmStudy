import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int sum = arr[0];
        while(true){
            if(sum == t){
                answer++;
            }
            if(sum <= t){
                end++;
                if(end == n) break;
                sum += arr[end];
            } else {
                if(start == n) break;
                sum -= arr[start];
                start++;
            }

        }
        System.out.println(answer);
    }
}
