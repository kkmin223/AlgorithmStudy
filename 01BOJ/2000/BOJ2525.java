import java.util.Scanner;

public class BOJ2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int time = sc.nextInt();
        minute += time;
        hour += minute / 60;
        minute = minute % 60;
        hour = hour %24;
        System.out.println(hour + " " + minute);
    }
}
