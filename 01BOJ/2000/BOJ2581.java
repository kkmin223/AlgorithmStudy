import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = n; i <= m; i++){
            if(isPrime(i)){
                if (answer == 0){
                    min = i;
                }
                answer += i;
            }
        }

        if (answer == 0){
            answer = -1;
            sb.append(answer);
        } else {
            sb.append(answer).append("\n").append(min);
        }

        System.out.println(sb.toString());
    }

    public static Boolean isPrime(int num){
        if (num == 1){
            return false;
        }
        
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
