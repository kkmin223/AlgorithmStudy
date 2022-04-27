import java.util.Scanner;

public class BOJ2908 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int max = -1;
        for(String num: input){
            StringBuilder temp = new StringBuilder();
            int tmp = Integer.parseInt(temp.append(num).reverse().toString());
            if(max < tmp){
                max = tmp;
            }
        }
        System.out.println(max);
    }

}
