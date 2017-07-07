package by.kraskovski.examples.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String... args) {
        optionalTypes();
        isPresent();
        ifPresent();
        orElse();
        orElseThrow();

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
}
