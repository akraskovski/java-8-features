package by.kraskovski.foreach;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {

    public static void main(final String... args) {
        List<Integer> integerList = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            integerList.add(index);
        }

        integerList.forEach(System.out::print);
    }
}
