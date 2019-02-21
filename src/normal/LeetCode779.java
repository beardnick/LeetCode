package normal;

import hard.LeetCode51;

public class LeetCode779 {

    public static int kthGrammar(int N, int K) {
        if(N == 1){
            return  0;
        }
        if(K % 2 == 0){
            return kthGrammar(N - 1, K / 2) ^ 1;
        }else {
            return kthGrammar(N - 1, (K + 1) / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                LeetCode779.kthGrammar(4, 5)
        );
        System.out.println(
                LeetCode779.kthGrammar(4, 6)
        );
        System.out.println(
                LeetCode779.kthGrammar(4, 7)
        );
    }

}
