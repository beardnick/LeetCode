package practice;

public class PushBox {

    private static int steps = 0;
    private static int min = Integer.MAX_VALUE;
    private static char[][] m = null;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};
    private static void search(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
//            search(x + dx[i] , y + dy[i]);
            int tmpx = x + dx[i];
            int tmpy = y + dy[i];
            int tmpx1 = x + 2 * dx[i];
            int tmpy1 = y + 2 * dy[i];
            if (tmpx < 0 || tmpx >= m.length || tmpy < 0 || tmpy >= m.length || m[tmpx][tmpy] == '#') {
               return;
            }
            if (m[tmpx][tmpy] == '0' &&  m[tmpx1][tmpy1] != '#') {
                if (m[x + 2 * dx[i]][y + 2 * dy[i]] == 'E') {
                    steps ++;
                    min = Math.min(steps, min);
                    return;
                }
                steps ++;
                m[tmpx][tmpy] = 'x';
                m[x + 2 * dx[i]][y + 2 * dy[i]] = '0';
                search(tmpx, tmpy);
                m[tmpx][tmpy] = '0';
                m[x + 2 * dx[i]][y + 2 * dy[i]] = '.';
                steps --;
            }else{
                steps ++;
                search(tmpx, tmpy);
                steps --;
            }
        }
    }

    public static int solution(char[][] maize) {
        steps = 0;
        m = maize;
        int x = 0, y = 0;
        for (int i = 0; i < maize.length; i++) {
            for (int j = 0; j < maize[0].length; j++) {
                if (m[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        search(x, y);
        return min;
    }


    public static void main(String[] args) {
        char[][] maize = new char[][]{
                ".S#..E".toCharArray(),
                ".#.0..".toCharArray(),
                "......".toCharArray()
        };
        System.out.println(solution(maize));
    }
}
