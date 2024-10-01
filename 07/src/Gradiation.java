// 第07講 画像操作 例題1 グラデーション画像
// https://ksuap.github.io/2022autumn/lesson07/write/#例題1-グラデーション画像
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class Gradiation {
    void run() throws IOException {
        BufferedImage image = createImage();
        ImageIO.write(image, "png", new File("gradiation.png"));
    }
    BufferedImage createImage() {
        BufferedImage image = new BufferedImage(255, 255, BufferedImage.TYPE_INT_RGB);
        for(Integer x = 0; x < 255; x++) {
            for(Integer y = 0; y < 255; y++) {
                image.setRGB(x, y, x);
            }
        }
        return image;
    }
    public static void main(String[] args) throws IOException {
        Gradiation g = new Gradiation();
        g.run();
    }
}
