import java.util.Scanner;

public class BOJ15651 {
    static int n,m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[m];
        permuation(0);
        System.out.print(sb.toString());
    }

    public static void permuation(int cnt){
        if(cnt == m){
            for(int i = 0; i<cnt; i++){
                sb.append(nums[i]);
                if(i != cnt - 1) sb.append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for(int i = 1; i<=n; i++){
                nums[cnt] = i;
                permuation(cnt+1);
            }
        }
    }
}
