package homework_5;

public class Main {
    public static void main(String[] args) throws Exception {
        AppData appData = new AppData("Value 1", "Value 2", "Value 3");
        appData.addRows(new int[][]{{100, 2000, 300}, {50,70,-80}});
        AppDataCsv.write("file.csv",appData);

        AppData dataFromFile = AppDataCsv.read("file.csv");
        System.out.println(dataFromFile);
    }
}

