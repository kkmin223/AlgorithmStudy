import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int fixedCost, variableCost, salePrice;
        fixedCost = Integer.parseInt(input[0]);
        variableCost = Integer.parseInt(input[1]);
        salePrice = Integer.parseInt(input[2]);
        if(salePrice - variableCost <= 0) System.out.println(-1);
        else {
            int profit = salePrice - variableCost;
            System.out.println(fixedCost/ profit + 1);
        }
    }
}
