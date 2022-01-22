import java.util.Scanner;

public class BOJ2789 {

    int solution(int[] card, int m){
        int result = -1;
        for(int i = 0; i<card.length-2; i++){
            for(int j = i+1; j<card.length-1; j++){
                for(int k = j+1; k<card.length; k++){
                    int temp = card[i] + card[j] + card[k];
                    if(m - temp >=0 && m-temp < m-result){
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] card = new int[n];
        for(int i = 0; i<n; i++)
            card[i] = sc.nextInt();
        BOJ2789 Solution = new BOJ2789();
        System.out.println(Solution.solution(card, m));
    }
}
