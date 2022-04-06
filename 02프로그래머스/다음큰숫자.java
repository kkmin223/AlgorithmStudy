class Solution {
    public int solution(int n) {
        int oneCnt = Integer.bitCount(n);
        int newCnt = -1;
        int newNum = n;
        while(oneCnt != newCnt){
            newNum++;
            newCnt = Integer.bitCount(newNum);
        }
        return newNum;
    }
}
