package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14502 {
    static int n,m;
    static int[][] map;
    static int maxCnt = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class XY {
        int x;
        int y;
        XY(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 벽을 세우는 함수
     * 1. 재귀 함수를 이용해서 map이 0인 곳에서 벽을 세우는 경우와 안세우는 경우를 모두 탐색하도록 한다.
     * 2. 세운 벽이 3개가 된다면 바이러스를 퍼뜨리고 안전 영역을 카운트한다.
     * 3. 더 많은 안전 영역을 저장한다.
     */
    public static void setWall(int cnt){
        if(cnt == 3){
            int safeCnt = spreadVirus();
            maxCnt = Math.max(maxCnt, safeCnt);
        } else {
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    if(map[i][j] == 0){
                        // 벽을 세우는 경우
                        map[i][j] = 1;
                        setWall(cnt + 1);
                        // 벽을 세우지 않는 경우
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * 바이러스를 퍼뜨리는 함수
     * bfs를 이용해서 바이러스를 퍼뜨린다.
     * 큐에 바이러스가 존재하고 방문하지 않은 지점을 저장하고,
     * 해당 지점에서 상하좌우로 바이러스를 퍼뜨릴수 있는 안전영역을 탐색하고,
     * 바이러스를 퍼뜨린다.
     * 바이러스를 퍼뜨릴 수 있는 모든 영역에 퍼뜨리고 안전영역을 카운트하고 리턴해준다.
     */
    public static int spreadVirus(){
        Queue<XY> q = new LinkedList<>();
        int[][] visited = new int[n][m];  // 방문 여부를 저장하는 배열
        int[][] tempMap = new int[n][m];  // 기존 맵을 복사하는 배열
        // 맵을 복사한다.
        for(int i = 0; i<n; i++)
            for(int j = 0; j<m; j++)
                tempMap[i][j] = map[i][j];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                // 모든 map을 돌면서 바이러스를 퍼뜨린다.
                if(tempMap[i][j] == 2 && visited[i][j] == 0){
                    // 바이러스가 있고 방문하지 않은 지역을 방문한다.
                    q.add(new XY(i,j));
                    while(!q.isEmpty()){
                        XY cur = q.poll();
                        visited[cur.x][cur.y] = 1;
                        for(int k = 0; k<4; k++){
                            // 상하좌우로 바이러스를 퍼뜨릴 수 있는지 확인 후, 퍼뜨릴 수 있다면 퍼뜨린다.
                            int next_x = cur.x + dx[k];
                            int next_y = cur.y + dy[k];
                            if(!isIn(next_x,next_y)) continue;
                            if(tempMap[next_x][next_y] != 0 || visited[next_x][next_y] == 1) continue;
                            q.add(new XY(next_x,next_y));
                            tempMap[next_x][next_y] = 2;
                        }
                    }
                }
            }
        }
        return countSafe(tempMap);
    }

    /**
     * 안전 영역을 카운트 한다.
     * 맵을 돌면서 안전영역을 카운트하고 반환한다.
     */
    public static int countSafe(int[][] map) {
        int cnt = 0;
        for(int i = 0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    /**
     * map의 범위를 벗어나는지 확인하는 함수
     */
    public static boolean isIn(int x, int y){
        if(x >= 0 && x < n && y >= 0 && y < m) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        for(int i = 0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        setWall(0);
        System.out.println(maxCnt);
    }
}
