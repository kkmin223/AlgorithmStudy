import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> orders = new ArrayList<>();
        List<Integer> multitap = new ArrayList<>();
        int answer = 0;
        for(int i = 0; i<k; i++){
            orders.add(Integer.parseInt(st.nextToken()));
        }
        while(!orders.isEmpty()){
            int order = orders.remove(0);
            if(multitap.contains(order)) continue;
            if(multitap.size() < n){
                multitap.add(order);
            } else {
                boolean flag = false;
                int idx = -1;
                int maxIdx = -1;
                answer++;
                for(int i = 0; i<multitap.size(); i++){
                    if(!orders.contains(multitap.get(i))){
                        flag = true;
                        multitap.remove(i);
                        multitap.add(order);
                        break;
                    } else {
                        if(orders.indexOf(multitap.get(i))> idx){
                            idx = orders.indexOf(multitap.get(i));
                            maxIdx = i;
                        }
                    }
                }
                if(!flag){
                    multitap.remove(maxIdx);
                    multitap.add(order);
                }
            }
        }
        System.out.println(answer);
    }
}
