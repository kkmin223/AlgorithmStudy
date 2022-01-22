class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if(arr.length == 1) {
            answer = new int[] {-1};
        } else{
            answer = new int[arr.length-1];
            int min = arr[0];
            for(int i=1; i<arr.length; i++){
                if(min > arr[i])
                    min = arr[i];
            }
            int idx = 0;
            for(int num: arr){
                if(num != min) answer[idx++] = num;
            }
        } 
        return answer;
    }
}
