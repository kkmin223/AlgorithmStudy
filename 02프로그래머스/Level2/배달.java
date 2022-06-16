import java.util.*;
class Solution {
    public int[] distance;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        bfs(N, road);
        for(int i =2; i<=N; i++){
            if(distance[i] <=K) answer++;
        }
        return answer+1;
    }
    public void bfs(int N, int[][] road){
        distance = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i<road.length; i++){
                if(road[i][0] == cur) {
                    int to = road[i][1];
                    int cost = road[i][2];
                    if(distance[to] != 0 && distance[to] <= cost) continue;
                    if(distance[to] == 0) {
                        distance[to] = distance[cur] + cost;
                        q.add(to);
                    }
                    else if(distance[to] > distance[cur] + cost){
                        distance[to] = distance[cur] + cost;
                        q.add(to);
                    }
                } else if(road[i][1] == cur) {
                    int to = road[i][0];
                    int cost = road[i][2];
                    if(distance[to] != 0 && distance[to] <= cost) continue;
                    if(distance[to] == 0) {
                        distance[to] = distance[cur] + cost;
                        q.add(to);
                    }
                    else if(distance[to] > distance[cur] + cost){
                        distance[to] = distance[cur] + cost;
                        q.add(to);
                    }
                    
                }
            }
        }
    }
}
