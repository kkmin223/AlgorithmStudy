class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];  // 각 열마다 최고점수를 기록할 배열이다.
        dp[0] = land[0]; // 첫번째 행은 그대로가 최고 점수이다.
        for(int i = 1; i<land.length; i++){
            for(int j = 0; j<4; j++){
                for(int k = 0; k<4; k++){
                    if(k==j) continue;
                    // 이전 행에서 현재 열을 제외하고 가장 큰 값을 찾는다.
                    dp[i][j] = Math.max(dp[i-1][k]+land[i][j], dp[i][j]);
                }
            }
        }
        // 마지막 행에서 가장 점수가 높은 열을 찾는다.
        for(int score: dp[land.length-1]){
            answer = Math.max(score,answer);
        }
        return answer;
    }
}
