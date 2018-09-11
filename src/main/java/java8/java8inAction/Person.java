package java8.java8inAction;

import java.util.Optional;

public class Person {

  private String name;
  private Car car;

  private Optional<Car> carOptional;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Optional<Car> getCarOptional() {
    return carOptional;
  }

  public void setCarOptional(Optional<Car> carOptional) {
    this.carOptional = carOptional;
  }
}
