import java.util.Scanner;

public class BOJ11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while(input > 1){
            for(int i = 2; i<=input; i++){
                if(input % i == 0){
                    input /= i;
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
