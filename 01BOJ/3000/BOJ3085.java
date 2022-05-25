import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    static int answer = 1;
    static int n;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }
        check();
        Bomboni();
        System.out.println(answer);
    }
    public static void Bomboni() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nx = i + 1;
                int ny = j;
                if(isIn(nx,ny)) continue;
                swap(i, j, nx, ny);
                check();
                swap(i, j, nx, ny);
                nx = i;
                ny = j + 1;
                if(isIn(nx,ny)) continue;
                swap(i, j, nx, ny);
                check();
                swap(i, j, nx, ny);
            }
        }
    }

    public static void check() {
        int cnt = 1;
        for (int a = 0; a < n; a++) {
            cnt = 1;
            for(int b = 0; b< n-1; b++){
                if (map[a][b] == map[a][b + 1]) {
                    cnt++;
                    answer = Math.max(answer, cnt);
                } else {

                    cnt = 1;
                }
            }
        }
        for (int a = 0; a < n; a++) {
            cnt = 1;
            for(int b = 0; b< n - 1; b++){
                if (map[b][a] == map[b + 1][a]) {
                    cnt++;
                    answer = Math.max(answer, cnt);
                } else {
                    cnt = 1;
                }

            }
        }
    }

    private static void swap(int i, int j, int nx, int ny) {
        char temp = map[i][j];
        map[i][j] = map[nx][ny];
        map[nx][ny] = temp;
    }

    public static boolean isIn(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

}
