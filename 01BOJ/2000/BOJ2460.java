import java.util.Scanner;

public class BOJ2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int people = 0;
        for(int i = 0; i<10; i++){
            people = people - sc.nextInt() + sc.nextInt();
            max = Math.max(people, max);
        }
        System.out.println(max);
    }
}
