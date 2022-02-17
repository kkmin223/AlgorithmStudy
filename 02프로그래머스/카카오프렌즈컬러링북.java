import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class XY {
        int x;
        int y;
        int value; // 해당 좌표의 그림
        XY(){};
        XY(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    boolean isIn(int x, int y, int m, int n){
        // 영역을 벗어나는지 검사하는 함수
        return (x <0 || x>=m || y < 0 || y >=n);
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] visited = new int[m][n]; //방문한 위치인지 기록(1이면 이미 방문한 위치)
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<XY> q = new LinkedList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int size=0;
                if(picture[i][j] != 0 && visited[i][j]==0){
                    q.add(new XY(i,j,picture[i][j]));
                    visited[i][j] = 1;
                    numberOfArea++;
                }
                while(!q.isEmpty()){
                    // BFS를 사용하여 영역 찾기
                    XY cur = q.poll();
                    size++;
                    for(int k =0; k<4; k++){
                        // dx, dy를 이용하여 현재 위치의 상하좌우를 탐색
                        int next_x = cur.x + dx[k];
                        int next_y = cur.y + dy[k];
                        if(isIn(next_x, next_y, m, n)){
                            continue;
                        }
                        int next_v = picture[next_x][next_y];
                        if(next_v == cur.value 
                           && visited[next_x][next_y]==0){
                            q.add(new XY(next_x,next_y, next_v));
                            visited[next_x][next_y] = 1;
                        }
                    }
                }
                if(size > maxSizeOfOneArea) maxSizeOfOneArea = size;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
