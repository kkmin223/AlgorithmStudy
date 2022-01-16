import java.util.Scanner;

public class BOJ1439 {
    // https://kkmdailylog.tistory.com/entry/AlgorithmJavaBOJ-1439%EB%B2%88-%EB%92%A4%EC%A7%91%EA%B8%B0
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char prev = input.charAt(0);
        int zeroGruop = 0, oneGroup = 0; // 각각 그룹을 나누어 카운팅
        for(int i=1; i<input.length(); i++){
            char cur = input.charAt(i);
            if(prev != cur){
                // 현재 값과 이전 값이 다르면 이전 값의 그룹의 +1
                if(prev == '0')
                    zeroGruop++;
                else
                    oneGroup++;
            }
            if(i==input.length()-1){
                // 마지막 인덱스에 속한 그룹도 +1을 해주기 위해서 추가
                if(cur == '0')
                    zeroGruop++;
                else
                    oneGroup++;
            }
            prev = cur;
        }
        // 두 그룹 중 최소값을 가진 그룹 출력
        System.out.println(Math.min(zeroGruop, oneGroup));
    }
}
