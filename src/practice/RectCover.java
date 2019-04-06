package practice;

public class RectCover {

    public static int solve(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return  2;
        }
        int x = 1;
        int y = 2;
        int z = x + y;
        int cnt = 3;
        while (++cnt <= target) {
            x = y;
            y = z;
            z = x + y;
        }
        return  z;
    }

    public static void main(String[] args) {
        System.out.println(solve(4));
        System.out.println(solve(1));
        System.out.println(solve(-1));
        System.out.println(solve(10));
        System.out.println(solve(10000));
    }
}
