/*
name : FileCounter.java
about : 第07講 小テスト7-2 FileCounter
        https://cclms.kyoto-su.ac.jp/mod/assign/view.php?id=152788
        コマンドライン引数で指定されたディレクトリに格納されているファイルとディレクトリの一覧を表示する（1階層のみ）。
        その後，出力したもののうち，ファイルの数，ディレクトリの数を出力する。
date : 2023_May25
coder : Muto Tao(254739)
*/


import java.io.File;        //File型を用いるため
import java.util.ArrayList;     //リストを用いるため


public class FileCounter{
    ArrayList<File> directoryList = new ArrayList<>();      // 指定されたディレクトリ内のディレクトリのリストを作成するためのリスト
    ArrayList<File> fileList = new ArrayList<>();       // 指定されたディレクトリ内のファイルのリストを作成するためのリスト


    void run(String[] args){
        File targetDirectory = new File(args[0]);        // 入力された文字列からFile型の変数を作成
        fileCounter(targetDirectory);       // 指定されたディレクトリ内のディレクトリとファイルをそれぞれのためのリストに格納する。
        printResult(directoryList, fileList);       // 結果をターミナルに表示する。
    }


    void fileCounter(File targetDirectory){     // 指定されたディレクトリ内のディレクトリとファイルをそれぞれのためのリストに格納するメソッド
        for(Integer i = 0; i < targetDirectory.listFiles().length; i ++){
            if(targetDirectory.listFiles()[i].isDirectory()){
                directoryList.add(targetDirectory.listFiles()[i]);
            }else{
                fileList.add(targetDirectory.listFiles()[i]);
            }
        }
    }


    void printResult(ArrayList<File> targetDirectory, ArrayList<File> targetFile){       // 結果をターミナルに表示するメソッド
        for(Integer i = 0; i < targetFile.size(); i ++){       // ファイルの名前を表示
            System.out.println(targetFile.get(i).getName());
        }

        for(Integer i = 0; i < targetDirectory.size(); i ++){       // ディレクトリの名前を表示
            System.out.println(targetDirectory.get(i).getName());
        }

        System.out.printf("file: %d, dir: %d%n", targetFile.size(), targetDirectory.size());        // ファイルとディレクトリの数を表示
    }


    public static void main(String[] args){
        FileCounter fileCounter = new FileCounter();
        fileCounter.run(args);
    }
}
