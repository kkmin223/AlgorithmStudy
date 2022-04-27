class Solution {
    public String solution(String s) {
        String[] words = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i<words.length; i++){
            char[] word = words[i].toCharArray();
            for(int j = 0; j<word.length; j++){
                if(j%2==0){
                    word[j] = Character.toUpperCase(word[j]);
                } else {
                    word[j] = Character.toLowerCase(word[j]);
                }
            }
            answer.append(word);
            if(i != words.length-1)
                answer.append(" ");
        }
        if(s.length() > answer.length())  // 입력 문자열 뒤에 공백이 더 있을 경우
            answer.append(s.substring(answer.length()));
        
        return answer.toString();
    }
}
