package bar;

public class DelayedBartender extends Bartender {
  DelayedBartender(String[] name, int age, AgeGroup ageGroup) throws AgeGroupException {
    super(name, age, ageGroup);
  }

}