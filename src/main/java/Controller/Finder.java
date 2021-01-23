package Controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Finder {

    static Integer plainLength = 0;

    //========================CARD
    static int w;
    static int h;
    static Set<Color> colorsSetInPicture = new HashSet<>();
    static Map <Color, Integer> colorsMapInPicture = new HashMap<>();
    static Color currentColor;
    static Integer quantityCurrentColor = 0;


    public static String getCardName(BufferedImage i) {

        h = i.getHeight();
        w = i.getWidth();

        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                quantityCurrentColor = 0;
                currentColor = new Color(i.getRGB(y,x));

                colorsMapInPicture.compute(currentColor, (k, v) -> (v == null) ? 1 : v+1);

                }
            }

        colorsMapInPicture.entrySet().stream().forEach(System.out::println);

        return null;
        }








}