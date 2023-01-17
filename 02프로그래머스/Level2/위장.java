import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
      
        for (int i = 0; i<clothes.length; i++){
            if(hm.containsKey(clothes[i][1])){
                int cnt = hm.get(clothes[i][1]);
                hm.put(clothes[i][1], cnt+1);
            } else {
                hm.put(clothes[i][1], 1);
            }
        }
        
        Iterator<Map.Entry<String, Integer>> entry = hm.entrySet().iterator();
        Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();

        for (Map.Entry<String, Integer> element : entrySet) {
            answer *= (element.getValue() + 1);
        }
        
        return answer-1;
    }
}
