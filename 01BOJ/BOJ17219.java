import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, String> pw = new HashMap<>();
        for(int i = 0; i<n; i++){
            String[] str = br.readLine().split(" ");
            pw.put(str[0], str[1]);
        }
        for(int i = 0; i<m; i++){
            String search = br.readLine();
            sb.append(pw.get(search)+"\n");
        }
        System.out.print(sb);
    }
}
