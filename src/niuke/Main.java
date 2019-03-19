package niuke;

public class Main{

    public static boolean isSy(char[] s){
        for(int i = 0 , j = s.length - 1; i <= j ; i++ , j--){
            if(s[i] != s[j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        for(int i = 0 ; i < 256 ; i ++){
            if(Main.isSy(String.valueOf(i*i).toCharArray())){
                System.out.println(i);
            }
        }
    }


}
