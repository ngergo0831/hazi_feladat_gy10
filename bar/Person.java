package bar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
  String name;
  final int age;
  AgeGroup ageGroup;

  public void giveBeverage(Guest guest, Beverage beverage) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  public void beverageFileTransformer(File f1, File f2) throws IOException {
    try (BufferedWriter bw = Files.newBufferedWriter(f2.toPath())) {
      List<Beverage> s = Files.lines(f1.toPath())
      .map(line -> {
        String[] splitted = line.split(",");
        return new Beverage(splitted[0], Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
      })
      .distinct()
      .sorted(Comparator.comparing(Beverage::getPrice))
      .collect(Collectors.toList());
      for (Beverage b : s) {
        bw.write(b.toString());
        bw.write("\n");
      }
    }
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