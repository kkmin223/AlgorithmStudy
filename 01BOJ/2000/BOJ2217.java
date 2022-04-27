import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];
        int max = 0;
        for(int i = 0; i<n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        for(int i = 0; i<n; i++){
            int temp = rope[i] * (n - i);
            if(max < temp)
                max = temp;
        }
        System.out.println(max);
    }
}
