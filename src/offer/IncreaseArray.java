package offer;

public class IncreaseArray {

    public static boolean Find(int target, int [][] array) {
        int i = 0;
        int j = array[0].length - 1;
        while(i >= 0 && j >= 0 && i < array.length && j < array[0].length){
//            System.out.println("i:" + i + " j:" + j);
            if(target > array[i][j]){
                i ++;
            }else if(target < array[i][j]){
                j --;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = new int[][]{
//                {1, 3, 5, 7},
//                {6, 7, 8, 9},
//                {9, 10, 11, 12},
//                {10, 11, 13, 14}
                {}
        };
        int [][] test = new int[][]{};
        System.out.println(Find(1, array));
        System.out.println(Find(4, array));
        System.out.println(Find(11, array));
        System.out.println(Find(10, array));
    }
}
