package exercises;

import common.DataFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import static common.DataFactory.getSuppliedText;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        // unaryoperator

        UnaryOperator<Integer> unaryOutput = a -> a * 5;
        Integer a = 5;

        System.out.println(unaryOutput.apply(a));

        /**
         * please create a unaryoperator<integer> instance that returns its parameter multiplied by 5.
         * after that please use it and return the result.
         */
        // code

        // binaryoperator
        /**
         * please create a binaryoperator<biginteger> instance that returns the sum of its parameters.
         * after that please use it and return the result.
         */
        // code
        BinaryOperator<BigInteger> binaryOperator = BigInteger::add;
        System.out.println(binaryOperator.apply(BigInteger.ONE, BigInteger.TWO));

        // predicate
        /**
         * please create a predicate<string> instance that determines whether passed parameter is empty
         * after that please use it and return the result.
         */
        // code
        Predicate<String> stringPredicate = String::isEmpty;

        System.out.println(stringPredicate.test(""));
        // function
        /**
         * please create a function<list<string>,<string>> instance that will take a list of strings,
         * convert it to array and then convert it to a string.
         * after that please use it and return the result.
         */
        // code
        Function<List<String>,String> stringToArray = list -> {
            System.out.println(list);
            return Arrays.toString(list.toArray());
        };
        String convertedList = stringToArray.apply(Arrays.asList("Ala", "ma", "kota"));

        System.out.println(convertedList);
        System.out.printf("here is string: %s", convertedList);

        System.out.println(genericStringToArraySecond(Arrays.asList("Sierotka", "ma", "rysia")) );
        System.out.println(genericStringToArraySecond(Arrays.asList(1,2,3)) );

        // supplier
        /**
         * please create a supplier<string> that would call on getsuppliedtext() method.
         * after that please use it and return the result.
         */

        Supplier<String> supplier = DataFactory::getSuppliedText;
        String suppliedText = supplier.get();
        // code

        // consumer
        /**
         * please create a consumer<string> that would display the parameter on a console
         */
        // code

        Consumer<String> consumer = s -> System.out.println("A parameter on console: \t" + s);
        consumer.accept("it's works !");
    }

    public static <T> Function<List<T>, String> genericStringToArray(List<T> list) {

        Function<List<T>,String> stringToArray = list1 -> {
            System.out.println(list1);
            return Arrays.toString(list1.toArray()); };


        return  stringToArray;

    }

    public  static <T> String genericStringToArraySecond(List<T> list) {

        return   Arrays.toString(list.toArray()); }
}


