import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class BOJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int[] cnt = new int[26];
        for(int i=0; i<26; i++){
            cnt[i] = -1;
        }
        for(int i=0; i<input.length(); i++){
            int idx = input.charAt(i)-'a';
            if(cnt[idx]==-1) {
                cnt[idx] = i;
            }
        }
        for(int i: cnt){
            bw.write(String.valueOf(i)+" ");
        }
        bw.flush();
        bw.close();

    }
}

