import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;

class Solution {
    class task {
        int priority;
        int index;
        public task(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
    public int solution(int[] priorities, int location) {
    int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<task> print = new LinkedList<>();
    for(int i = 0; i<priorities.length; i++){
        print.add(new task(priorities[i],i));
        pq.add(priorities[i]);
    }
    while(!print.isEmpty()){
        task cur = print.poll();
        if(cur.priority == pq.peek()){
            answer++;
            if(cur.index == location) break;
            pq.poll();
        } else {
            print.add(cur);
        }
    }
    return answer;
    }
}
