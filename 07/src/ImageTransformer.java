// 第07講 画像操作 例題3 アフィン変換
// https://ksuap.github.io/2022autumn/lesson07/transform/#例題3-アフィン変換
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageTransformer {
    void run(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File(args[0]));
        BufferedImage result = doFilter(image);
        String format = findFormat(args[1]);
        ImageIO.write(result, format, new File(args[1]));
    }
    BufferedImage doFilter(BufferedImage source) {
        // 画像の中心座標を中心に π/2 （90 度）回転させるアフィン変換を作成する．
        AffineTransform affine = AffineTransform.getRotateInstance(Math.PI / 4,
                source.getWidth() / 2, source.getHeight() / 2);
        AffineTransformOp transformer = new AffineTransformOp(affine, AffineTransformOp.TYPE_BICUBIC);
        return transformer.filter(source, null);
    }
    String findFormat(String fileName) {
        Integer index = fileName.lastIndexOf(".");
        return fileName.substring(index + 1);
    }
    public static void main(String[] args) throws IOException {
        ImageTransformer transformer = new ImageTransformer();
        transformer.run(args);
    }
}
