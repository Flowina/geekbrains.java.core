package homework_5;

public class AppData {
    public String[] getHeader() {
        return header;
    }

    private String[] header;

    public int[][] getRows() {
        return data;
    }

    private int[][] data;

    public AppData(String... headers) {
        this.header = headers;
    }

    public void addRows(int[][] data) throws Exception {
        for (int i = 0; i < data.length; i++) {
            if (data[i].length != this.header.length) {
                throw new Exception("Wrong column length in row " + i);
            }
        }
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("header: ");
        sb.append(String.join(", ", this.header));
        sb.append("\n");
        sb.append("rows: [\n");
        for (int[] row:
             data) {
            sb.append("[" + String.join(", ", AppDataCsv.convertIntArrayToStringArray(row))  + "]\n");
        }
        sb.append("]\n");
        return sb.toString();
    }
}
