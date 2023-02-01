import java.util.Scanner;

public class Main {

    static int yearE = 16;
    static int yearS = 29;
    static int yearM = 20;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int targetE, targetS, targetM;
        int answer = 1;
        int e, s, m;
        targetE = sc.nextInt();
        targetS = sc.nextInt();
        targetM = sc.nextInt();
        e = 1;
        s = 1;
        m = 1;

        while (true){
            if (e == targetE && s == targetS && m == targetM){
                System.out.println(answer);
                break;
            }
            answer += 1;
            e = ++e==yearE ? 1 : e;
            s = ++s==yearS ? 1 : s;
            m = ++m==yearM ? 1 : m;
        }


    }
}
