package Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorGetter {

    //  3
//  private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_060003.065_0x173E0290.png";

//5
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_064009.827_0x1934025E.png";

//4
    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_102040.520_0x0EDA02B0.png";

    static int y = 590;
    static int cardCount=0;

    public static void main(String[] args) throws IOException {

        BufferedImage img = ImageIO.read(new File(PATH));

        //1166 636 размер картинки
        //148:589 - > 201:589  / 148 - > 201: 669
        //высота карты  80    //     ширина карты : 53    // отступ 4
        //-8882056 тень    , -1 белый

//        -678365 143 -678365 144 -612312 145    //желтый



        for (int x = 0; x < 636; x ++ ) {
            System.out.println(img.getRGB(x, y) + " " + x);

        }







    }



}
