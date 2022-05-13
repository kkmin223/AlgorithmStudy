import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1062 {
    static boolean[] alphabet = new boolean[26];
    static String[] words;
    static int answer = Integer.MIN_VALUE;
    static int k,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        words = new String[n];
        for(int i = 0; i<n; i++){
            words[i] = br.readLine();
        }
        if(k<5) System.out.println(0);
        else {
            alphabet[0] = true; //a
            alphabet[2] = true; //c
            alphabet[8] = true; // i
            alphabet[13] = true; //n
            alphabet[19] = true; //t
            studyWord(5,k);
            System.out.println(answer);
        }

    }
    public static void studyWord(int alphabetCnt, int k){
        if(alphabetCnt == k){
            int wordCnt = 0;
            for(int i = 0; i<n; i++){
                boolean flag = true;
                for(char c : words[i].substring(4, words[i].length()-4).toCharArray()){
                    if(!alphabet[c-'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag) wordCnt++;
            }
            answer = Math.max(wordCnt, answer);
        } else {
            for(String word: words){
                for(char c : word.substring(4, word.length()-4).toCharArray()){
                    if(alphabet[c-'a']) continue;
                    alphabet[c - 'a'] = true;
                    studyWord(alphabetCnt+1, k);
                    alphabet[c-'a'] = false;
                }
            }
        }
    }
}
