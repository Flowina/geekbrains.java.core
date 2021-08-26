package homework_1.hindrance;

public class Barrier extends Hindrance {
    public Barrier(int complex){
        super(complex);
    }
    public String getInfo(){
        return "Barrier сложность: " + complex;
    }

}
