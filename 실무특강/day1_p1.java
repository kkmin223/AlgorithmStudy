import java.util.*;
public class day1_p1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] moves = sc.nextLine().split(" ");
        int x =1, y=1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        char[] direction = {'U','D','L','R'};
        for(String move: moves){
            char temp = move.charAt(0);
            int temp_x=-1 ,temp_y=-1;
            for(int i=0;i<4;i++){
                if(direction[i]==temp){
                    temp_x = x + dx[i];
                    temp_y = y + dy[i];
                }
            }
            if(temp_x>0 && temp_y>0 && temp_x<=n && temp_y<=n){
                x=temp_x;
                y=temp_y;
            }

        }
        System.out.printf("%d %d\n", x,y);
    }


}
