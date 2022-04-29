import java.util.HashMap;
class Solution {
    public int answer = 0;
    public boolean[] visited = new boolean[8];
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public int solution(int n, String[] data) {
        dfs("",data);
        return answer;
    }
    public void dfs(String line, String[] data){
        if(line.length() == 8){
            if(check(line, data)) answer++;
            return;
        }
        for(int i = 0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                String newLine = line + friends[i];
                dfs(newLine, data);
                visited[i] = false;
            }
        }
    }
    public boolean check(String line, String[] data) {
        for(String d: data){
            int idx1 = line.indexOf(d.charAt(0));
            int idx2 = line.indexOf(d.charAt(2));
            char op = d.charAt(3);
            int num = d.charAt(4) - '0' + 1;
            int diff = Math.abs(idx1-idx2);
            if(op == '='){
                if(diff != num) return false;
            }
            if(op == '<'){
                if(diff >= num) return false;
            }
            if(op == '>'){
                if(diff <= num) return false;
            }
        }
        return true;
    }
}