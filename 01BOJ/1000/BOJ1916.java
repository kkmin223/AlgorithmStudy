import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bus{
    int from;
    int to;
    int cost;
    public Bus(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}
public class BOJ1916 {
    static Bus[] buses; // edge 모음 - 벨맨포드에서 사용
    static int[] distance;
    static ArrayList<ArrayList<Node>> list; // 인접리스트 - 다익스트라에서 사용
    static boolean[] visited;
    static int start, end;
    static int n,m;
    public static void main(String[] args) throws IOException {
//        initB();
//        bellmanFord(start);
        initD();
        dijkstra(start,end);
        System.out.println(dijkstra(start, end));
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
    public static int bellmanFord(int start){
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
        return distance[end];
    }
    public static void initD() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        list = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            list.add(i, new ArrayList<>());
        }

        for(int i = 0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        visited = new boolean[n + 1];
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.to;
            if(cur == end) break;
            if(visited[cur]) continue;
            visited[cur] = true;
            for (Node next : list.get(cur)) {
                if(!visited[next.to] && distance[next.to] > distance[cur] + next.cost){
                    distance[next.to] = distance[cur] + next.cost;
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }
        return distance[end];
    }
}
