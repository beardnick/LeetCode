package practice;

import java.util.Scanner;

public class BigIntegerMul {

    public static String bigIntegerMul(String number1, String number2) {
        if (number1 == null || number2 == null || number1.length() < 1 || number2.length() < 1) {
            return "";
        }
        char[] x1 = number1.toCharArray();
        char[] x2 = number2.toCharArray();
        int[] result = new int[number1.length() * number2.length() + 1];
        for (int i = x1.length - 1; i >= 0; i--) {
            for (int j = x2.length - 1; j >= 0; j--) {
                result[x1.length - 1 - i + x2.length - 1 - j] += (x1[i] - '0') * (x2[j] - '0');
            }
            for (int j = 0; j < result.length - 1; j++) {
                if (result[j] >=10) {
                    result[j + 1] += result[j] / 10;
                    result[j] = result[j] % 10;
                }
            }
        }
        int cnt = result.length - 1;
        while (result[cnt] == 0) {
            cnt --;
        }
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(String.valueOf(result[cnt]));
        } while (-- cnt >= 0);
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(bigIntegerMul("123", "100"));
//        System.out.println(bigIntegerMul("", "100"));
//        System.out.println(bigIntegerMul("12", "15"));
//        System.out.println(bigIntegerMul("72106547548473106236", "982161082972751393"));
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(
                bigIntegerMul(line.split(" ")[0], line.split(" ")[1])
        );
    }
}
