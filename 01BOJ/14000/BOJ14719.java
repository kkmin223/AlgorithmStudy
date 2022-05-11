package BOJ;

import java.util.Scanner;

public class BOJ14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] block = new int[w];
        for(int i = 0; i<w; i++){
            block[i] = sc.nextInt();
        }
        int idx1 = -1, idx2 =-1;
        int sum = 0;
        for(int i = 0; i<w; i++){
            if(block[i] != 0 && idx1 == -1){
                idx1 = i;
                idx2 = i+1;
            }
            else if(block[i] != 0 && idx1 != -1 && block[i] > block[idx2]){
                idx2 = i;
            } else if(block[i] != 0 && idx1 != -1 && block[i] <= block[idx2] && i != idx2){
                int min = Math.min(block[idx1], block[idx2]);
                for(int j = idx1+1; j<idx2; j++){
                    sum += block[j] - min;
                }
                idx1 = i;
                idx2 = i+1;
            }
        }
        System.out.println(sum);
    }
}
