package preparer;

import Controller.Trimmer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PrepareController {

    static int countFiles =0;
    private static final String DIR_PATH = "/home/g/Downloads/java_test_task/imgs/";
    private static List<String> patchFiles = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        //1 получаем ссылки на файлы
        Files.walk(Paths.get(DIR_PATH))
                .filter(Files::isRegularFile)
                .forEach(i -> {
                    patchFiles.add(i.toString());
                    countFiles++;
                });

        //2 отправляем ссылки на распознавание
        patchFiles.stream().forEach(s -> {
            try {
                Trimmer.cutCards(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        System.out.println("all cards saved -> " + Trimmer.countCards );



    }



}
