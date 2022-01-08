import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BOJ10828 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] stack = new int[T];
        int top = -1;
        while(T--!=0){
            String input = br.readLine();
            if(input.startsWith("push")){
                String[] token = input.split(" ");
                int num = Integer.parseInt(token[1]);
                stack[++top] = num;
            }
            else if(input.startsWith("pop")){
                if(top==-1){
                    bw.write("-1\n");
                    continue;
                }
                bw.write(String.valueOf(stack[top--])+"\n");
            }
            else if(input.startsWith("size")){
                bw.write(String.valueOf(top+1)+"\n");
            }
            else if(input.startsWith("empty")){
                if(top==-1){
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
            else if(input.startsWith("top")){
                if(top==-1){
                    bw.write("-1\n");
                    continue;
                }
                bw.write(String.valueOf(stack[top])+"\n");
            }
            bw.flush();
        }
        bw.flush();
        bw.close();
    }
}
