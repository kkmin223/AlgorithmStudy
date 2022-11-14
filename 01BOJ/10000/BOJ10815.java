import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    public static int[] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        int n, m, target;

        n = Integer.parseInt(br.readLine());
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<m; i++){
            target = Integer.parseInt(st.nextToken());
            result.append(binarySearch(target)+ " ");
        }
        bw.write(result.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int target){
        int start = 0;
        int end = cards.length - 1;
        int mid = 0;
        while(start <= end){
            mid = (start + end) / 2;

            if(cards[mid] == target){
                return 1;
            } else if (cards[mid] < target){
                start = mid +1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
