package practice;

import java.util.Arrays;

public class Grey {
//
    public static String[] getGrey(int n) {
        if (n < 1) {
            return new String[]{""};
        }
        String[] temp = getGrey(n - 1);
        String[] result = new String[temp.length * 2];
        int cnt = 0;
        for (int i = 0; i < temp.length; i++) {
            result[cnt++] = "0" + temp[i];
        }
        for (int i = temp.length - 1; i >= 0 ; i-- ) {
            result[cnt++] = "1" + temp[i];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getGrey(10)));
        System.out.println(Arrays.toString(getGrey(1)));
        System.out.println(Arrays.toString(getGrey(-1)));
        System.out.println(Arrays.toString(getGrey(0)));
        System.out.println(Arrays.toString(getGrey(2)));
        System.out.println(Arrays.toString(getGrey(3)));
        System.out.println(Arrays.toString(getGrey(5)));
//        System.out.println(Arrays.toString(getGrey(1000)));
    }
}
