class Solution {
    public String solution(int[] food) {
        String answer = "";
        String num = "";
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for(int i = 1; i<food.length; i++){
            if(food[i] < 2){
                continue;
            }
            num = String.valueOf(i);
            length = food[i] / 2;
            for(int j = 0; j < length; j++){
                sb.append(num);
            }
        }
        answer = sb.toString() + "0" + sb.reverse().toString(); 
        return answer;
    }
}
