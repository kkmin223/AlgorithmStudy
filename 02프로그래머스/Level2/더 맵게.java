import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int food: scoville) minHeap.add(food);
        int answer = 0;
        while(minHeap.size() >1 && minHeap.peek()<K){
            int food1 = minHeap.poll();
            int food2 = minHeap.poll();
            minHeap.add(food1 + food2 * 2);
            answer++;
        }
        if(minHeap.isEmpty() || minHeap.peek() < K) return -1;
        else return answer;
    }
}
