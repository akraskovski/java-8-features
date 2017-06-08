package by.kraskovski.examples.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Stream lifecycle goes on 3 steps:

 - Creating stream
 - Use some operations with stream (filter, order...)
 - Final terminal operation and returning the result.

 */
public class StreamExample {

    private static List<Integer> integerList;
    private static List<String> stringList;
    private static List<Phone> phoneList;

    static {
        integerList = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            integerList.add(index);
        }
    }

    static {
        stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    static {
        phoneList = new ArrayList<>();
        phoneList.add(new Phone("iPhone 6 S", 54000));
        phoneList.add(new Phone("Lumia 950", 45000));
        phoneList.add(new Phone("Samsung Galaxy S 6", 40000));
    }

    public static void main(String... args) {
//        mainFeatures();
//        filterExample();
//        sortedExample();
        mapExample();
//        matchExample();
//        countExample();
//        reduceExample();
    }

    private static void mainFeatures() {
        //Sequential stream
        Stream<Integer> sequentialStream = integerList.stream();

        //Parallel stream
        Stream<Integer> parallelStream = integerList.parallelStream();

        //Parallel stream with filter
        Stream<Integer> highNumbersParallel = integerList
                .parallelStream()
                .filter(integer -> integer > 90);

        Stream<Integer> highNumbersSequential = integerList
                .stream()
                .filter(integer -> integer > 90);

        //Lambda forEach example with parallel stream
        highNumbersParallel.forEach(integer -> System.out.println("Parallel high number: " + integer));

        //Lambda forEach example with sequential stream
        highNumbersSequential.forEach(integer -> System.out.println("Sequential high number: " + integer));
    }

    private static void filterExample() {
        stringList
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        phoneList
                .stream()
                .filter(phone -> phone.getPrice() < 50000)
                .forEach(System.out::println);
    }

    private static void sortedExample() {
        stringList
                .stream()
                .sorted() //stringList still mutable
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    private static void mapExample() {
        stringList
                .stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        phoneList
                .stream()
                .map(phone -> "Phone model: " + phone.getName() + ", Price: " + phone.getPrice())
                .forEach(System.out::println);
    }

    private static void matchExample() {
        boolean anyStartsWithA =
                stringList
                        .stream()
                        .anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartsWithA);

        boolean allStartsWithA =
                stringList
                        .stream()
                        .allMatch(s -> s.startsWith("a"));
        System.out.println(allStartsWithA);

        boolean noneStartsWithZ =
                stringList
                        .stream()
                        .noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);
    }

    private static void countExample() {
        long startsWithA =
                stringList
                        .stream()
                        .filter(s -> s.startsWith("a"))
                        .count();
        System.out.println(startsWithA);
    }

    private static void reduceExample() {
        Optional<String> reduced =
                stringList
                        .stream()
                        .sorted()
                        .reduce((s, s2) -> s + "#" + s2);
        reduced.ifPresent(System.out::print);
    }
}
