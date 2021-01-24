package Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trimmer {
    static List<BufferedImage> cards = new ArrayList<>();

    static BufferedImage img;
    static BufferedImage subImg;


    static int y = 591;
    static int[] positions = {149, 220, 292, 364, 436};
    static int cardPlace = 0;
    static int countCards = 0;


    // вырезаю из ссылки изображения и добавление в cards если это карта
    public static void cutCards(String currentImage) throws IOException {
        img = ImageIO.read(new File(currentImage));
        for (cardPlace = 0; cardPlace < 5; cardPlace++) {
            subImg = img.getSubimage(positions[cardPlace], y,29, 45);
            if (checkIsItCard(subImg)) {
                saveCardtoFile(subImg);
                countCards ++;
            }
        }
        cardPlace = 0;

}

    //запись изображений на диск
    public static void saveCardtoFile(BufferedImage subImg) {
            try {
                    ImageIO.write(subImg, "png", new File("./cards/img" + countCards));

            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    //проверка карта или нет
    private static boolean checkIsItCard(BufferedImage i) {
        int backgroundQuantities = 0;
            for (int l = 0; l < i.getWidth(); l++) {
                if (i.getRGB(l, 1) == -1 || i.getRGB(l, 1) == -8882056) {
                    return true;
                }
            }
        return false;
    }



}
