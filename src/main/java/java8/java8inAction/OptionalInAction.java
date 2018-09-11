package java8.java8inAction;

import java.util.Optional;

public class OptionalInAction {

  public static void main(String[] args) {
    Person person = new Person();
    Car car = new Car();
    Insurance insurance = new Insurance();
    person.setCarOptional(Optional.of(car));
    car.setInsuranceOptional(Optional.of(insurance));
//    insurance.setName("cassie");
    Optional.of(getInsuranceNameByOptional(person)).ifPresent(System.out::println);
  }

  private static String getInsuranceNameByOptional(Person person) {
//    return  Optional.ofNullable(person)
//        .map(Person::getCar)
//        .map(Car::getInsurance)
//        .map(Insurance::getName)
//        .orElse("unknown");

    return Optional.ofNullable(person)
        .flatMap(Person::getCarOptional)
        .flatMap(Car::getInsuranceOptional)
        .map(Insurance::getName)
        .orElse("unknown");

  }

}
