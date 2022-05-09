package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14888 {
    static int[] nums;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        String[] s = br.readLine().split(" ");
        int[] op = new int[4];
        for(int i = 0; i< n; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        String[] s1 = br.readLine().split(" ");
        for(int i = 0; i<4; i++){
            op[i] = Integer.parseInt(s1[i]);
        }
        makeExp(1, nums[0], op);
        System.out.println(max);
        System.out.println(min);
    }
    public static void makeExp(int idx, int val, int[] op){
        if(idx == nums.length){
            min = Math.min(val, min);
            max = Math.max(val, max);
        } else {
            for(int i = 0; i < 4; i++){
                if(op[i] != 0){
                    op[i]--;
                    switch (i){
                        case 0:
                            makeExp(idx+1,val + nums[idx], op);
                            op[i]++;
                            break;
                        case 1:
                            makeExp(idx + 1, val - nums[idx], op);
                            op[i]++;
                            break;
                        case 2:
                            makeExp(idx + 1, val * nums[idx], op);
                            op[i]++;
                            break;
                        case 3:
                            makeExp(idx + 1, val / nums[idx], op);
                            op[i]++;
                            break;
                        default:

                    }
                }
            }
        }
    }
}
