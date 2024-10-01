import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;

public class ImageRotater {
    void run(String[] args) throws IOException {
        BufferedImage source = ImageIO.read(new File(args[0]));
        Double degree = Double.valueOf(args[1]);
        Double angle = Math.toRadians(degree);
        BufferedImage image = rotateImage(source, angle);
        ImageIO.write(image, "png", new File(args[2]));
    }

    BufferedImage rotateImage(BufferedImage source, Double angle) {
        AffineTransform affine = new AffineTransform();
        affine.translate(source.getWidth() * Math.sin(angle), 0d);
        affine.rotate(angle);

        Double widthDouble = source.getWidth() * Math.sin(angle) + source.getWidth() * Math.cos(angle);
        Double heightDouble = source.getHeight() * Math.sin(angle) + source.getHeight() * Math.cos(angle);
        Integer width = widthDouble.intValue();
        Integer height = heightDouble.intValue();

        BufferedImage resulte = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resulte.createGraphics();
        g2.drawImage(source, affine, null);

        return resulte;
    }

    public static void main(String[] args) throws IOException {
        ImageRotater ir = new ImageRotater();
        ir.run(args);
    }
}