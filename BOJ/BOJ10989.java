import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;
public class BOJ10989 {
  
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            result[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(result);
        for(int num : result) {
           bw.write(Integer.toString(num));
           bw.write("\n");
        }
        bw.close();
    }
}
