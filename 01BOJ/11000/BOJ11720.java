import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for(int i=0; i<n; i++){
            int num = input.charAt(i)-'0';
            result += num;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
