import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageFormatConverter {
    void run(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File(args[0]));
        String format = findFileExtension(args[1]);
        ImageIO.write(image, format, new File(args[1]));
    }

    String findFileExtension(String fileName) {
        Integer index = fileName.lastIndexOf(".");
        String extension = fileName.substring(index + 1).toLowerCase();

        return extension;
    }

    public static void main(String[] args) throws IOException {
        ImageFormatConverter ifc = new ImageFormatConverter();
        ifc.run(args);
    }
}