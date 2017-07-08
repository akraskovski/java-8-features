package by.kraskovski.examples.lambda;

import by.kraskovski.examples.interfaces.functional.Converter;

public class LambdaExpressionsExample {

    public static void main(String... args) {
        withCustomInterface();
        withRunnable();
    }

    private static void withCustomInterface() {
        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

        Expression expr = methodReference();
        System.out.println(sum(nums, expr));
        System.out.println(sum(nums, ExpressionHelper::isEven));
    }

    private static int sum(int[] numbers, Expression expression) {
        int result = 0;
        for (int i : numbers) {
            if (expression.isEqual(i))
                result += i;
        }
        return result;
    }

    private static Expression methodReference() {
        // Standart lambda expression.
        Expression expressionOld = number -> ExpressionHelper.isPositive(number);
        // method reference.
        Expression expressionNew = ExpressionHelper::isPositive;
        Converter<String, Integer> converter = String::length;
        return expressionNew;
    }

    private static void withRunnable() {
        // Old Runnable
        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable one");
            }
        };
        // Lambda Runnable
        final Runnable runnable2 = () -> System.out.println("Runnable two");

        runnable1.run();
        runnable2.run();
    }
}
