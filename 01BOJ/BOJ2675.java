import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2675 {

    static String repeatStr(int num, String str){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            result.append(String.valueOf(str.charAt(i)).repeat(num));
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- != 0){
            String[] input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            String str = input[1];
            System.out.println(repeatStr(num, str));
        }
    }
}
