class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String temp = "";
        for (String skill_tree : skill_trees){
            temp = skill_tree;
            for (char c : skill_tree.toCharArray()){
                if (skill.indexOf(c) == -1){
                    temp = temp.replace(String.valueOf(c), "");
                }
            }
            
            if (skill.indexOf(temp) == 0){
                answer++;
            }
        }
        return answer;
    }
}
