package java8.java8inAction;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import gc.Person;
import java.util.List;

public class LambdaFuntions {

  public static void main(String[] args) {
    Function<String, Integer> fLambda = String::length;
    Predicate<Person> pLambda = p -> p.getName().equals("cassie");
    List<String> list = Lists.newArrayList("cassie", "jack", "mary");
    Supplier<Person> sLombda = Person::new;



  }



}
