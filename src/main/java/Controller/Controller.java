package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {

    static int countFiles =0;
    private static final String DIR_PATH = "/home/g/Downloads/java_test_task/imgs/";


    public static void main(String[] args) throws IOException {

        Files.walk(Paths.get(DIR_PATH))
                .filter(Files::isRegularFile)
                .forEach(i -> {
                    try {
                        System.out.println(i + " -> " + Recognizer.cardCount(i.toString()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    countFiles++;

                });
        System.out.println(countFiles);





    }



}
