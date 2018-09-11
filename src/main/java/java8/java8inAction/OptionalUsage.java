package java8.java8inAction;

import java.util.Optional;

public class OptionalUsage {
  public static void main(String[] args) {
    Optional<Insurance> insuranceOptional = Optional.empty();
//    insuranceOptional.get();

    Optional<Insurance> insuranceOptional1 = Optional.of(new Insurance());
    insuranceOptional1.get();

    Optional<Insurance> insuranceOptional2 = Optional.ofNullable(null);

    insuranceOptional2.orElseGet(Insurance::new);

    insuranceOptional2.orElse(new Insurance());

    insuranceOptional2.orElseThrow(RuntimeException::new);
    insuranceOptional2.orElseThrow(() -> new RuntimeException("bla bla bla..."));

    insuranceOptional1.filter(insurance -> insurance.getName() != null).get();



  }

  private static String getInsuranceName (Insurance insurance) {
    if (insurance == null) {
      return "unknown";
    }
    return insurance.getName();
  }

  private static String getInsuranceNameByOptional (Insurance insurance) {
    return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknown");
  }

}
