package bar;

public class Beverage {
  String name;
  int price;
  int legalAge;

  public Beverage(String name, int price, int legalAge) {
    if (name == null || name.trim().isEmpty())
      throw new IllegalArgumentException();
    if (price < 0)
      throw new IllegalArgumentException();
    if (legalAge < 0)
      throw new IllegalArgumentException();
    this.name = name;
    this.price = price;
    this.legalAge = legalAge;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getLegalAge() {
    return legalAge;
  }

  public void setLegalAge(int legalAge) {
    this.legalAge = legalAge;
  }

  // 2012 Villanyi Cuvee (35900, 18)
  @Override
  public String toString() {
    return this.name + String.format(" (%d, %d)", this.price, this.legalAge);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Beverage) || obj == null)
      return false;
    Beverage beverage = (Beverage) obj;
    return beverage.getName().equals(this.getName());
  }
}