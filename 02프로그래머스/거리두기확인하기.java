import java.util.ArrayList;
class Solution {
    public class seat {
        int r;
        int c;
        seat(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i<5; i++){
            answer[i] = checkRoom(places[i]);
        }
        return answer;
    }
    public int checkRoom(String[] room){
        char[][] map = new char[5][5];
        ArrayList<seat> seats = new ArrayList<>();
        for(int i=0; i<5; i++){
            map[i] = room[i].toCharArray();
        }
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(map[i][j] == 'P'){
                    for(seat s: seats){
                        int distance = getDistance(i,j,s.r,s.c);
                        if(distance ==1){
                            // 바로 옆에 있을 때
                            return 0;
                        } else if(distance == 2){
                            if(i==s.r){
                                // 같은r에 있을 때
                                if(map[i][(j+s.c)/2] != 'X') return 0;
                                else continue;
                            } else if(j == s.c){
                                // 같은j에 있을 때
                                if(map[(i+s.r)/2][j] != 'X') return 0;
                                else continue;
                            } else {
                                // 대각선으로 있을 때
                                if(isIn(i-1,j) && map[i-1][j] != 'X'){
                                    return 0;
                                }
                                if((j < s.c && map[i][j+1] != 'X')
                                    || (j > s.c && map[i][j-1]!='X')){
                                    return 0;
                                }
                            }
                        }
                    }
                    seats.add(new seat(i,j));
                }
            }
        }
       return 1; 
        
    }
    public int getDistance(int r1, int c1, int r2, int c2){
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }
    public boolean isIn(int r, int c){
        return (r>=0 && r<5) && (c>=0 && c<5);
    }
}
