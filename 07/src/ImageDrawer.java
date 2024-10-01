// 第07講 画像操作 例題5 画像への書き込み
// https://ksuap.github.io/2022autumn/lesson07/transform/#例題5-画像への書き込み
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageDrawer {
    void run(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File(args[0]));
        BufferedImage result = doFilter(image);
        String format = findFormat(args[1]);
        ImageIO.write(result, format, new File(args[1]));
    }
    BufferedImage doFilter(BufferedImage image) {
        Graphics2D g = image.createGraphics();   // 描画器を取得する．
        g.setStroke(new BasicStroke(5f)); // 線の太さを設定する．
        g.setColor(Color.BLUE); // 色を設定する．
        g.drawRect(10, 10, image.getWidth() - 20, image.getHeight() - 20); // 四角形を描く
        g.setColor(Color.ORANGE);
        g.drawOval(20, 20, image.getWidth() - 40, image.getHeight() - 40); // 楕円を描く
        return image;
    }
    String findFormat(String fileName) {
        Integer index = fileName.lastIndexOf(".");
        return fileName.substring(index + 1);
    }
    public static void main(String[] args) throws IOException {
        ImageDrawer drawer = new ImageDrawer();
        drawer.run(args);
    }
}
