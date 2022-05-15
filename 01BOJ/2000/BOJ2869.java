import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        double a = Integer.parseInt(input[0]);
        double b = Integer.parseInt(input[1]);
        double v = Integer.parseInt(input[2]);
        double day = (v-a) /(a-b);
        int answer = (int) Math.floor(day);
        if(day == answer) System.out.println(answer+1);
        else System.out.println(answer+2);


    }
}
