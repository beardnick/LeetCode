package practice;

public class CrazyJumpFloor {

    public static int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        return 1 << (target - 1);
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(10));
        System.out.println(jumpFloor(1));
        System.out.println(jumpFloor(2));
        System.out.println(jumpFloor(3));
    }
}
