import java.util.*;

public class BOJ13913 {
    static int source, destination;
    static int[] time = new int[100001];
    static int[] parent = new int[100001];
    static int[] move = {-1,1,2};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        source = sc.nextInt();
        destination = sc.nextInt();
        bfs();
        printAnswer();
    }

    public static void printAnswer() {
        System.out.println(time[destination]);
        Stack<Integer> paths = new Stack<>();
        int path = destination;
        while (path != source) {
            paths.add(path);
            path = parent[path];
        }
        paths.add(path);
        while (!paths.isEmpty()) {
            System.out.print(paths.pop() + " ");
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        time[source] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == destination) break;
            for(int i = 0; i<3; i++){
                int next;
                if(i==2){
                    next = cur * move[i];
                } else {
                    next = cur + move[i];
                }
                if(next < 0 || next > 100000) continue;
                if(time[next] != 0) continue;
                q.offer(next);
                time[next] = time[cur] + 1;
                parent[next] = cur;
            }
        }
    }
}
