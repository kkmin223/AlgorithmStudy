import java.util.*;

public class BOJ2108 {
    static int avg (int[] arr){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return (int)Math.round((double) sum / arr.length);
    }

    static int middle(int[] arr){
        return arr[arr.length/2];
    }

    static int range(int[] arr){
        return arr[arr.length-1] - arr[0];
    }

    static int manyNumber(int[] arr, HashMap<Integer,Integer> hm){
        int maxCnt = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue() > maxCnt){
                maxCnt = entry.getValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if(entry.getValue() == maxCnt){
                arrayList.add(entry.getKey());
            }
        }
        if(arrayList.size() == 1){
            return arrayList.get(0);
        }
        Collections.sort(arrayList);
        return arrayList.get(1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            int num = sc.nextInt();
            if(!hm.containsKey(num)) {
                hm.put(num, 1);
            } else {
                int cnt = hm.get(num);
                hm.put(num,cnt+1);
            }
            sum += num;
            arr[i] = num;
        }

        Arrays.sort(arr);

        System.out.println(avg(arr));
        System.out.println(middle(arr));
        System.out.println(manyNumber(arr,hm));
        System.out.println(range(arr));
    }
}

