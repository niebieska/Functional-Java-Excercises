package exercises;

import common.DataFactory;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import static common.DataFactory.getSuppliedText;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        // UnaryOperator
        /**
         * Please create a UnaryOperator<Integer> instance that returns its parameter multiplied by 5.
         * After that please use it and return the result.
         */
        // code

        // BinaryOperator
        /**
         * Please create a BinaryOperator<BigInteger> instance that returns the sum of its parameters.
         * After that please use it and return the result.
         */
        // code

        // Predicate
        /**
         * Please create a Predicate<String> instance that determines whether passed parameter is empty
         * After that please use it and return the result.
         */
        // code

        // Function
        /**
         * Please create a Function<List<String>,<String>> instance that will take a list of strings,
         * convert it to array and then convert it to a string.
         * After that please use it and return the result.
         */
        // code

        // Supplier
        /**
         * Please create a Supplier<String> that would call on getSuppliedText() method.
         * After that please use it and return the result.
         */
        // code

        // Consumer
        /**
         * Please create a Consumer<String> that would display the parameter on a console
         */
        // code
    }
}
