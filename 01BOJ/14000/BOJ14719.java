package BOJ;

import java.util.Scanner;

public class BOJ14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        boolean[][] block = new boolean[h][w];
        int answer = 0;
        for(int i = 0; i<w; i++){
            int cnt = sc.nextInt();
            for(int j = 0; j<cnt; j++) block[j][i] = true;
        }

        for(int i = 0; i<h; i++){
            int left = 0;
            boolean flag = false;
            for(int j = 0; j<w; j++){
                if(block[i][j]){
                    if(!flag){
                        flag = true;
                    } else {
                        answer += j-left-1;
                    }
                    left = j;
                }
            }
        }
        System.out.println(answer);
    }
}
