import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Demo {
    void run() throws IOException {
        BufferedImage image = ImageIO.read(new File("demo.png"));
        runDemo(image);
    }

    void runDemo(BufferedImage image) throws IOException {
        demo(image, AffineTransform.getRotateInstance(Math.toRadians(90)), "result01.png"); // (1)

        AffineTransform demo02 = AffineTransform.getRotateInstance(-Math.toRadians(90), image.getWidth() / 2, image.getHeight() / 2);
        demo(image, demo02, "result02.png"); // (2)

        demo(image, AffineTransform.getTranslateInstance(image.getWidth() / 2, 0), "result03.png"); // (3)

        AffineTransform flipX = AffineTransform.getScaleInstance(-1, 1);
        flipX.translate(-image.getWidth(), 0);
        demo(image, flipX, "result04.png"); // (4)
    }

    void demo(BufferedImage source, AffineTransform affine, String destFileName) throws IOException {
        BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.transform(affine);
        g.drawImage(source, 0, 0, null);
        ImageIO.write(result, "png", new File(destFileName));
    }

    public static void main(String[] args) throws IOException {
        Demo demo = new Demo();
        demo.run();
    }
}

