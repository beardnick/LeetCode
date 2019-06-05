package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SolveSudoKu {

    public static void display(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public  HashSet<Character>[] rowSet;
    public  HashSet<Character>[] colSet;
    public  HashSet<Character>[] boxSet;


    public  boolean dfs(char[][] board) {
//        display(board);
//        System.out.println("- - - - - - - - - - - - - - - - - -");
        boolean finished = true;
        for (int i = 0; i < 9; i++) {
            if (rowSet[i].size() != 9 ||
                    colSet[i].size() != 9 ||
                    boxSet[i].size() != 9) {
                finished = false;
                break;
            }
        }
        if (finished) {
            return true;
        }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '-') {
                        for (int k = 1; k < 10; k++) {
                            char cur = (char) (k + '0');
                            if (!rowSet[i].contains(cur) &&
                                    !colSet[j].contains(cur) &&
                                    !boxSet[j / 3 + i / 3 * 3].contains(cur)) {
                                board[i][j] = cur;
                                rowSet[i].add(cur);
                                colSet[j].add(cur);
                                boxSet[j / 3 + i / 3 * 3].add(cur);
                                if(dfs(board)){
                                    return true;
                                }
                                board[i][j] ='-';
                                rowSet[i].remove(cur);
                                colSet[j].remove(cur);
                                boxSet[j / 3 + i / 3 * 3].remove(cur);
                            }
                        }
                        return false;
                    }
                }
            }
            return false;
        }

    public  void solveSudoku(char[][] board) {
        rowSet = new HashSet[9];
        colSet = new HashSet[9];
        boxSet = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '-') {
                    char cur = board[i][j];
                    rowSet[i].add(cur);
                    colSet[j].add(cur);
                    boxSet[j / 3 + i / 3 * 3].add(cur);
                }
            }
        }
        dfs(board);
//        display(board);
    }

    public static void main(String[] args) {
        SolveSudoKu solveSudoKu = new SolveSudoKu();
        char[][] board = new char[][] {
                {'5','3','-','-','7','-','-','-','-'},
                {'6','-','-','1','9','5','-','-','-'},
                {'-','9','8','-','-','-','-','6','-'},
                {'8','-','-','-','6','-','-','-','3'},
                {'4','-','-','8','-','3','-','-','1'},
                {'7','-','-','-','2','-','-','-','6'},
                {'-','6','-','-','-','-','2','8','-'},
                {'-','-','-','4','1','9','-','-','5'},
                {'-','-','-','-','8','-','-','7','9'}
        };
        solveSudoKu.solveSudoku( board );
        display(board);
//        char[][] arr = new char[9][9];
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            for (int i = 0; i < 9; i++) {
//                arr[i] = sc.next().toCharArray();
//            }
//            System.out.println("{");
//            for (int i = 0; i < 9; i++) {
//                System.out.print("{");
//                for (int j = 0; j < 9; j++) {
//                    if (j == 8) {
//                        System.out.print("'" + arr[i][j] + "'");
//                    } else {
//                        System.out.print("'" + arr[i][j] + "'" + ",");
//                    }
//                }
//                if (i == 8) {
//                    System.out.println("}");
//                } else {
//                    System.out.println("},");
//                }
//            }
//            System.out.println("}");
//        }
    }
}
