import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> rank = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++){
            if (rank.size() < k){
                rank.add(score[i]);
            } else {
                if (rank.get(0) < score[i]){
                    rank.add(score[i]);
                    rank.remove(0);
                }
            }
            
            Collections.sort(rank);
            answer[i] = rank.get(0);
        }
        
        return answer;
    }
}
