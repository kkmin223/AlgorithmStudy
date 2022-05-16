import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1062 {
    static boolean[] alphabet;
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
            String str = br.readLine();
            //모든 단어가 anta와 tica를 포함하기 때문에 공백으로 바꿔서 처리
            //필수로 배워야 하는 알파벳 a, c, i, n, t 가 있음
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }
        if(k<5) {
            // 5개보다 적으면 a, c, i, n, t 를 배우지 못함
            System.out.println(0);
            return;
        } else if(k==26) {
            // 모든 알파벳을 다 배우는 경우
            System.out.println(n);
            return;
        }
        alphabet = new boolean[26];
        alphabet[0] = true; //a
        alphabet[2] = true; //c
        alphabet[8] = true; // i
        alphabet[13] = true; //n
        alphabet[19] = true; //t
        studyWord(1,5);
        System.out.println(answer);
    }


    public static void studyWord(int start, int alphabetCnt){
        // 백트래킹을 이용해서 모든 경우의 수 탐색.
        // 0~26으로 순차적으로 처리하기 때문에 start 매개변수로 이미 지나온 곳은 탐색하지 않게 해서 시간 복잡도를 줄임.
        if(alphabetCnt == k){
            int cnt = 0;
            for(int i = 0; i<n; i++){
                boolean flag = true;
                for(int j = 0; j< words[i].length(); j++){
                    // words[i]에 포함된 알파벳 중에 안배운 알파벳이 있는지 검사
                    if(!alphabet[words[i].charAt(j) - 'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for(int i = start; i<26; i++){
            if(!alphabet[i]){
                alphabet[i] = true;
                studyWord(i,alphabetCnt+1);
                alphabet[i] = false;
            }
        }

    }
}
