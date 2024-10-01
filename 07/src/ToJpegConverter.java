// 第07講 画像操作 例題2 画像の読み込み書き込み
// https://ksuap.github.io/2022autumn/lesson07/write/#例題2-画像の読み込み書き込み
import java.io.IOException;
import java.io.File;
import java.util.Objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ToJpegConverter {
    void run(String[] args) throws IOException {
        // 画像ファイルを読み込む．
        BufferedImage image = ImageIO.read(new File(args[0]));
        String destName = findFileNamet(args[1]);
        ImageIO.write(image, "jpg", new File(destName));
    }
    String findFileNamet(String fileName) {
        // ファイル名から最後のドット（.）の位置を取得する．
        Integer index = fileName.lastIndexOf(".");
        // 取得した位置から後ろの文字列を取得する．拡張子に相当する．
        String extension = fileName.substring(index + 1).toLowerCase();
        // 拡張子が jpg もしくは jpeg ならそのまま返す．
        if(Objects.equals(extension, "jpg") || Objects.equals(extension, "jpeg"))
            return fileName;
        // そうでなければ ".jpg" を追加して返す．
        return fileName + ".jpg";
    }
    public static void main(String[] args) throws IOException {
        ToJpegConverter ifc = new ToJpegConverter();
        ifc.run(args);
    }
}
