import java.util.*;

public class BOJ4153 {
    public static int solution(int[] num){
        if(num[0]==0){
            return -1;
        }
        Arrays.sort(num); // 배열 오름차순으로 정렬(num[2]가 항상 빗변이 될 수 있기 위해서)
        if(num[0]*num[0] + num[1]*num[1] == num[2]*num[2]){
            System.out.println("right");
        }
        else {
            System.out.println("wrong");
        }
        return 1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int result = 0;
        while(result!=-1) {
            int[] num = new int[3];
            for (int i = 0; i < 3; i++) {
                num[i] = input.nextInt();
            }
            result = solution(num);
        }
    }
}
