import java.util.Stack;
class Solution {

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(solution(n,k,cmd));
    }
    static Stack<Integer> deleteHistory = new Stack<>();
    static int cur;
    static boolean[] isDeleted = new boolean[1000001];
    static int[] prev = new int[1000001];
    static int[] next = new int[1000001];
    static int max;
    public static void up(int x){
        for(int i=0; i<x; i++){
            cur = prev[cur];
        }
    }
    public static void down(int x){
        for(int i=0; i<x; i++){
            cur = next[cur];
        }
    }
    public static void delete(){
        isDeleted[cur] = true;
        if(prev[cur] != -1) next[prev[cur]] = next[cur];
        if(next[cur] != max) prev[next[cur]] = prev[cur];
        deleteHistory.push(cur);
        if(next[cur] == max) cur = prev[cur];
        else cur = next[cur];

    }
    public static void revert(){
       int temp = deleteHistory.pop();
       isDeleted[temp] = false;
       if(prev[temp] != -1) next[prev[temp]] = temp;
       if(next[temp] != max) prev[next[temp]] = temp;
    }

    public static String solution(int n, int k, String[] cmd) {
        max = n;
        for(int i = 0; i<n; i++){
            prev[i] = i-1;
            next[i] = i+1;
        }
        cur = k;
        for(String str: cmd){
            String[] input = str.split(" ");
            if(input[0].equals("U")){
                up(Integer.parseInt(input[1]));
            } else if(input[0].equals("D")){
                down(Integer.parseInt(input[1]));
            } else if(input[0].equals("C")){
                delete();
            } else if(input[0].equals("Z")){
                revert();
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<n; i++){
            if(isDeleted[i]) answer.append("X");
            else answer.append("O");
        }
        return answer.toString();
    }


}
