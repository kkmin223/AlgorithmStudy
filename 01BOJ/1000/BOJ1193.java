import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        int n = sc.nextInt();
        int i = 1;

        while (n > i){
            n -= i;
            i++;
        }

        answer = i%2 != 0 ? String.format("%d/%d", i + 1 - n, n) : String.format("%d/%d", n, i + 1 - n);
        System.out.println(answer);
    }
}
