import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;

public class ImageEditor {
    void run(String[] args) throws IOException {
        BufferedImage source = ImageIO.read(new File(args[0])); // 画像ファイルを読み込む
        Double degree = Double.valueOf(args[1]); // 回転の角度を取得
        Double angle = Math.toRadians(degree); // 角度を弧度法に変換

        // 変換後の画像の大きさを計算
        Double widthDouble = source.getWidth() * Math.sin(angle) + source.getWidth() * Math.cos(angle);
        Double heightDouble = source.getHeight() * Math.sin(angle) + source.getHeight() * Math.cos(angle);
        Integer width = widthDouble.intValue();
        Integer height = heightDouble.intValue();

        BufferedImage image = rotateImage(source, angle, width, height); // 画像を回転
        ImageIO.write(image, "png", new File(args[2])); // 画像をPNGファイルに書き出す
    }

    BufferedImage rotateImage(BufferedImage source, Double angle, Integer width, Integer height) {
        AffineTransform affine = new AffineTransform(); // アフィン変換のための実体を作成
        affine.translate(source.getWidth() * Math.sin(angle), 0d); // 並行移動
        affine.rotate(angle); // 回転

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 描画器の実体を作成
        Graphics2D g2 = result.createGraphics(); // 描画器を作成
        g2.drawImage(source, affine, null);

        return result;
    }

    public static void main(String[] args) throws IOException {
        ImageEditor ie = new ImageEditor();
        ie.run(args);
    }
}