import java.util.Scanner;

public class BOJ15829 {

    static long hashFunction(int n, String input){
        long hash = 0;
        long mod = 1234567891L;
        long a = 31;
        long pow = 1;
        for (int i = 0; i < n ; i++) {
            long temp = input.charAt(i)-'a' + 1;
            hash += temp * pow;
            pow = (pow*a) % mod;
        }
        return hash % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        System.out.println(hashFunction(n,input));
    }
}
