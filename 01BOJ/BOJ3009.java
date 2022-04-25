import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hmX = new HashMap<>();
        HashMap<Integer, Integer> hmY = new HashMap<>();
        for(int i = 0; i<3; i++){
            String[] input =  br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            if(hmX.containsKey(x)){
                hmX.put(x, 2);
            } else hmX.put(x,1);
            if(hmY.containsKey(y)){
                hmY.put(y, 2);
            } else hmY.put(y, 1);
        }
        int answerX=0,answerY=0;
        for (Map.Entry<Integer, Integer> y : hmY.entrySet()) {
            if(y.getValue() == 1){
                answerY = y.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> x : hmX.entrySet()) {
            if(x.getValue() == 1)
                answerX = x.getKey();
        }
        System.out.println(answerX +" "+ answerY);
    }
}
