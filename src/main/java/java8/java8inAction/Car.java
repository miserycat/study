package java8.java8inAction;

import java.util.Optional;

public class Car {
  private int price;
  private Insurance insurance;
  private Optional<Insurance> insuranceOptional;

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  public Optional<Insurance> getInsuranceOptional() {
    return insuranceOptional;
  }

  public void setInsuranceOptional(Optional<Insurance> insuranceOptional) {
    this.insuranceOptional = insuranceOptional;
  }
}
