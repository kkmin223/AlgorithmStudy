import java.util.Scanner;

public class BOJ16953 {
    static int A,B;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        dfs(A, 1);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    public static void dfs(long num, int cnt){
        if(num == B){
            answer = Math.min(answer, cnt);
            return;
        }
        if(num * 2 <= B){
            dfs(num * 2, cnt + 1);
        }
        if(num * 10 + 1 <= B){
            dfs(num * 10 + 1, cnt + 1);
        }
    }
}
