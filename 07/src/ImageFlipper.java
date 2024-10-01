// 第07講 画像操作 例題4 画像の上下反転
// https://ksuap.github.io/2022autumn/lesson07/transform/#例題4-画像の上下反転
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageFlipper {
    void run(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File(args[0]));
        BufferedImage result = doFilter(image);
        String format = findFormat(args[1]);
        ImageIO.write(result, format, new File(args[1]));
    }
    BufferedImage doFilter(BufferedImage source) {
        // x方向に1倍，y方向に-1倍する．
        AffineTransform affine = AffineTransform.getScaleInstance(1, -1);
        // 上の変換に加えて，x方向に0，y方向に source の高さ分だけ移動させる．
        affine.translate(0, -source.getHeight());
        AffineTransformOp transformer = new AffineTransformOp(affine, AffineTransformOp.TYPE_BICUBIC);
        return transformer.filter(source, null);
    }
    String findFormat(String fileName) {
        Integer index = fileName.lastIndexOf(".");
        return fileName.substring(index + 1);
    }
    public static void main(String[] args) throws IOException {
        ImageFlipper flipper = new ImageFlipper();
        flipper.run(args);
    }
}
