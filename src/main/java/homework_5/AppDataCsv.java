package homework_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppDataCsv {
    public static void write(String path, AppData data) {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.println(String.join(";", data.getHeader()));

            for (int[] row : data.getRows()) {
                printWriter.println(String.join(";", convertIntArrayToStringArray(row)));
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static AppData read(String path) {
        ArrayList<int[]> rows = new ArrayList<>();
        AppData result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            boolean isHeader = true;
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                String[] row = tempString.split(";");
                if (isHeader) {
                    result = new AppData(row);
                    isHeader = false;
                } else {
                    rows.add(convertStringArrayToIntArray(row));
                }
            }

            if (rows.size() > 0) {
                int[][] temp = new int[rows.size()][];
                for (int i = 0; i < rows.size(); i++) {
                    temp[i] = rows.get(i);
                }
                result.addRows(temp);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String[] convertIntArrayToStringArray(int[] intArray) {
        String[] strArray = Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        return strArray;
    }

    public static int[] convertStringArrayToIntArray(String[] strArray) {
        int[] intArray = Arrays.stream(strArray)
                .mapToInt(Integer::parseInt)
                .toArray();
        return intArray;
    }
}
