package by.kraskovski.examples.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public static void main(String... args) {
        optionalTypes();
        isPresent();
        ifPresent();
        orElse();
        orElseThrow();
        get();
        withFilter();
        withMap();
    }

    private static void optionalTypes() {
        //Empty Optional container
        Optional<String> empty = Optional.empty();
        //Of some value, can't be null!
        Optional<String> of = Optional.of("string");
        //Of any value, can be null
        Optional<String> ofNullable = Optional.ofNullable(null);
    }

    private static void isPresent() {
        System.out.println(Optional.of("string").isPresent());
        System.out.println(Optional.of(null).isPresent()); //Produce NullPointerException
        System.out.println(Optional.ofNullable(null).isPresent());
    }

    private static void ifPresent() {
        Optional<String> value = Optional.of("string");
        value.ifPresent(s -> System.out.println(value.isPresent()));
    }

    private static void orElse() {
        String nullValue = null;
        String value = Optional.ofNullable(nullValue).orElse("string");
        System.out.println(value);
    }

    private static void orElseThrow() {
        String nullValue = null;
        Optional.ofNullable(nullValue).orElseThrow(IllegalStateException::new);
    }

    private static void get() {
        Optional<String> value = Optional.of("string");
        String result = value.get();
    }

    private static void withFilter() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2017);

        System.out.println(priceIsInRange(new Modem(10.5)));
    }

    private static boolean priceIsInRange(Modem modem2) {
        return Optional.ofNullable(modem2)
                .map(Modem::getPrice)
                .filter(p -> p >= 10)
                .filter(p -> p <= 15)
                .isPresent();
    }

    private static void withMap() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional
                .map(List::size)
                .orElse(0);
        System.out.println(size);

        /////////////////////////////////////////////

        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt.filter(
                pass -> pass.equals("password")).isPresent();
        System.out.println(correctPassword);

        correctPassword = passOpt
                .map(String::trim)
                .filter(pass -> pass.equals("password"))
                .isPresent();
        System.out.println((correctPassword));
    }
}

class Modem {
    private Double price;

    Modem(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}