//学籍番号:2354233
//氏名：蓮見考紘


import java.util.Objects;

public class Arguments {
    //画像の種類
    int imgType=0;
    //ソートの種類
    int sortType=0;
    //画像の名前
    String imgName="data.png";
    //csvファイル名
    String csvName="";

    //コンストラクタ(13行)
   public Arguments(String[] args){
       //引数をすべて確認
        for(int i = 0; i < args.length; i++){
            //引数がオプションでない場合
            if(!args[i].startsWith("--")){
                //csvファイル名を取得
                csvName=args[i];
            }
            else {
                //オプションの場合はparseOptionメソッドで処理
               parseOption(args,i);
               //次の引数に進む
               i++;
            }
        }
        //csvファイル名が空の場合はエラー
        if(csvName.equals("")){
            System.out.println("解析ファイルパスは必須です");
            System.exit(1);
        }
    }

    //オプションを解析(19行)
    void parseOption(String[] args, Integer i) {
        if(Objects.equals(args[i], "--dest")){
           imgName = args[i+1];
        }
        else if(Objects.equals(args[i], "--sort")){
            switch (args[i+1]) {
                case "id" -> sortType = 0;
                case "score" -> sortType = 1;
                case "time" -> sortType = 2;
            }
        }
        else if(Objects.equals(args[i], "--heatmap")){
            switch (args[i+1]) {
                case "score" -> imgType = 0;
                case "time" -> imgType = 1;
            }
        }
        else if(Objects.equals(args[i], "--help")){
            printHelp();
        }
    }

    //ヘルプを表示(7行)
    void printHelp(){
        System.out.println("java ScoreAnalyzer5 [OPTIONS] <FILENAME.CSV>");
        System.out.println("OPTIONS:");
        System.out.println("--dest <FILENAME>  出力ファイル名を指定");
        System.out.println("--sort <id|score|time>  ソート順を指定");
        System.out.println("--type <score|time>  出力タイプを指定");
        System.out.println("--help  ヘルプを表示");
        System.exit(0);
    }
}
