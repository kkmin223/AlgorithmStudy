import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n, k;
        int[] nums;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        System.out.println(nums[k-1]);

    }
}
