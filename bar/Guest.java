package bar;

public class Guest extends Person {
  Beverage beverage = new Beverage("none", 0, 0);
  int paidAmount;
  // static final Beverage;

  public Guest(String name, int age, AgeGroup ageGroup) {
    super(name, age, ageGroup);
  }

  public void increasePaidAmount(int amount) {
    this.paidAmount += amount;
  }

  public Beverage getBeverage() {
    return beverage;
  }

  public void setBeverage(Beverage beverage) {
    this.beverage = beverage;
  }

  public int getPaidAmount() {
    return paidAmount;
  }

  public void setPaidAmount(int paidAmount) {
    this.paidAmount = paidAmount;
  }

}