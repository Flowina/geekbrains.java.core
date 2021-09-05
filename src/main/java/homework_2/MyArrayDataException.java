package homework_2;

public class MyArrayDataException extends Exception {
    private int row;
    private int column;
    private String val;

    public MyArrayDataException(int row, int column, String val) {
        super(String.format("неккоректные данные в ячейке[%d, %d]: %s", row, column, val));
        this.row = row;
        this.column = column;
        this.val = val;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getVal() {
        return val;
    }
}
