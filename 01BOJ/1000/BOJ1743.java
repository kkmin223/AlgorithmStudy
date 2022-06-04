import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1743 {
    static int n,m,k;
    static int[][] map;
    static boolean[][] isVisited;
    static int answer = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        map = new int[n][m];
        isVisited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            String[] rc = br.readLine().split(" ");
            int r = Integer.parseInt(rc[0])-1;
            int c = Integer.parseInt(rc[1])-1;
            map[r][c] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !isVisited[i][j]){
                    bfs(new Node(i, j));
                }
            }
        }
        System.out.println(answer);
    }
    public static void bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        int size = 0;
        q.offer(node);
        isVisited[node.row][node.col] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            size++;

            for(int i = 0; i<4; i++){
                int nr = cur.row + dr[i];
                int nc = cur.col + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(isVisited[nr][nc]) continue;
                if(map[nr][nc] != 1) continue;
                isVisited[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
        answer = Math.max(size, answer);
    }
}
