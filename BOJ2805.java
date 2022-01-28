import java.util.Arrays;
import java.util.Scanner;

public class BOJ2805 {

    static int cutHeight(int[] trees, int m){
        Arrays.sort(trees);
        int left = 0;
        int right = trees[trees.length-1];
        while(left <= right){
            long sum =0;
            int mid = (left + right) / 2;
            for(int tree : trees){
                if(tree-mid > 0) sum += tree-mid;
            }
            if(sum > m) left = mid +1;
            else if(sum < m) right = mid-1;
            else{
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] trees = new int[n];
        for (int i = 0; i <n ; i++) {
            trees[i] = sc.nextInt();
        }
        System.out.println(cutHeight(trees,m));
    }
}
