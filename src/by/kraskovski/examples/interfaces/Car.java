package by.kraskovski.examples.interfaces;

public interface Car {

    /**
     * Classes can override.
     * Interface may contain more than 1 default method.
     * Can't override {@link Object} methods.
     */
    default void info() {
        System.out.println("Default method in interface");
    }

    default double findSqrt(double number) {
        return Math.sqrt(number);
    }
}
