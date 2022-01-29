import java.util.Arrays;
import java.util.Scanner;

public class BOJ1654 {

    static long solution(long[] arr, int k, int n){
        Arrays.sort(arr);
        long left = 1;
        long right = arr[k-1];
        long result = 0;
        while(left <= right){
            long mid = (left+right) / 2;
            int cnt = 0;
            for(long num : arr){
                cnt += num / mid;
            }
            if(cnt >= n){
                result = (result < mid)? mid: result;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] arr = new long[k];
        for(int i = 0; i < k; i++){
            arr[i] = sc.nextLong();
        }

        System.out.println(solution(arr,k,n));
    }
}
