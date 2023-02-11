import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int input = sc.nextInt();
        int length = String.valueOf(input).length();

        for (int i = 1; i<length; i++){
            answer += ((int)Math.pow(10, i) - (int)Math.pow(10, i -1)) * i;
        }

        answer += (input - Math.pow(10, length-1) + 1) * length;

        System.out.println(answer);
    }
}
