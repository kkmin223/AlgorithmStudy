import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1967 {
    static class Node {
        int end;
        int value;
        Node(int end, int value){
            this.end = end;
            this.value = value;
        }
    }
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int n;
    static int max = 0, maxIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree  = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            tree[from].add(new Node(to,value));
            tree[to].add(new Node(from, value));
        }
        // 1번 노드부터 탐색을 시작하여 가장 멀리 있는 노드를 탐색
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1,0);

        // 가장 멀리 있는 노드에서부터 탐색
        visited = new boolean[n+1];
        visited[maxIndex] = true;
        dfs(maxIndex,0);

        System.out.println(max);
    }

    /**
     * 재귀 호출을 이용한 dfs 탐색
     * @param i 탐색하는 노드 번호
     * @param score 지금까지 경로의 길이
     */
    public static void dfs(int i, int score){
        // max에 가장 긴 경로의 길이를 저장하고, maxIndex에 해당 노드의 번호 저장
        if(score  > max) {
            max = score;
            maxIndex = i;
        }
        for(Node n : tree[i]){
            if(!visited[n.end]){
                visited[n.end] = true;
                dfs(n.end, score+n.value);
            }
        }

    }
}
