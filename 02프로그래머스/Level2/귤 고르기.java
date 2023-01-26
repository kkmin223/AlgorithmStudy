import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i<tangerine.length; i++){
            if(hm.containsKey(tangerine[i])){
                int cnt = hm.get(tangerine[i]);
                hm.put(tangerine[i], cnt+1);
            } else {
                hm.put(tangerine[i], 1);
            }
        }

        List<Integer> keySet = new ArrayList<>(hm.keySet());
        keySet.sort((o1, o2) -> hm.get(o2).compareTo(hm.get(o1)));
        for (Integer key : keySet){
            answer++;
            k -= hm.get(key);
            if (k <= 0){
                break;
            }
        }
            
        return answer;
    }
}
