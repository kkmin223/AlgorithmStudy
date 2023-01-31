import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(0 < n--){
            String[] words = br.readLine().split(" ");
            String answer = "";
            for(String word : words){
                StringBuilder sb = new StringBuilder();
                sb.append(word);
                answer += sb.reverse().append(" ").toString();
            }
            System.out.println(answer.substring(0, answer.length()-1));
        }

    }
}
