import java.util.HashMap;
import java.util.HashSet;

class Solution {
    class User {
        HashSet<String> report; // 신고한 사람들 모음
        int count; // 신고 받은 횟수
        int alarm; // 메일 횟수
        User() {
            count = 0;
            alarm = 0;
            report = new HashSet<>();
        }
        public void beReported(){
            count += 1;
        }
        public void addAlarm(){
            alarm += 1;
        }

    }
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, User> users = new HashMap<>();
        for(int i = 0; i<id_list.length; i++){
            // users 초기화
            users.put(id_list[i],new User());
        }
        for (int i = 0; i < report.length; i++) {
            // 신고 처리
            String[] temp = report[i].split(" ");
            if(users.get(temp[0]).report.contains(temp[1])) continue;
            users.get(temp[0]).report.add(temp[1]);
            users.get(temp[1]).beReported();
        }
        for(int i = 0; i< id_list.length; i++){
            // 신고 결과 메일 처리
            if(users.get(id_list[i]).report.isEmpty()){
                answer[i] = 0;
                continue;
            }
            for(String reported: users.get(id_list[i]).report){
                if(users.get(reported).count >= k){
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}
