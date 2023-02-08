import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums;
        int n;
        int answer = 0;
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(nums);
        answer = nums[0] * nums[n - 1];
        System.out.println(answer);
    }
}
