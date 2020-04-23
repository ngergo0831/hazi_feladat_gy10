package bar;

public class Person {
  String name;
  final int age;
  AgeGroup ageGroup;

  public void giveBeverage(Guest guest, Beverage beverage) {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public AgeGroup getAgeGroup() {
    return ageGroup;
  }

  public void setAgeGroup(AgeGroup ageGroup) {
    this.ageGroup = ageGroup;
  }

  public Person(String name, int age, AgeGroup ageGroup) {
    if (name == null || name.trim().isEmpty())
      throw new IllegalArgumentException();
    if (age < 0)
      throw new IllegalArgumentException();
    this.age = age;
    this.name = name;
    this.ageGroup = ageGroup;
  }

  @Override
  public String toString() {
    return String.format("%s (%d, %s)", name, age, ageGroup);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Person) || obj == null)
      return false;
    Person person = (Person) obj;
    return this.age == person.getAge() && this.ageGroup.equals(person.getAgeGroup())
        && this.name.equals(person.getName());
  }
}