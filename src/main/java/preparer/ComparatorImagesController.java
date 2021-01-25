package preparer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ComparatorImagesController {
    public static void main(String[] args) throws Exception {
        BufferedImage img1 = ImageIO.read(new File("/home/g/Downloads/java_test_task/testImages/1.jpg"));
        BufferedImage img2 = ImageIO.read(new File("/home/g/Downloads/java_test_task/testImages/2.jpg"));

        ComparatorImages1.compare(img1,img2);

    }

}
