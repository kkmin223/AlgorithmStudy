import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17070 {
    static int n;
    static int[][] home;
    static int answer = 0;
    static class Pipe {
        int y1;
        int x1;
        int y2;
        int x2;

        public Pipe(int y1, int x1, int b1, int b2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = b1;
            this.x2 = b2;
        }

        public int getStatus(){
            // 가로 1, 세로 2, 대각선 3
            if(y1 == y2) return 1;
            else if(x1 == x2) return 2;
            else return 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        home = new int[n][n];
        for(int i = 0; i<n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j<n; j++){
                home[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs(new Pipe(0, 0, 0, 1));
        System.out.println(answer);
    }
    public static void dfs(Pipe cur){
        if(cur.y2 == n-1 && cur.x2 == n-1) {
            answer++;
            return;
        }
        int nx,ny;
        int status = cur.getStatus();
        if(status == 1){
            ny = cur.y2;
            nx = cur.x2 +1;
            if(isIn(nx, ny)){
                if(home[ny][nx] != 1){
                    dfs(new Pipe(cur.y2, cur.x2, ny, nx));
                }
            }
        } else if (status == 2){
            ny = cur.y2 +1;
            nx = cur.x2;
            if(isIn(nx, ny)){
                if(home[ny][nx] != 1){
                    dfs(new Pipe(cur.y2, cur.x2, ny, nx));
                }
            }
        } else {
            ny = cur.y2;
            nx = cur.x2 +1;
            if(isIn(nx, ny)){
                if(home[ny][nx] != 1){
                    dfs(new Pipe(cur.y2, cur.x2, ny, nx));
                }
            }
            ny = cur.y2 +1;
            nx = cur.x2;
            if(isIn(nx, ny)){
                if(home[ny][nx] != 1){
                    dfs(new Pipe(cur.y2, cur.x2, ny, nx));
                }
            }
        }
        ny = cur.y2 +1;
        nx = cur.x2 +1;
        if(isIn(nx, ny)){
            if(home[ny][nx]!= 1 && home[ny-1][nx] != 1 && home[ny][nx-1] != 1){
                dfs(new Pipe(cur.y2, cur.x2, ny, nx));
            }
        }

    }
    public static boolean isIn(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
