package Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Recognizer {
    static List<BufferedImage> minimalCard = new ArrayList<>();
    static List<Integer> allBackgroundes = new ArrayList<>();
    static List<Integer> backgroundes = new ArrayList<>();

    static BufferedImage img;

    static int y = 591;
    static int[] positions = {149, 220, 292, 364, 436};
    static int cardPlace = 0;


    //3 вырезаю из ссылки карты
    public static void cutCards(String currentImage) throws IOException {
        img = ImageIO.read(new File(currentImage));
        for (cardPlace = 0; cardPlace < 5; cardPlace++) {
//            minimalCard.add(img.getSubimage(positions[cardPlace], y,29, 45));
            minimalCard.add(img.getSubimage(positions[cardPlace], y,52, 79));
        }
        cardPlace = 0;

        //minimalCards calculate backgroundes
        minimalCard.forEach(item -> calculateBackgroundes(item));
    }

    private static void calculateBackgroundes(BufferedImage item) {
        int backgroundQuantities = 0;
        for (int k = 0; k < item.getHeight(); k++) {
            for (int l = 0; l < item.getWidth(); l++) {
                if (item.getRGB(l, k) == -1 || item.getRGB(l, k) == -8882056) {
                    backgroundQuantities ++;
                }

            }
        }
        if (backgroundQuantities != 0) {
            backgroundes.add(backgroundQuantities);
        }
    }

    public static void saveCardtoFile() {
        minimalCard.forEach(i -> {
            try {
                //write file
                ImageIO.write(i, "png", new File("./cards/minfile" + minimalCard.indexOf(i)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
}
