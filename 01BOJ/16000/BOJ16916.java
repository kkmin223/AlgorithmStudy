import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16916 {
    public static int[] pi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();
        pi = new int[pattern.length()];
        makePi(pattern);
        System.out.println(KMP(str, pattern));
    }

    public static int KMP(String str, String pattern) {
        int j = 0;
        for(int i = 0; i<str.length(); i++){
            while(j > 0 && str.charAt(i) != pattern.charAt(j)){
                j = pi[j - 1];
            }
            if(str.charAt(i) == pattern.charAt(j)){
                if(j == pattern.length() - 1){
                    return 1;
                }
                else j++;
            }
        }
        return 0;
    }

    public static void makePi(String pattern) {
        int j = 0;
        for(int i = 1; i<pattern.length(); i++){
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }
}
