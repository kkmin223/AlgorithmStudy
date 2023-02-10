import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] alphabet = new int[26];
        for (char c : input.toCharArray()){
            alphabet[c-'a'] += 1;
        }

        for (int i = 0; i<26; i++){
            System.out.print(alphabet[i]);
            if (i == 25){
                break;
            }
            System.out.print(" ");
        }

    }
}
