package by.kraskovski.examples.interfaces.functional;

public class ConverterExample {

    public static void main(String... args) {
        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        Converter<String, Integer> converterMethodReference = Integer::valueOf;

        Integer convertedValue = converter.convert("10");
        System.out.println(convertedValue);
    }
}
