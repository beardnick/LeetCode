package practice;

import java.util.Scanner;

public class RoundGame {


    public static long solve(long m , long n, long b){
        if(2 * n > b){
            return  Math.min(
                   m % n == 0 ? m / n: m / n + 1 ,
                    ((m - b) % n == 0 ? (m -b ) / n : (m - b) / n + 1) + 2
            );
        }else{
                    long x = m % b == 0 ? m / b: m / b + 1 ;
                    long rest = m - (x -1) * b;
                    if(2 * n < rest){
                        return x * 2;
                    }else {
                        return 2 * x - 2 + (rest % n == 0 ? rest / n : rest / n + 1);
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(solve(13, 3, 5));
//        System.out.println(solve(13, 3, 7));
//        System.out.println(solve(3, 3, 5));
//        System.out.println(solve(1, 3, 5));
//        System.out.println(solve(1, 5, 3));
//        System.out.println(solve(1000_000_000, 5, 3));
//        System.out.println(solve(1000_000_000, 1000_000_000, 1000_000_000));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(
                    solve(sc.nextLong(), sc.nextLong(), sc.nextLong())
            );
        }
    }


}
