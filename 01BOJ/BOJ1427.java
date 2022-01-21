import java.util.Arrays;
import java.util.Scanner;

public class BOJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        Arrays.sort(input);
        StringBuilder reverse = new StringBuilder(String.valueOf(input));
        System.out.println(reverse.reverse());
    }
}
