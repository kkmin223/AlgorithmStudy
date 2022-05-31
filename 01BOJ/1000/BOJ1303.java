import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1303 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int W = 0, B = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                bfs(new Node(i, j));
            }
        }
        System.out.print(W + " " + B);
    }

    public static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        char color = map[node.x][node.y];
        visited[node.x][node.y] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isIn(nx, ny)) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != color) continue;
                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
        if(color == 'W') W += cnt*cnt;
        else B += cnt*cnt;
    }

    public static boolean isIn(int x, int y) {
        return x < 0 || x >= m || y < 0 || y >= n;
    }
}
