public class XPrinter {
    public static void main(String[] args){

        for (Integer i = 0; i < 10; i++){
            StringBuilder ans = new StringBuilder();
            for (Integer j = 0; j < 10; j++){
                if (j == i || j == 9 - i){
                    ans.append("X");
                }
                else {
                    ans.append(".");
                }
            }
            System.out.println(ans);
        }
    }
}
