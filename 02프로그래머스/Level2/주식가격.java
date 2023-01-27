import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> st = new Stack<>();
        st.push(new Stock(prices[0], 0));
        for (int i = 1; i<prices.length; i++){
            while (prices[i] < st.peek().price){
                Stock cur = st.pop();
                answer[cur.day] = i - cur.day;
                if (st.isEmpty()){
                    break;
                }
            }  
            st.push(new Stock(prices[i], i));
        }
        while(!st.isEmpty()){
            Stock cur = st.pop();
            answer[cur.day] = prices.length - cur.day - 1;
        }
        
        return answer;
    }
    
    class Stock {
        int price;
        int day;
        
        public Stock(int p, int d){
            price=p;
            day = d;
        }
    }
}
