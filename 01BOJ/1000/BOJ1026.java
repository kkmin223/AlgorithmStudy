import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1026 {
    static int solution(int[] A, int[] B, int N){
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i =0 ; i<N; i++){
            sum += A[i] * B[N-i-1];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i<N;i++){
            A[i] = sc.nextInt();
        }
        int[] B = new int[N];
        for(int i = 0; i<N;i++){
            B[i] = sc.nextInt();
        }
        System.out.println(solution(A,B,N));
    }
}
