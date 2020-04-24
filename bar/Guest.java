package bar;

public class Guest extends Person {
  static final Beverage invalidBeverage = new Beverage("none", 0, 0);
  Beverage beverage = invalidBeverage;
  int paidAmount;

  @Override
  public void giveBeverage(Guest guest, Beverage beverage) {
    if (guest.getBeverage() != invalidBeverage) {
      guest.setBeverage(beverage);
      this.setBeverage(invalidBeverage);
    }
  }

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