class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long longP = Long.parseLong(p);
        long temp = 0;
        int targetLength = t.length() - pLength + 1;
        for (int i = 0; i< targetLength; i++){
            temp = Long.parseLong(t.substring(i, i + pLength));
            if (temp <= longP){
                answer++;
            }
        }
        return answer;
    }
}
