import java.io.File;
import java.io.IOException;
/**
 * 以下のディレクトリ構成で，カレントディレクトリが . の時，
 * 問題文のコマンドを実行するとどのような出力結果になるか，正しいものを選択せよ．
 *
 * ./sampledir/
 * ├── 0.txt
 * ├── a
 * │ ├── a.jpg
 * │ ├── a.txt
 * │ ├── a1
 * │ │ └── a1.txt
 * │ └── a2
 * │ └── a2.txt
 * ├── b
 * │ └── b.txt
 * └── c
 * ├── c.class
 * ├── c.gif
 * ├── c.java
 * ├── c.jpg
 * └── c.png
 */
public class SimpleListFiles{
 void run(String[] args){
 for(String targetFileName: args){
 File target = new File(targetFileName);
 listFiles(target);
 }
 }
 void listFiles(File file){
 System.out.printf("Target: %s%n", file.getPath());
 if(file.isDirectory()){
 for(File subfile: file.listFiles()){
 System.out.printf(" %s%n", subfile.getPath());
 }
 }
 }
 public static void main(String[] args){
 SimpleListFiles slf = new SimpleListFiles();
 slf.run(args);
 }
}