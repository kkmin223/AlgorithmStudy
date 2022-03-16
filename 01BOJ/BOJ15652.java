package BOJ;

import java.util.Scanner;

public class BOJ15652 {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[m];
        dfs(0);
        System.out.print(sb.toString());
    }
    public static void dfs(int cnt){
        if(cnt == m){
            for(int i = 0 ; i<cnt; i++){
                sb.append(nums[i]);
                if(i!=cnt-1) sb.append(" ");
            }
            sb.append("\n");
        } else {
            for(int i = 1; i<=n; i++){
                if(cnt == 0 || i>= nums[cnt-1]){
                    nums[cnt] = i;
                    dfs(cnt+1);
                }
            }
        }
    }
}
