// このプログラムは提出する必要はありません．
// 提出されても，標準のもので上書きされますので，このプログラムに施された変更は破棄されます．
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class SimpleConsole implements Iterator<String> {
    private Scanner scanner;

    public SimpleConsole(){
        scanner = new Scanner(System.in);
    }

    public String next() {
        return readLine();
    }

    public String readLine() {
        if(scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }

    public boolean hasNext() {
        return scanner.hasNextLine();
    }

    public void close() throws IOException{
        scanner.close();
    }
}
