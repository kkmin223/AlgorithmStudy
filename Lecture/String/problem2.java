package Lecture.string;

import java.util.Scanner;

public class problem2 {
    public String solution(String input){
        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()){
            if(c >= 'a'&& c<='z'){
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        problem2 T = new problem2();
        String input = sc.next();
        System.out.print(T.solution(input));
    }
}
