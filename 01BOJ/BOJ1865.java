import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1865 {
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static String answer;
    static int n;
    static private final int INF = 987654321;
    static class Node {
        int to;
        int time;
        Node(int to, int time){
            this.to = to;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i =0 ;i<=n; i++){
                list.add(new ArrayList<>());
            }
            //== 입력 받기 ==//
            for(int i = 1; i<=v+w; i++){
                st = new StringTokenizer(br.readLine()," ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if(i <= v){
                    list.get(s).add(new Node(e,t));
                    list.get(e).add(new Node(s,t));
                } else {
                    list.get(s).add(new Node(e,t*-1));
                }
            }
            //== 벨만 포드 알고리즘 수행==//
            dist = new int[n+1];
            answer = bellman_ford() ? "YES":"NO";
            sb.append(answer+"\n");
        }
        System.out.print(sb.toString());
    }
	//==벨만-포드 알고리즘==//
    public static boolean bellman_ford(){
        //배열 초기화
        Arrays.fill(dist,INF);
        //시작 지점 초기화
        dist[1] = 0; 
        boolean update = false;
        // n-1번까지
        for(int i =1; i< n; i++){
            update = false;
            //== 최단거리 초기화==//
            for(int j =1; j<= n; j++){
                for(Node n: list.get(j)){
                    if(dist[n.to]>dist[j] + n.time){
                        dist[n.to] = dist[j] + n.time;
                        update = true;
                    }
                }
            }
            // 더이상 업데이트가 안되면 break;
            if(!update) break;
        }
        //n번까지 촤단경로 업데이트가 이루어진다면
        //음의 사이클이 존재하는것이라고 판단한다.
        if(update) {
            for (int i = 1; i <= n; i++) {
                for (Node n : list.get(i)) {
                	// 이때 거리가 줄어든다면, 음의 순환이 이루어지고 있는것이다.
                    if (dist[n.to] > dist[i] + n.time) {
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
