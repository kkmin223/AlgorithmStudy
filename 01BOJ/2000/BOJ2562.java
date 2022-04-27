import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1;
        int idx = 0;
        for (int i = 1; i <= 9; i++) {
            int temp = sc.nextInt();
            if(temp > max){
                max = temp;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx);

    }
}
