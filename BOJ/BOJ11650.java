import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
class data implements Comparable<data> {
    int x;
    int y;
    data(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(data obj){
        if(this.x!=obj.x){
            if(this.x<obj.x) return -1;
            else return 1;
        } else {
            if(this.y<obj.y) return -1;
            else return 1;
        }
    }
}
public class BOJ11650 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        data[] arr = new data[T];
        for(int i=0;i<T;i++){
            String input = br.readLine();
            String[] array = input.split(" ");
            int x = Integer.parseInt(array[0]);
            int y = Integer.parseInt(array[1]);
            arr[i]= new data(x,y);
        }
        Arrays.sort(arr);
        for(data temp: arr){
            String x,y;
            x = String.valueOf(temp.x);
            y = String.valueOf(temp.y);
            bw.write(x+" "+ y+"\n");
        }
        bw.flush();
        bw.close();
    }
}

