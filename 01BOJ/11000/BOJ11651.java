import java.io.*;
import java.util.Arrays;

class Point implements Comparable<Point>{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(y == o.y){
            return Integer.compare(x, o.x);
        }
        return Integer.compare(y, o.y);
    }
}


public class BOJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Point[] list;
        int n = Integer.parseInt(br.readLine());
        list = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list[i] = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        Arrays.sort(list);
        for(Point point : list){
            sb.append(point.x + " " + point.y + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
