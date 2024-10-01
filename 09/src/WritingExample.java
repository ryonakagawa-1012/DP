import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class WritingExample{
 void run(String[] args) throws IOException{
 PrintWriter writer1 = new PrintWriter(new FileWriter("file1.txt"));
 PrintWriter writer2 = new PrintWriter(new FileWriter("file2.txt"));
 PrintWriter writer3 = new PrintWriter(new FileWriter("file3.txt"));
 PrintWriter writer4 = new PrintWriter(new FileWriter("file4.txt"));
 writer1.println("おはようございます!");
 writer2.println("Good Morning!");
 writer3.println("Guten Morgen!");
 writer4.println("Buon giorno!");
 writer3.println("Good Afternoon!");
 writer2.println("Buona sera!");
 writer4.println("こんばんは!");
 writer1.close();
 writer2.close();
 writer3.close();
 writer4.close();
 }
 public static void main(String[] args) throws IOException{
 WritingExample example = new WritingExample();
 example.run(args);
 }
}
