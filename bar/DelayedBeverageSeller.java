package bar;

public interface DelayedBeverageSeller {
  public void orderBeverage(Guest guest, Beverage beverage);
  public void beverageReady(Guest guest, Beverage beverage);
}