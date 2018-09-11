package java8.java8inAction;

public class NullPointerException {

  public static void main(String[] args) {

  }

  private static String getInuranceNameDeepDoubt(Person person) {
    if (person != null) {
      Car car = person.getCar();
      if (car.getInsurance() != null) {
        Insurance insurance = car.getInsurance();
        if (insurance != null) {
          return insurance.getName();
        }
      }
    }
    return "UNKNOWN";
  }

  private static String getInsuranceNameByMultExit(Person person) {
    final String defaultValue = "UNKNOWN";
    if (person == null) {
      return defaultValue;
    }
    if (person.getCar() == null) {
      return defaultValue;
    }

    if (person.getCar().getInsurance() == null) {
      return defaultValue;
    }
    return person.getCar().getInsurance().getName();
  }

  //will cause NPE
  private static String getInsuranceName(Person person) {
    return person.getCar().getInsurance().getName();
  }

}
