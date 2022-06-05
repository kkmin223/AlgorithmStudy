package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14226 {
    static int target;
    static boolean[][] isVisited = new boolean[5000][5000]; // [화면에 있는 이모티콘 수][클립보드에 있는 이모티콘 수]
    static class Emoticon {
        int countOnScreen;
        int countOnClipboard;
        int time;

        public Emoticon(int countOnScreen, int countOnClipboard, int time) {
            this.countOnScreen = countOnScreen;
            this.countOnClipboard = countOnClipboard;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(1, 0, 0));
        isVisited[1][0] = true;
        while (!q.isEmpty()) {
            Emoticon cur = q.poll();
            int countOnScreen = cur.countOnScreen;
            int countOnClipboard = cur.countOnClipboard;
            int time = cur.time;
            if(countOnScreen == target){
                return time;
            }
            if(countOnScreen > 0 && countOnScreen < 1001){
                // 화면에 있는 이모티콘 클립보드에 저장
                if(!isVisited[countOnScreen][countOnScreen]){
                    q.add(new Emoticon(countOnScreen, countOnScreen, time + 1));
                    isVisited[countOnScreen][countOnScreen] = true;
                }
                // 화면에 있는 이모티콘 한개 삭제
                if(!isVisited[countOnScreen-1][countOnClipboard]){
                    q.add(new Emoticon(countOnScreen - 1, countOnClipboard, time + 1));
                    isVisited[countOnScreen - 1][countOnClipboard] = true;
                }
            }
            if(countOnClipboard != 0){
                //클립보드에 있는 모든 이모티콘 붙여넣기
                if(!isVisited[countOnScreen+countOnClipboard][countOnClipboard]){
                    q.add(new Emoticon(countOnScreen + countOnClipboard, countOnClipboard, time + 1));
                    isVisited[countOnScreen + countOnClipboard][countOnClipboard] = true;
                }
            }
        }
        return -1;
    }
}
