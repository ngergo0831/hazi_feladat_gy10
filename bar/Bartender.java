package bar;

public class Bartender extends Person {
  Bartender(String[] name,int age, AgeGroup ageGroup) throws AgeGroupException {
    super(name, age, ageGroup);
    if (ageGroup != AgeGroup.ADULT)
      throw new AgeGroupException("Only adult bartenders are allowed.");
  }
}