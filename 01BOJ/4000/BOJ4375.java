import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int n = sc.nextInt();
            int target = 0;
            for (int length = 1;; length++){
                target = ( target * 10 + 1 )% n;
                if(target == 0){
                    System.out.println(length);
                    break;
                }
            }
        }
    }
}
