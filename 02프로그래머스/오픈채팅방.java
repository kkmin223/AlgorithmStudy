import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public String[] solution(String[] records) {
        String[] answer;
        HashMap<String, String> users = new HashMap<>();
        ArrayList<String> messages = new ArrayList<>();
        for(String record: records){
            String[] token = record.split(" ");
            String command = token[0];
            String uid = token[1];
            if(command.equals("Enter")){
                String nickname = token[2];
                users.put(uid,nickname);
                messages.add(uid + " Enter");
            } else if(command.equals("Change")){
                String nickname = token[2];
                users.put(uid,nickname);
            }
            else if(command.equals("Leave")){
                messages.add(uid + " Leave");
            }
        }
        answer = new String[messages.size()];
        for(int i = 0; i<messages.size(); i++){
            String[] message = messages.get(i).split(" ");
            String username = users.get(message[0]);
            if(message[1].equals("Enter")){
                answer[i] = username + "님이 들어왔습니다.";
            } else {
                answer[i] = username + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
