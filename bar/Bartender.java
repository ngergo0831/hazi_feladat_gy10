package bar;

public class Bartender extends Person {
  public Bartender(String name, int age, AgeGroup ageGroup) throws AgeGroupException {
    super(name, age, ageGroup);
    if (ageGroup != AgeGroup.ADULT)
      throw new AgeGroupException("Only adult bartenders are allowed.");
  }

  @Override
  public void giveBeverage(Guest guest, Beverage beverage) {
    try {
      if (guest.getAge() < beverage.getLegalAge())
        throw new AgeGroupException("Tul fiatal.");
      guest.setBeverage(beverage);
      guest.increasePaidAmount(beverage.getPrice());
    } catch (AgeGroupException e) {
      e.printStackTrace();
    }
  }
}