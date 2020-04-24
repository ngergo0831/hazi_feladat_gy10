package bar;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Person {
  String name;
  final int age;
  AgeGroup ageGroup;

  public void giveBeverage(Guest guest, Beverage beverage) {
  }

  public void beverageFileTransformer(File f1, File f2) throws IOException {
    FileReader fileReader = new FileReader(f1);
    FileWriter fileWriter = new FileWriter(f2);
    Scanner scn = new Scanner(fileReader);
    Set<Beverage> set = new HashSet<>();
    List<Beverage> list;
    String[] line;
    while (scn.hasNextLine()) {
      line = scn.nextLine().split(",");
      set.add(new Beverage(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2])));
    }
    list = new ArrayList<>(set);
    Collections.sort(list, new Comparator<Beverage>() {
      @Override
      public int compare(Beverage b1, Beverage b2) {
        return b2.getPrice().compareTo(b1.getPrice());
      }
    });
    list.forEach(beverage -> {
      try {
        fileWriter.append(beverage.toString() + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    fileReader.close();
    fileWriter.close();
    scn.close();
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