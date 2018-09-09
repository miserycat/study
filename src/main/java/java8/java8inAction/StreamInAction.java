package java8.java8inAction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamInAction {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brain = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brain, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    //1. Find all transactions in the year 2011 and sort them by value (small to high).
    System.out.println("1 ============================");
    transactions.stream()
        .filter(transaction -> transaction.getYear() == 2011)
        .sorted(Comparator.comparingInt(Transaction::getValue))
        .forEach(System.out::println);

    //2. What are all the unique cities where the traders work?
    System.out.println("2 ============================");
    transactions.stream()
        .map(transaction -> transaction.getTrader().getCity())
        .distinct()
        .forEach(System.out::println);

    //3. Find all the traders from Cambridge and sort them by name.
    System.out.println("3 ============================");
    transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> trader.getCity().equals("Cambridge"))
        .sorted(Comparator.comparing(Trader::getName))
        .forEach(System.out::println);

    //4. Return a string of all traders' names sorted alphabetically.
    System.out.println("4 ============================");
    transactions.stream()
        .map(transaction -> transaction.getTrader().getName())
        .distinct()
        .sorted()
        .reduce((name1, name2) -> name1 + name2)
        .ifPresent(System.out::println);

    //5. Are any traders based in Milan
    System.out.println("5 ============================");
    System.out.println(transactions.stream()
        .allMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));

    //6. Print all transactions' values from the traders living in Cambridge
    System.out.println("6 ============================");
    transactions.stream()
        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
        .map(Transaction::getValue)
        .forEach(System.out::println);

    //7. What is the highest value of all the transactions?
    System.out.println("7 ============================");
    transactions.stream()
        .map(Transaction::getValue)
        .max(Integer::compareTo)
        .ifPresent(System.out::println);

    //8. Find the transaction with the smallest value
    System.out.println("8 ============================");
    transactions.stream()
        .min(Comparator.comparing(Transaction::getValue))
        .ifPresent(System.out::println);
  }

}
