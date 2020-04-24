package bar;

import java.util.ArrayList;
import java.util.List;

public class DelayedBartender extends Bartender implements DelayedBeverageSeller {
  List<Beverage> readyBeverages = new ArrayList<>();
  List<Beverage> pendingOrders = new ArrayList<>();

  DelayedBartender(String name, int age, AgeGroup ageGroup) throws AgeGroupException {
    super(name, age, ageGroup);
  }

  @Override
  public void orderBeverage(Guest guest, Beverage beverage) {
    boolean contains = false;
    int index = 0;
    Beverage bev;
    while (!contains && index != readyBeverages.size()) {
      bev = readyBeverages.get(index);
      contains = bev.getName().equals(beverage.getName());
      index++;
    }
    if (contains)
      giveBeverage(guest, beverage);
    else
      pendingOrders.add(beverage);

  }

  @Override
  public void beverageReady(Guest guest, Beverage beverage) {
    boolean contains = false;
    int index = 0;
    Beverage bev;
    while (!contains && index != readyBeverages.size()) {
      bev = pendingOrders.get(index);
      contains = bev.getName().equals(beverage.getName());
      index++;
    }
    if (contains) {
      giveBeverage(guest, beverage);
      pendingOrders.remove(index - 1);
    } else
      readyBeverages.add(beverage);

  }
}