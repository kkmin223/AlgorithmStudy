import java.util.Scanner;
import java.util.HashSet;

public class BOJ3502 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<Integer>(10);
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<10; i++){
            hs.add(sc.nextInt()%42);
        }
        System.out.println(hs.size());
    }
}
