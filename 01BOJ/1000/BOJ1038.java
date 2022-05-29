import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1038 {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }

    private static long solve(int n) {
        if(n<10){
            return n;
        } else if(n>1022){
            return -1;
        }
        for(int i = 0; i<10; i++){
            getNum(i,1);
        }

        Collections.sort(list);
        return list.get(n);
    }
    private static void getNum(long n, int len){
        if(len > 10) return;
        list.add(n);
        for(int i = 0; i<n%10; i++){
            getNum(n*10+i, len+1);
        }
    }
}
