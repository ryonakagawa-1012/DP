public class LeapYear {
    public static void main(String[] args){
        Integer year = 2004;
        Boolean leapYear = false;
        // ここに判定処理を書いていく．

        if(year % 4 == 0){

            if(year % 100 == 0){

                if(year % 400 == 0){
                    leapYear = true;
                }

            }
            else{
                leapYear = true;
            }

        }

        if(leapYear){ // leapYearがtrueの場合．
            System.out.printf("%d年はうるう年です．%n", year);
        }
        else{
            System.out.printf("%d年はうるう年ではありません．%n", year);
        }
    }
}
