import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17070 {
    static int n;
    static int[][] home;
    static class Pipe {
        int a1;
        int a2;
        int b1;
        int b2;

        public Pipe(int a1, int a2, int b1, int b2) {
            this.a1 = a1;
            this.a2 = a2;
            this.b1 = b1;
            this.b2 = b2;
        }

        public int getStatus(){
            // 가로 1, 세로 2, 대각선 3
            if(a1== b1) return 1;
            else if(a2== b2) return 2;
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
        System.out.println(bfs(new Pipe(0,0,0,1)));
    }
    public static int bfs(Pipe start){
        int cnt = 0;
        Queue<Pipe> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Pipe cur = q.poll();
            if(cur.b1 == n-1 && cur.b2 == n-1) {
                cnt++;
                continue;
            }
            int nx,ny;
            int status = cur.getStatus();
            if(status == 1){
                ny = cur.b1;
                nx = cur.b2+1;
                if(!isIn(nx,ny)){
                    if(home[ny][nx] != 1){
                        q.add(new Pipe(cur.b1, cur.b2, ny, nx));
                    }
                }
                ny = cur.b1+1;
                nx = cur.b2+1;
                if(!isIn(nx,ny)){
                    if(home[ny][nx]!= 1 && home[ny-1][nx] != 1 && home[ny][nx-1] != 1){
                        q.add(new Pipe(cur.b1, cur.b2, ny, nx));
                    }
                }
            } else if (status == 2){
                ny = cur.b1+1;
                nx = cur.b2;
                if(!isIn(nx,ny)){
                    if(home[ny][nx] != 1){
                        q.add(new Pipe(cur.b1, cur.b2, ny, nx));
                    }
                }
                ny = cur.b1+1;
                nx = cur.b2+1;
                if(!isIn(nx,ny)){
                    if(home[ny][nx]!= 1 && home[ny-1][nx] != 1 && home[ny][nx-1] != 1){
                        q.add(new Pipe(cur.b1, cur.b2, ny, nx));
                    }
                }
            } else {
                ny = cur.b1;
                nx = cur.b2+1;
                if(!isIn(nx,ny)){
                    if(home[ny][nx] != 1){
                        q.add(new Pipe(cur.b1, cur.b2, ny, nx));
                    }
                }
                ny = cur.b1+1;
                nx = cur.b2;
                if(!isIn(nx,ny)){
                    if(home[ny][nx] != 1){
                        q.add(new Pipe(cur.b1, cur.b2, ny, nx));
                    }
                }
                ny = cur.b1+1;
                nx = cur.b2+1;
                if(!isIn(nx,ny)){
                    if(home[ny][nx]!= 1 && home[ny-1][nx] != 1 && home[ny][nx-1] != 1){
                        q.add(new Pipe(cur.b1, cur.b2, ny, nx));
                    }
                }
            }
        }
        return cnt;
    }
    public static boolean isIn(int x, int y){
        return x < 0 || x >=n || y < 0 || y >= n;
    }
}
