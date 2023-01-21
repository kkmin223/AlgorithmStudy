import java.util.Arrays;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] can = new String[] {"aya", "ye", "woo", "ma"};
        String[] cannot = new String[] {"ayaaya", "yeye", "woowoo", "mama"};
        for(String babble : babbling){
            if (babble.contains(cannot[0]) 
                || babble.contains(cannot[1])
                || babble.contains(cannot[2])
                || babble.contains(cannot[3])){
                continue;
            }
            
            babble = babble.replace(can[0], " ");
            babble = babble.replace(can[1], " ");
            babble = babble.replace(can[2], " ");
            babble = babble.replace(can[3], " ");
            babble = babble.replace(" ", "");
            
            if (babble.length() == 0){
                answer++;
            }
            
        }
        return answer;
    }
}
