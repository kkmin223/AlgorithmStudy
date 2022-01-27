import java.util.Scanner;

public class BOJ1475 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[9];
        int set = 0;
        String input = sc.nextLine();
        for(int i=0; i<input.length(); i++){
            int temp = input.charAt(i) - '0';
            cnt[(temp == 9) ? 6: temp]++;
        }
        for(int i = 0; i<9; i++){
            if(i == 6) set = Math.max(set, (cnt[i]%2==0)?cnt[i]/2:cnt[i]/2+1);
            else set = Math.max(set, cnt[i]);
        }
        System.out.println(set);
    }
}
