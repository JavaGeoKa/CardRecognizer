package Controller;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Finder {

    static Integer plainLength = 0;

    static int[] plainsAndValleys(List<List<Integer>> land) {


        List<Integer> plains = new ArrayList<>();

        for (int i = 0; i < land.size(); i++) {
            for (int j = 0; j < land.get(i).size(); j++) {
                if (land.get(i).get(j) == 0) {
                    plainLength++;
                    findAreaRecursion(i, j, land);
                    plains.add(plainLength);
                    plainLength = 0;
                }
            }
        }

        List <Integer> plainsSorted = plains.stream().sorted().collect(Collectors.toList());

        int[] res = new int[plainsSorted.size()];
        for (int i = 0; i < plainsSorted.size(); i++){
            res[i] = plainsSorted.get(i).intValue();
        }


        return res;


    }


    private static void findAreaRecursion(int i, int j, List<List<Integer>> land) {

        land.get(i).set(j, -1);
        if (j + 1 < land.get(i).size() && land.get(i).get(j + 1) == 0) {
            plainLength ++;
            findAreaRecursion(i, j + 1, land);
        }
        if (j - 1 >= 0 && land.get(i).get(j - 1) == 0) {
            plainLength++;
            findAreaRecursion(i, j - 1, land);
        }
        if (i + 1 < land.size() && land.get(i + 1).get(j) == 0) {
            plainLength++;
            findAreaRecursion(i + 1, j, land);
        }
        if (i - 1 >= 0 && land.get(i - 1).get(j) == 0) {
            plainLength++;
            findAreaRecursion(i - 1, j, land);
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_FILE")));
        Scanner scanner = new Scanner(new FileReader(System.getenv("INPUT_FILE")));

        String a = scanner.nextLine();

        int[] result = plainsAndValleys(inputToMatrix(a));
        String strResult = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        outputWriter.write(strResult);

        outputWriter.close();
        scanner.close();
    }

    private static List<List<Integer>> inputToMatrix(String input) {
        String[] rows = input.split("\\|");
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(input.isEmpty()) {
            return result;
        }

        for(int i = 0; i < rows.length; i++) {
            result.add(new ArrayList<Integer>());

            String[] columns = rows[i].split(" ");

            for(int j = 0; j < columns.length; j++) {
                result.get(i).add(Integer.valueOf(columns[j]));
            }
        }

        return result;
    }
}