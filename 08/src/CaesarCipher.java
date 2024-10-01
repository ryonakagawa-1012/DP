import java.io.*;

public class CaesarCipher {
    void run(String[] args) throws IOException {
        Integer key = Integer.valueOf(args[0]);
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);

        generateCaesarCipher(key, in, out);

        in.close();
        out.close();
    }

    void generateCaesarCipher(Integer key, FileInputStream in, FileOutputStream out) throws IOException {
        Integer data;

        while((data = in.read()) != -1){
            if(data + key < 0){
                out.write(data + key + 256);
            }else if(data + key >= 256){
                out.write(data + key - 256);
            }else{
                out.write(data + key);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.run(args);
    }
}