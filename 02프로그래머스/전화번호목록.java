import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        // 정렬 후 앞뒤 인덱스만 비교
        for(int i = 0; i<phone_book.length-1;i++){
            String shortNum = phone_book[i+1];
            String longNum = phone_book[i];
            if(phone_book[i].length() < phone_book[i+1].length()){
                shortNum = phone_book[i];
                longNum = phone_book[i+1];
            }
            if(longNum.startsWith(shortNum)){
                return false;
            }
        }
        return answer;
    }
}
