package practice;

import java.util.LinkedList;
import java.util.Scanner;

public class SmartEditor {

    public static void solution(String input) {
        char[] chars = input.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (Character x : chars) {
            if (stack.size() >= 2 && stack.getLast().equals(x))
             {
                if ( (stack.getLast().equals(stack.get(stack.size() - 2))) // AAA
                ||( stack.size() >= 3 && stack.get(stack.size() - 3).equals(stack.get(stack.size() - 2) ) ) ){ // AABB
                    continue;
                }
            }
                stack.addLast(x);
        }
        stack.forEach(System.out::print);
        System.out.println();
    }


    public static void main(String[] args) {
//        System.out.println(solution("helloo"));
//        System.out.println(solution("wooooooow"));
//        System.out.println(solution(""));
//        System.out.println(solution("aabbbaa"));
//        System.out.println(solution("aa"));
//        System.out.println(solution("aaa"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n -- != 0) {
            solution(sc.next());
        }
    }
}
