import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Gradiation2 {
    void run() throws IOException {
        BufferedImage image = createImage();
        ImageIO.write(image, "png", new File("gradiation2.png"));
    }

    BufferedImage createImage() {
        BufferedImage image = new BufferedImage(255, 255, BufferedImage.TYPE_INT_RGB);

        for(Integer x = 0; x < 255; x++) {
            for(Integer y = 0; y < 255; y++) {
                image.setRGB(x, y, x | (y << 16));
            }
        }
        return image;
    }

    public static void main(String[] args) throws IOException {
        Gradiation2 g = new Gradiation2();
        g.run();
    }
}