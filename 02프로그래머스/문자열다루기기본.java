class Solution {
    public boolean solution(String s) {
        char[] arr = s.toCharArray();
        if(arr.length == 4|| arr.length == 6){
            for(char c: arr){
                if(c<'0' || c>'9')
                    return false;
            }
            return true;
        }
        
        return false;
    }
}