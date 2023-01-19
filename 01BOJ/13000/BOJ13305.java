import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] distance = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] cost = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long answer = distance[0] * cost[0];
        long minCost = cost[0];

        for (int i = 1; i < n-1; i++){
            if(cost[i] < minCost){
                minCost = cost[i];
            }
            answer += distance[i] * minCost;
        }
        System.out.println(answer);
    }
}
