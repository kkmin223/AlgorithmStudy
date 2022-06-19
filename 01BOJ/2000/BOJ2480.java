import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<3; i++){
            int num = sc.nextInt();
            int count = 0;
            if(hm.containsKey(num)){
                count = hm.get(num);
            }
            hm.put(num,count+1);
        }
        int max = 0;
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if(entry.getValue() == 2){
                result =1000 + entry.getKey() * 100;
                System.out.println(result);
                return;
            } else if(entry.getValue() == 3){
                result =10000 + entry.getKey() * 1000;
                System.out.println(result);
                return;
            } else {
                max = Math.max(max, entry.getKey());
            }
        }
        System.out.println(max * 100);
    }
}
