import java.util.ArrayList;
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
    static boolean[] isDeleted;
    static int[] prev;
    static int[] next;
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
        next[prev[cur]] = next[cur];
        prev[next[cur]] = prev[cur];
        if(next[cur] == max) cur = prev[cur];
        else cur = next[cur];
        deleteHistory.push(cur);
    }
    public static void revert(){
       int temp = deleteHistory.pop();
       isDeleted[temp] = false;
       next[prev[temp]] = temp;
       prev[next[temp]] = temp;
    }

    public static String solution(int n, int k, String[] cmd) {
        max = n;
        prev = new int[n+1];
        next = new int[n+1];
        isDeleted = new boolean[n];
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
