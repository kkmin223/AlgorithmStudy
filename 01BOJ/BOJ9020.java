import java.util.Scanner;

public class BOJ9020 {
    static boolean[] isNotPrime = new boolean[10001];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        findPrime();
        while(T-- != 0){
            n = sc.nextInt();
            findAnswer(n);
        }
    }
    /**
     * 에라토스테네스의 체를 이용해 10000까지 소수를 구해 isNotPrime에 저장한다.
     * isNotPrime == true -> 소수 아님
     * isNotPrime == false -> 소수
     * */
    public static void findPrime(){
        for(int i = 2; i< isNotPrime.length; i++) {
            if(isNotPrime[i]) continue;
            for (int j = 2 * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
    /**
     * n/2부터 1씩 감소시키면서
     * num1,num2 모두 소수인 경우를 찾아서 출력한다.
     */
    public static void findAnswer(int n){
        for(int num1 = n/2; num1 > 0; num1--){
            int num2 = n - num1;
            if(!isNotPrime[num1] && !isNotPrime[num2]){
                System.out.println(num1+" "+num2);
                break;
            }
        }
    }
}
package BOJ;

import java.util.Scanner;

public class BOJ9020 {
    static boolean[] isNotPrime = new boolean[10001];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        findPrime();
        while(T-- != 0){
            n = sc.nextInt();
            findAnswer(n);
        }
    }
    /**
     * 에라토스테네스의 체를 이용해 10000까지 소수를 구해 isNotPrime에 저장한다.
     * isNotPrime == true -> 소수 아님
     * isNotPrime == false -> 소수
     * */
    public static void findPrime(){
        for(int i = 2; i< isNotPrime.length; i++) {
            if(isNotPrime[i]) continue;
            for (int j = 2 * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
    /**
     * n/2부터 1씩 감소시키면서
     * num1,num2 모두 소수인 경우를 찾아서 출력한다.
     */
    public static void findAnswer(int n){
        for(int num1 = n/2; num1 > 0; num1--){
            int num2 = n - num1;
            if(!isNotPrime[num1] && !isNotPrime[num2]){
                System.out.println(num1+" "+num2);
                break;
            }
        }
    }
}
