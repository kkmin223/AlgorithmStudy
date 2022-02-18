import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remainDays = new int[progresses.length];
        //각 기능을 완료하는데 걸리는 일 저장
        for(int i = 0; i<progresses.length; i++){
            int remain = 100 - progresses[i];
            remainDays[i] = (remain % speeds[i] == 0) ? remain/speeds[i] : remain/speeds[i] + 1;
        }
        
        // 각각 배포 단계에서 몇개의 기능이 포함될 지 계산
        ArrayList<Integer> deploy = new ArrayList<>();
        for(int i = 0 ; i< remainDays.length; i++){
            if(remainDays[i]<0) continue;
            int count = 1;
            for(int j = i+1; j<remainDays.length; j++){
                if(remainDays[j] >remainDays[i]) break;
                remainDays[j] = -1;
                count++;
            }
            deploy.add(count);
        }
        int[] answer = new int[deploy.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = deploy.get(i);
        }
        return answer;
    }
}
