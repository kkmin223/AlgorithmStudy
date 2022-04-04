import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1167 {
    static class Node{
        int to;
        int dist;
        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
    static int V;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int max = 0, maxIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int i = 0; i<=V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1 ; i<=V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1){
                    break;
                }
                int dist = Integer.parseInt(st.nextToken());
                graph[idx].add(new Node(to,dist));
            }
        }
        visited = new boolean[V+1];
        dfs(1,0);

        visited = new boolean[V+1];
        dfs(maxIndex,0);

        System.out.println(max);
    }

    /**
     * dfs 탐색을 통해서 가장 멀리 있는 노드와의 경로 길이와 그 노드의 인덱스를 구하는 함수.
     * @param i 탐색하려는 노드 인덱스
     * @param dist 지금까지의 경로의 길이
     */
    static void dfs(int i, int dist){
        if(dist > max){
            max = dist;
            maxIndex = i;
        }
        visited[i] = true;
        for(Node n : graph[i]){
            if(!visited[n.to]){
                dfs(n.to,dist+n.dist);
            }
        }
    }
}
