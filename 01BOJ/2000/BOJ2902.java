import java.util.Scanner;

public class BOJ2902 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String result = "";
        String[] tokens = input.split("-");
        for(String token: tokens){
            result += token.charAt(0);
        }
        System.out.println(result);
    }

}
