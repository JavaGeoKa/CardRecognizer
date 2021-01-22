package Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Recognizer {

//  3
//  private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_060003.065_0x173E0290.png";

//5
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_064009.827_0x1934025E.png";

//4
    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_120619.905_0x1FE201D8.png";

    static int y = 586;
    static int cardCount=0;

    public Recognizer() throws IOException {
    }


        static Integer cardCount(String path) throws IOException {

            BufferedImage img = ImageIO.read(new File(path));

//        System.out.println(img.getHeight() + " " + img.getWidth());
            //1166 636 размер картинки
            //146:586 линия с центральными картами
//        int y = 586;
//        for (int x = 0; x < 636; x ++ ) {
//            System.out.println(img.getRGB(x, y) + " " + x);
//
//        }


            for (int x = 0; x < 636; x++) {
                if (img.getRGB(x, y) == -1 || (img.getRGB(x, y) == -678365)) {

                    if (checkCard(x, y, img)) {
                        System.out.println(x + " " + y);
                        cardCount++;
                        x += 60;
                    }


                }
            }
        return cardCount;

    }



    private static boolean checkCard(int x, int y, BufferedImage img) {
        for (int z = x ; z < x + 56; z++) {
            if (img.getRGB(z,y) != -1) {
                return false;
            }
        }
        return true;
    }


}
