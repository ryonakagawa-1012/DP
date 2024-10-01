import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.io.File;

public class GrayScaleFilter {
    void run(String[] args) throws IOException {
        BufferedImage source = ImageIO.read(new File(args[0]));
        BufferedImage grayImage = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        BufferedImage image = createGrayImage(source, grayImage);
        ImageIO.write(image, "png", new File("gray.png"));
    }

    BufferedImage createGrayImage(BufferedImage source, BufferedImage grayImage) {
        Graphics2D g2 = grayImage.createGraphics();
        g2.drawImage(source, 0, 0, null);

        return grayImage;
    }

    public static void main(String[] args) throws IOException {
        GrayScaleFilter gsf = new GrayScaleFilter();
        gsf.run(args);
    }
}