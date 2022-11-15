import java.util.Scanner;

public class BOJ1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getSeriesNo(n));
    }

    public static int getSeriesNo(int target){
        int count = 1;
        int num = 666;
        while (count < target){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        return num;
    }
}
