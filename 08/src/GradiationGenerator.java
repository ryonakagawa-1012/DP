// 第８講 InputStream/OutputStream型 例題6 pnm画像の生成
// https://ksuap.github.io/2022autumn/lesson08/inoutstream/#例題-6-pnm-画像の生成
import java.io.FileOutputStream;
import java.io.IOException;

public class GradiationGenerator{
    void run() throws IOException{
        FileOutputStream out = new FileOutputStream("gradiation.ppm");
        this.writeHeader(out);
        this.writeBody(out);
        out.close();
    }

    void writeBody(FileOutputStream out) throws IOException{
        for(Integer i = 0; i < 256; i++){ // 画像の縦方向
            for(Integer j = 0; j < 256; j++){ // 横方向
                out.write(i); // R成分
                out.write(0); // G成分
                out.write(j); // B成分
            }
        }
    }

    void writeHeader(FileOutputStream out) throws IOException{
        out.write('P');  // ヘッダ部分は文字で表される．
        out.write('6');
        out.write('\n'); // 環境が変わっても \n を出力する必要がある．
        out.write('2');  // 横幅
        out.write('5');
        out.write('6');
        out.write(' ');
        out.write('2');  // 高さ
        out.write('5');
        out.write('6');
        out.write('\n');
        out.write('2');  // １画素の１色成分の最大値
        out.write('5');
        out.write('5');
        out.write('\n');
    }

    public static void main(String[] args) throws IOException {
        GradiationGenerator generator = new GradiationGenerator();
        generator.run();
    }
}
