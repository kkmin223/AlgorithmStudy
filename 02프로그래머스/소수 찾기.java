import java.util.HashSet;
class Solution {
    char[] nums;
    boolean[] visited;
    HashSet<Integer> hs = new HashSet<>();
    public int solution(String numbers) {
        nums = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        for(int i = 0 ; i<numbers.length(); i++){
            nums[i] = numbers.charAt(i);
        }
        dfs("");
        return hs.size();
    }
    
    void dfs(String str){
        if(str.length() != 0){
            int num = Integer.parseInt(str);
            if(isPrime(num)) {
                hs.add(num);
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(!visited[i]){
                if(str.length() == 0 && nums[i] == '0') continue;
                visited[i] = true;
                dfs(str+nums[i]);
                visited[i] = false;
            }
        }
        
    }
    
    boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
