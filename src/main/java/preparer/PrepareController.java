package preparer;

import Controller.Trimmer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareController {

    //ControllerSettings
    static int y = 591;
    static int[] positions = {149, 220, 292, 364, 436};
    static int cardPlace = 0;


    //коллекции карт
    static int countFiles =0;
    private static final String DIR_PATH_RED = "/home/g/IdeaProjects/CardRecognizer/cards/red";
    private static final String DIR_PATH_BLACK = "/home/g/IdeaProjects/CardRecognizer/cards/black";

    //тест файл 5
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_102328.773_0x1FE201D8.png";
//    тест файл 4
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_111814.694_0x1CFF023A.png";
    //тест файл 3
    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_091220.884_0x0EDA02B0.png";


    static List<BufferedImage> currentCards = new ArrayList<>();


    static Map<BufferedImage, String> redCards = new HashMap<>();
    static Map<BufferedImage, String> blackCards = new HashMap<>();

    static BufferedImage img;
    static BufferedImage subImg;


    public static void main(String[] args) throws IOException {

        //загружаем коллекцию красных карт
        Files.walk(Paths.get(DIR_PATH_RED))
                .filter(Files::isRegularFile)
                .forEach(i -> {
                    try {
                        redCards.put(ImageIO.read(new File(i.toString())), i.getFileName().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("Red cards loaded: " + redCards.size());

        //загружаем коллекцию черных карт
        Files.walk(Paths.get(DIR_PATH_BLACK))
                .filter(Files::isRegularFile)
                .forEach(i -> {
                    try {
                        blackCards.put(ImageIO.read(new File(i.toString())), i.getFileName().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("Black cards loaded: " + blackCards.size());


        //загрyжаем скриншот экрана
        img = ImageIO.read(new File(PATH));
        for (cardPlace = 0; cardPlace < 5; cardPlace++) {
             subImg = img.getSubimage(positions[cardPlace], y,29, 45);
            if (checkIsItCard(subImg)) {
                currentCards.add(subImg);
            }
        }
        cardPlace = 0;
        System.out.println("Card on image: " + currentCards.size());


        //Здесь нужно начать сравнивать два изображения





    }

//    || i.getRGB(l, 1) == -8882056
    //проверка карта или нет
    private static boolean checkIsItCard(BufferedImage i) {
        int backgroundQuantities = 0;
        for (int l = 0; l < i.getWidth(); l++) {
            if (i.getRGB(l, 1) == -1 ) {
                return true;
            } else if (i.getRGB(l, 1) == -8882056) {
                    backgroundChanger(i);
                    return true;
                }
            }
        return false;
    }

    //убираю тень
    private static void backgroundChanger(BufferedImage i) {
        for (int k = 0; k < i.getHeight(); k++) {
            for (int l = 0; l < i.getWidth(); l++) {
                if (i.getRGB(l, k) == -8882056) {
                    i.setRGB(l,k,-1);
                }

            }
        }
    }


}
