import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {
    static int N,M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1,1,0,0,-1,1,1,-1};
    static int[] dc = {0,0,-1,1,-1,1,-1,1};
    static int answer = 0;
    static class Point {
        int row;
        int col;
        int distance;

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) continue;
                bfs(new Point(i,j,0));
            }
        }
        System.out.println(answer);

    }
    public static void bfs(Point p){
        isVisited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        isVisited[p.row][p.col] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(map[cur.row][cur.col] == 1){
                answer = Math.max(answer, cur.distance);
                break;
            }
            for(int i = 0; i<8; i++){
                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];
                if(isIn(nr,nc)) continue;
                if(isVisited[nr][nc]) continue;
                isVisited[nr][nc] = true;
                q.add(new Point(nr,nc,cur.distance+1));
            }
        }
    }
    public static boolean isIn(int row,int col){
        return row < 0 || row >= N || col < 0 || col >= M;
    }
}
