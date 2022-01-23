import java.util.Scanner;

public class BOJ1929 {

    boolean isPrime(int num){
        if(num==1) return false;
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BOJ1929 solution = new BOJ1929();
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = m; i <= n; i++) {
            if(solution.isPrime(i))
                System.out.println(i);
        }
    }
}
