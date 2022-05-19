import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1916 {
    static class Bus{
        int from;
        int to;
        int cost;
        public Bus(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    static Bus[] buses;
    static int[] distance;
    static int[][] map;
    static boolean[] visited;
    static int start, end;
    static int n,m;
    public static void main(String[] args) throws IOException {
//        initB();
//        bellmanFord(start);
        initD();
        dijkstra(start,end);
        System.out.println(distance[end]);
    }
    public static void initB() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        buses = new Bus[m];
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            Bus bus = new Bus(from, to, cost);
            buses[i] = bus;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
    public static void bellmanFord(int start){
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<m; j++){
                Bus bus = buses[j];
                if(distance[bus.from] == Integer.MAX_VALUE) continue;
                if(distance[bus.to] > distance[bus.from] + bus.cost){
                    distance[bus.to] = distance[bus.from] + bus.cost;
                }
            }
        }
    }
    public static void initD() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distance = new int[n+1];
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from][to] = cost;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
    public static void dijkstra(int start, int end){
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(map[start][i] == 0) continue;
            q.offer(i);
            distance[i] = map[start][i];
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            for(int i = 0; i<=n; i++){
                if(map[cur][i] == 0 || visited[i]) continue;
                if(distance[i] >= distance[cur] + map[cur][i]){
                    q.offer(i);
                    distance[i] = distance[cur] + map[cur][i];
                }
            }
        }

    }
}
