package homework_1.hindrance;

public abstract class Hindrance {
  public int complex;
  public Hindrance(int complex){
      this.complex = complex;
  }
   public abstract String getInfo();
}
