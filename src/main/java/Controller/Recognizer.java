package Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Recognizer {

    static List<BufferedImage> cards = new ArrayList<>();
    static int y = 590;
    static int x1 = 148;     //202      -54
    static int x2 = 219;     //273      -54
    static int x3 = 291;     //345      -54
    static int x4 = 363;     //417      -54
    static int x5 = 435;     //487      -54
    static int[] positions = {x1, x2, x3, x4, x5};
    static int cardPlace = 0;
    static int cardCount = 0;



    public Recognizer() throws IOException {
    }


        static Integer cardGet(String path) throws IOException {
            System.out.println(cardCount);
            BufferedImage img = ImageIO.read(new File(path));

            for (cardPlace = 0; cardPlace < 5; cardPlace++) {
//                System.out.println("Start with " + positions[cardPlace]);
                cards.add(img.getSubimage(positions[cardPlace], y,54, 80));

            }
            return cardCount;

    }

        static void cardSave() {
            System.out.println(cards.size());
            cards.forEach(i -> {
                try {
                    ImageIO.write(i, "png", new File("./cards/file" + cards.indexOf(i)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    }






    }
