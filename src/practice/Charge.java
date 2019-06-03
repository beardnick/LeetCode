package practice;

import java.util.Scanner;

public class Charge {

    public static int solution(int n) {
        int res = 0;
        res += n / 64;
        n %= 64;
        res += n / 16;
        n %= 16;
        res += n / 4;
        n %= 4;
        res += n / 1;
        n %= 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(1024 - 200));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(solution(1024 - sc.nextInt()));
        }
//        System.out.println(solution(1024 - 200));
//        System.out.println(solution(1024 - 1024));
//        System.out.println(solution(1024 - 0));
    }
}
