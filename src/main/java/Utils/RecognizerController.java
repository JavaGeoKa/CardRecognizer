package Utils;

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
    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_102328.773_0x1FE201D8.png";
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_102622.911_0x1CFF023A.png";
    static List<BufferedImage> cards = new ArrayList<>();
    static List<BufferedImage> minimalCard = new ArrayList<>();
    static List<Integer> backgroundes = new ArrayList<>();


    static int y = 591;
    static int[] positions = {149, 220, 292, 364, 436};
    static int cardPlace = 0;



    public static void main(String[] args) throws IOException {

        BufferedImage img = ImageIO.read(new File(PATH));
        for (cardPlace = 0; cardPlace < 5; cardPlace++) {
            cards.add(img.getSubimage(positions[cardPlace], y,52, 79));
        }
        cardPlace = 0;
        System.out.println("Card in cards -> " + cards.size());


        cards.forEach(item -> {
            minimalCard.add(item.getSubimage(0,0,29, 45));
        });

        //minimalCards calculate backgroundes
        minimalCard.forEach(item -> {
            backgroundes.add(calculateBackgroundes(item));
        });

        backgroundes.forEach(System.out::println);

//        write in file
        minimalCard.forEach(i -> {
            try {
                //write file
                ImageIO.write(i, "png", new File("./cards/minfile" + minimalCard.indexOf(i)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });



    }

    private static Integer calculateBackgroundes(BufferedImage item) {
        int backgroundQuantities = 0;
        for (int k = 0; k < item.getHeight(); k++) {
            for (int l = 0; l < item.getWidth(); l++) {
                if (item.getRGB(l, k) == -1 || item.getRGB(l, k) == -8882056) {
                    backgroundQuantities ++;
                }

            }
        }
        return backgroundQuantities;
    }




}