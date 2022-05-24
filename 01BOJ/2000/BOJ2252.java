import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2252 {
    static int N;
    static int M;
    static int[] linkCnt;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        linkCnt = new int[N + 1];
        graph = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            graph.add(i, new ArrayList<>());
        }
        for(int i = 0; i<M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            linkCnt[to]++;
        }
        System.out.println(topologicalSort());
    }
    public static String topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if(linkCnt[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int v : graph.get(cur)) {
                linkCnt[v] --;
                if(linkCnt[v] == 0) q.offer(v);
            }
            sb.append(cur).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
