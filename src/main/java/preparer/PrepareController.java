package preparer;

import Controller.Trimmer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PrepareController {

    //ControllerSettings
    static int y = 591;
    static int[] positions = {149, 220, 292, 364, 436};
    static int cardPlace = 0;


    //коллекции карт
    static int countFiles =0;
    private static final String DIR_PATH_RED = "/home/g/IdeaProjects/CardRecognizer/cards/red";
    private static final String DIR_PATH_BLACK = "/home/g/IdeaProjects/CardRecognizer/cards/black";

    //тест файл 5 {тк, ч, тч, к, чоб }  +
    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_102328.773_0x1FE201D8.png";
//    тест файл 4  {тч, ч, кроб, чоб} +
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_111814.694_0x1CFF023A.png";
    //тест файл 3  {ч, ч, к}
//    private static final String PATH = "/home/g/Downloads/java_test_task/imgs/20180821_091220.884_0x0EDA02B0.png";

    static Map<BufferedImage, String> currentCards = new LinkedHashMap<>();
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
                currentCards.put(subImg, checkColor(subImg));
            }
        }
        cardPlace = 0;
        System.out.println("Card on image: " + currentCards.size());


        //Здесь нужно начать сравнивать два изображения
        currentCards.entrySet().stream().forEach( e -> {
           if (e.getValue() == "black") {
               //стравнить с блек
           } else if (e.getValue() == "red") {
               //сравнить с ред
           }
        });




    }



    //определение цвета карты
    private static String checkColor(BufferedImage i) {
        if (i.getRGB(10,35) == -14474458) {
            return "black";
        } else if (i.getRGB(10,35) == -3323575) {
            return "red";
        }




        return "red";
    }

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
                } else if (i.getRGB(l,k) == -10477022) {
                    i.setRGB(l, k, -3323575);
                } else if (i.getRGB(l,k) == -15724526){
                    i.setRGB(l, k, -14474458);
                }

            }
        }
    }


}
