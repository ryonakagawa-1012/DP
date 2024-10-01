import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Cropping {
    void run(String[] args) throws IOException {
        BufferedImage source = ImageIO.read(new File(args[0]));
        Integer width = Integer.valueOf(args[1]);
        Integer height = Integer.valueOf(args[2]);
        BufferedImage result = transform(source, width, height);
        ImageIO.write(result, "png", new File("crop_result.png"));
    }

    BufferedImage transform(BufferedImage source, Integer width, Integer height) throws IOException {
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = result.createGraphics();
        g2.drawImage(source, (width - source.getWidth()) / 2, (height - source.getHeight()) / 2, null);
        return result;
    }

    public static void main(String[] args) throws IOException {
        Cropping cropping = new Cropping();
        cropping.run(args);
    }
}