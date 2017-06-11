package by.kraskovski.examples.interfaces.methods;

public interface Java8Interface {

    ///////////////////Default methods//////////////////////

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
    ////////////////////////////////////////////////////////

    ///////////////////Static methods//////////////////////

    /**
     * Call like all statis methods: Classname.method();
     * Can not be overridden.
     */
    static double pow(double number, double pow) {
        return Math.pow(number, pow);
    }
}
