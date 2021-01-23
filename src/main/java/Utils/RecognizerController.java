package Utils;

import Controller.Finder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RecognizerController {

    //1166 636 размер картинки
    //148:589 - > 201:589  / 148 - > 201: 669
    //высота карты  80    //     ширина карты : 53    // отступ 4
    //-8882056 тень    , -1 белый
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_102328.773_0x1FE201D8.png";
    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_102622.911_0x1CFF023A.png";
    static List<BufferedImage> cards = new ArrayList<>();


    static int y = 591;
    static int[] positions = {149, 220, 292, 364, 436};

    static int cardPlace = 0;
    static int cardCount = 0;


    public static void main(String[] args) throws IOException {

        BufferedImage img = ImageIO.read(new File(PATH));
        for (cardPlace = 0; cardPlace < 5; cardPlace++) {
            cards.add(img.getSubimage(positions[cardPlace], y,52, 79));
        }

        System.out.println("Cards in cards -> " + cards.size());


//        write in file
        cards.forEach(i -> {
            try {
                //get background
                getBackground(i);
                //write file
                ImageIO.write(i, "png", new File("./cards/file" + cards.indexOf(i)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }

    private static boolean getBackground(BufferedImage i) {

            for (int k = 0; k < i.getHeight();k ++) {
                for (int l = 0; l < i.getWidth(); l ++) {
                    if (i.getRGB(k, l) != -1 || i.getRGB(k, l) != -8882056 ) {

                    }

                }

            }
        return true;
    }



}