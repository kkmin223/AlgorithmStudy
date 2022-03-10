import java.util.Scanner;

public class BOJ15649 {
    static int n,m;
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        nums = new int[m];
        permutation(0);
        System.out.println(sb.toString());
    }
    public static void permutation(int cnt){
        if(cnt == m){
            for(int num: nums){
                sb.append(num+" ");
            }
            sb.append("\n");
            return;
        } else {
            for(int i = 0; i<n; i++){
                if(visited[i]) continue;
                visited[i] = true;
                nums[cnt] = i+1;
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }
}
