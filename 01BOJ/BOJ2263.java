import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2263 {
    static int n,idx = 0;
    static int[] inorder, preorder, postorder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        inorder = new int[n];
        postorder = new int[n];
        preorder = new int[n];
        // 입력 받기
        for(int i=0; i<n; i++){
            inorder[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            postorder[i] = Integer.parseInt(input[i]);
        }
        getPreorder(0,n-1,0,n-1);
        for(int num : preorder){
            System.out.print(num+" ");
        }
    }

    /**
     * postorder[pe]가 서브 트리의 루트이고, inorder는 이 값을 기준으로 왼쪽 자식과 오른쪽 자식을 구할 수 있다.
     * 트리를 루트 기준으로 왼쪽 서브 트리와 오른쪽 서브 트리로 노드가 1개일 때까지 쪼갠다.
     * @param is inorder 시작 인덱스
     * @param ie inorder 끝 인덱스
     * @param ps postorder 시작 인덱스
     * @param pe postorder 끝 인덱스
     */
     public static void getPreorder(int is, int ie, int ps, int pe){
        if(is <= ie && ps <= pe){
            preorder[idx++] = postorder[pe];
            int pivot = is;
            for(int i = is; i<=ie; i++){
                if(inorder[i] == postorder[pe]){
                    pivot = i;
                    break;
                }
            }
            // pivot - is == 서브트리의 노드 개수
            // 왼쪽 서브 트리
            getPreorder(is,pivot-1,ps, ps + pivot - is -1);
            // 오른쪽 서브 트리
            getPreorder(pivot+1,ie,ps + pivot - is,pe-1);
        }
     }

}
